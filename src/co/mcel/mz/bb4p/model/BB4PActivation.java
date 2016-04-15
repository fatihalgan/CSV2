package co.mcel.mz.bb4p.model;

import java.io.Serializable;

import com.bridge.likya.bbfp.model.DurationType;

public class BB4PActivation implements Serializable {

	private static final long serialVersionUID = 1530505425013732456L;
	private int duration;
	private DurationType durationType;
	private float volume;
	private CommercialOffer commercialOffer;
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public DurationType getDurationType() {
		return durationType;
	}
	public void setDurationType(DurationType durationType) {
		this.durationType = durationType;
	}
	public float getVolume() {
		return volume;
	}
	public void setVolume(float volume) {
		this.volume = volume;
	}
	public CommercialOffer getCommercialOffer() {
		return commercialOffer;
	}
	public void setCommercialOffer(CommercialOffer commercialOffer) {
		this.commercialOffer = commercialOffer;
	}
}
