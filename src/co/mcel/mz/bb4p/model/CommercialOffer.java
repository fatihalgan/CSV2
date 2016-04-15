package co.mcel.mz.bb4p.model;

public enum CommercialOffer {
	
	BBDIA("BBDIA"),
	BBLSEM("BBLSEM"),
	BBL1("BBL1"),
	BB1("BB1"),
	BB3("BB3"),
	BB6("BB6"),
	BB12("BB12"),
	BBSEM("BBSEM"),
	BBDUO("BBDUO"),
	BBE1("BBE1"),
	BBE3("BBE3"),
	BBE6("BBE6"),
	BBE12("BBE12"),
	BBESEM("BBESEM"),
	BBEDUO("BBEDUO"),
	;
	
	private String comOffer;
	
	private CommercialOffer(String offer) {
		this.comOffer = offer;
	}
	
	public String getLabel() {
		return comOffer;
	}
	
	public String toString() {
		return comOffer;
	}
	
}
