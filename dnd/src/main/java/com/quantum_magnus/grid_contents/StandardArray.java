package com.quantum_magnus.grid_contents;

import com.quantum_magnus.dnd.DnDKeywords;

public class StandardArray {

	private String classIn;
	private String strength;
	private String dexterity;
	private String constitution;
	private String intelligence;
	private String wisdom;
	private String charisma;
	
	public StandardArray(String classIn, String strength, String dexterity, String constitution, 
			String intelligence, String wisdom, String charisma) {
		this.classIn = classIn;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
	}
	
	public String getClassIn() {
		return this.classIn;
	}
	
	public String getStrength() {
		return this.strength;
	}
	
	public String getDexterity() {
		return this.dexterity;
	}
	
	public String getConstitution() {
		return this.constitution;
	}
	
	public String getIntelligence() {
		return this.intelligence;
	}
	
	public String getWisdom() {
		return this.wisdom;
	}
	
	public String getCharisma() {
		return this.charisma;
	}
	
	public static StandardArray[] getStandardArrayChart() {
		StandardArray[] result = new StandardArray[12];
		
		result[0] = new StandardArray(DnDKeywords.Class.Barbarian.name(), "15", "13", "14", "10", "12", "8");
		result[1] = new StandardArray(DnDKeywords.Class.Bard.name(), "8", "14", "12", "13", "10", "15");
		result[2] = new StandardArray(DnDKeywords.Class.Cleric.name(), "14", "8", "13", "10", "15", "12");
		result[3] = new StandardArray(DnDKeywords.Class.Druid.name(), "8", "12", "14", "13", "15", "10");
		result[4] = new StandardArray(DnDKeywords.Class.Fighter.name(), "15", "14", "13", "8", "10", "12");
		result[5] = new StandardArray(DnDKeywords.Class.Monk.name(), "12", "15", "13", "10", "14", "8");
		result[6] = new StandardArray(DnDKeywords.Class.Paladin.name(), "15", "10", "13", "8", "12", "14");
		result[7] = new StandardArray(DnDKeywords.Class.Ranger.name(), "12", "15", "13", "8", "14", "10");
		result[8] = new StandardArray(DnDKeywords.Class.Rogue.name(), "12", "15", "13", "14", "10", "8");
		result[9] = new StandardArray(DnDKeywords.Class.Sorcerer.name(), "10", "13", "14", "8", "12", "15");
		result[10] = new StandardArray(DnDKeywords.Class.Warlock.name(), "8", "14", "13", "12", "10", "15");
		result[11] = new StandardArray(DnDKeywords.Class.Wizard.name(), "8", "12", "13", "15", "14", "10");
		
		return result;
	}
	
}