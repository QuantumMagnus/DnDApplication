package com.quantum_magnus.dnd;

public class DnDKeywords {
	
    public enum Class {
	    	Barbarian,
	    	Bard,
	    	Cleric,
	    	Druid,
	    	Fighter,
	    	Monk,
	    	Paladin,
	    	Ranger,
	    	Rogue,
	    	Sorcerer,
	    	Warlock,
	    	Wizard;
    }
    
    public enum Abilities{
	    	Strength, 
	    	Dexterity, 
	    	Constitution, 
	    	Intelligence, 
	    	Wisdom, 
	    	Charisma
    }
    
    public enum ClassComplexity {
    		Low, Average, High
    }
	
	public enum Background {
		Acolyte, Artisan, Charlatan, Criminal,
		Entertainer, Farmer, Guard, Guide,
		Hermit, Merchant, Noble, Sage,
		Sailor, Scribe, Soldier, Wayfarer
	}
	
	public enum Species {
		Aasimar(true), 
		Dragonborn(true), 
		Dwarf(true),
		Elf(true), 
		Gnome(false), 
		Goliath(true), 
		Halfling(false),
		Human(false), 
		Orc(false), 
		Tiefling(true);
		
		private final boolean levelUpTrait;
		
		private Species(boolean levelUpTrait) {
			this.levelUpTrait = levelUpTrait;
		}
		
		public boolean hasLevelUpTrait() {
			return this.levelUpTrait;
		}
	}
	
	public enum AbilityScoreGenerationMethod {
		StandardArray("Standard Array"), 
		PointCost("Point Cost"), 
		RandomGeneration("Random Generation");
		
		private final String displayName;

	    AbilityScoreGenerationMethod(String displayName) {
	        this.displayName = displayName;
	    }

	    public String getDisplayName() {
	        return this.displayName;
	    }
	}
	
	public enum Alignments {
		LawfulGood("Lawful Good"),
		NeutralGood("Neutral Good"),
		ChaoticGood("Chaotic Good"),
		LawfulNeutral("Lawful Neutral"),
		TrueNeutral("True Neutral"),
		ChaoticNeutral("Chaotic Neutral"),
		LawfulEvil("Lawful Evil"),
		NeutralEvil("Neutral Evil"),
		ChaoticEvil("Chaotic Evil");
		
		private final String displayName;
		
		Alignments(String displayName) {
			this.displayName = displayName;
		}
		
		public String getDisplayName() {
			return this.displayName;
		}
	}
	
}