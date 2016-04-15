package csv.dr.domain;

import java.io.Serializable;

public class BillImage implements Serializable {

	private static final long serialVersionUID = 3049889743106339486L;
	
	private Integer ohxAct;
	private byte[] biImage;
	
	public BillImage() {
		super();
	}

	public Integer getOhxAct() {
		return ohxAct;
	}

	public void setOhxAct(Integer ohxAct) {
		this.ohxAct = ohxAct;
	}

	public byte[] getBiImage() {
		return biImage;
	}

	public void setBiImage(byte[] biImage) {
		this.biImage = biImage;
	}
	
	
}
