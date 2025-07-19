package com.quantum_magnus.tables;

public class Tiefling {

	private String legacy;
	private String levelOne;
	private String levelThree;
	private String levelFive;
	
	public Tiefling(String legacy, String levelOne, String levelThree, String levelFive) {
		this.legacy = legacy;
		this.levelOne = levelOne;
		this.levelThree = levelThree;
		this.levelFive = levelFive;
	}
	
	public String getLegacy() {
		return this.legacy;
	}
	
	public String getLevelOne() {
		return this.levelOne;
	}
	
	public String getLevelThree() {
		return this.levelThree;
	}
	
	public String getLevelFive() {
		return this.levelFive;
	}
	
	public static Tiefling[] getTieflingLegacies() {
		Tiefling[] result = new Tiefling[3];
		
		result[0] = new Tiefling("Abyssal", "You have Resistance to Poison damage. You also know "
				+ "the Poison Spray cantrip.","Ray of Sickness", "Hold Person");
		result[1] = new Tiefling("Chthonic", "You have Resistance to Necrotic damage. You also "
				+ "know the Chill Touch cantrip.", "False Life", "Ray of Enfeeblement");
		result[2] = new Tiefling("Infernal", "You have Resistance to Fire damage. You also know "
				+ "the Fire Bolt cantrip.", "Hellish Rebuke", "Darkness");
		
		return result;
	}
	
}
