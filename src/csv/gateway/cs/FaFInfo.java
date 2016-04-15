package csv.gateway.cs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bridge.ena.cs.value.FAFNumber;

public class FaFInfo implements Serializable {

	private String[] fafNumbers = new String[20];
	private List<FAFNumber> fafNumberList;
	
	
	public List<FAFNumber> getFafNumberList() {
		return fafNumberList;
	}

	public void setFafNumberList(List<FAFNumber> fafNumberList) {
		this.fafNumberList = fafNumberList;
		int lastNationalIndex = 0, lastInternationalIndex = 10;
		for(int i=0; i < 20 && i<fafNumberList.size();i++){
			int indicator = fafNumberList.get(i).getIndicator().intValue(); 
			if(indicator == 1) {
				lastNationalIndex++;
				setFAFNumber(lastNationalIndex - 1, fafNumberList.get(i).getMsisdn());
			} else if(indicator == 2) {
				lastInternationalIndex++;
				setFAFNumber(lastInternationalIndex - 1, fafNumberList.get(i).getMsisdn());
			}			
		}
	}

	public void setFAFNumber(int fafNo, String msisdn) {
		fafNumbers[fafNo] = msisdn;
	}

	public String[] getFafNumbers() {
		return fafNumbers;
	}

	public void setFafNumbers(String[] fafNumbers) {
		this.fafNumbers = fafNumbers;
	}
	
	public List<String> getFafNumbersToDelete() {
		List<String> numsToDelete = new ArrayList<String>();
		List<String> newFafList = new ArrayList<String>(Arrays.asList(fafNumbers));
		for(FAFNumber fafNum : fafNumberList) {
			String num = fafNum.getMsisdn();
			if(!newFafList.contains(num)) numsToDelete.add(num);
		}
		return numsToDelete;
	}
	
	private List<String> getMsisdnsFromFaFNumberList() {
		List<String> nums = new ArrayList<String>();
		for(FAFNumber num : fafNumberList) {
			nums.add(num.getMsisdn());
		}
		return nums;
	}
	
	public List<String> getFafNumbersToAdd() {
		List<String> numsToAdd = new ArrayList<String>();
		List<String> compareList = getMsisdnsFromFaFNumberList();
		for(int i = 0; i < fafNumbers.length; i++) {
			if(fafNumbers[i] == null || fafNumbers[i].length() == 0) continue;
			if(!compareList.contains(fafNumbers[i])) numsToAdd.add(fafNumbers[i]);
		}
		return numsToAdd;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < fafNumbers.length; i++) {
			if(fafNumbers[i] != null) builder.append("[" + fafNumbers[i] + "] ");
		}
		return builder.toString();
	}
}
