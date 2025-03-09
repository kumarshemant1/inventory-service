package app.inventory.entity;

public enum Country {
	IND("INDIA"),
	NZL("NEW ZEALAND"),
	UAE("UNITED ARAB EMIRATES"),
	DE("GERMANY"),
	USA("UNITED STATES OF AMERICA"),
	AT("AUSTRIA"),
	FRA("FRANCE"),
	ITA("ITALY"),
	ROU("ROMANIA");
	
	private final String label;
	
	private Country(String label) {
		this.label = label;
	}
}
