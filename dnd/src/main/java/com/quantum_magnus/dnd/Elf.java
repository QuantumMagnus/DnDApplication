package com.quantum_magnus.dnd;

public class Elf {
	
	private String lineage;
	private String levelOne;
	private String levelThree;
	private String levelFive;
	
	public Elf(String lineage, String levelOne, String levelThree, String levelFive) {
		this.lineage = lineage;
		this.levelOne = levelOne;
		this.levelThree = levelThree;
		this.levelFive = levelFive;
	}
	
	public String getLineage() {
		return this.lineage;
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
	
	public static Elf[] getElvenLineages() {
		Elf[] result = new Elf[3];
		
		result[0] = new Elf("Drow", "The range of your Darkvision increases to 120 feet. "
				+ "You also know the Dancing Lights cantrip.", "Faerie Fire", "Darkness");
		result[1] = new Elf("High Elf", "You know the Prestidigitation cantrip. Whenever you "
				+ "finish a Long Rest, you can replace that cantrip with a different cantrip "
				+ "from the Wizard spell list.", "Detect Magic", "Misty Step");
		result[2] = new Elf("Wood Elf", "Your Speed increases to 35 feet. You also know "
				+ "the Druidcraft cantrip.", "Longstrider", "Pass without Trace");
		
		return result;
	}
}