package csv.gateway.hlr;

import com.bridge.arete.ema.model.AUCSub;
import com.bridge.arete.ema.model.HLRSub;
import com.bridge.arete.ema.serializer.EmaResponse;
import com.bridge.arete.ema.serializer.EmaResponseAdapter;

public class EMAResponseAdapter {
	
	public static HLRSub getHLRSub(EmaResponse resp) {
		EmaResponseAdapter respAdapter = new EmaResponseAdapter();
		if(0 != resp.getResponseCode()){
			throw new RuntimeException("Ema Get:HLRSUB Command Exception. RetCode = " + resp.getResponseCode());
		}
		HLRSub hlrSub = new HLRSub();
		hlrSub.setBaoc(respAdapter.getBaoc(resp));
		hlrSub.setCfu(respAdapter.getCfu(resp));
		hlrSub.setClip(respAdapter.getClip(resp));
		hlrSub.setClir(respAdapter.getClir(resp));
		hlrSub.setGprs(respAdapter.getGprs(resp));
		hlrSub.setMpty(respAdapter.getMpty(resp));
		hlrSub.setNam(respAdapter.getNam(resp));
		hlrSub.setObi(respAdapter.getObi(resp));
		hlrSub.setObo(respAdapter.getObo(resp));
		hlrSub.setApnIDs(respAdapter.getApnIDs(resp));
		hlrSub.setBaic(respAdapter.getBaic(resp));
		hlrSub.setBs3g(respAdapter.getBs3g(resp));
		hlrSub.setImsi(respAdapter.getImsi(resp));
		hlrSub.setCsp(respAdapter.getCsp(resp));
		hlrSub.setMsisdn(respAdapter.getMsisdn(resp));
		hlrSub.setObr(respAdapter.getObr(resp));
		hlrSub.setPdpcp(respAdapter.getPdpcp(resp));
		hlrSub.setOsb2(respAdapter.getOSB2(resp));
		return hlrSub;
	}
	
	public static AUCSub getAUCSub(EmaResponse resp) {
		EmaResponseAdapter respAdapter = new EmaResponseAdapter();
		if(0 != resp.getResponseCode()){
			throw new RuntimeException("Ema Get:AUCSUB Command Exception. RetCode = " + resp.getResponseCode());
		}
		AUCSub aucSub = new AUCSub();
		aucSub.setA38(respAdapter.getA38(resp));
		aucSub.setA4(respAdapter.getA4(resp));
		aucSub.setAdKey(respAdapter.getAdKey(resp));
		aucSub.setAkaType(respAdapter.getAkaType(resp));
		aucSub.setImsi(respAdapter.getImsi(resp));
		aucSub.setKi(respAdapter.getKi(resp));
		return aucSub;
	}
}
