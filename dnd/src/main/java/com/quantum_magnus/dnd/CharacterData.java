package com.quantum_magnus.dnd;

import java.io.Serializable;

public class CharacterData implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String classIn;
    private String background;
    private String species;
    private int[] abilityScores;

    // Constructors
    public CharacterData() {}

    public String getClassIn() {
        return classIn;
    }

    public void setClassIn(String classIn) {
        this.classIn = classIn;
    }
    
    public String getBackground() {
    		return this.background;
    }
    
    public void setBackground(String background) {
    		this.background = background;
    }
    
    public String getSpecies() {
    		return this.species;
    }
    
    public void setSpecies(String species) {
    		this.species = species;
    }
    
    public int[] getAbilityScores() {
    		return this.abilityScores;
    }
    
    public void setAbilityScores(int[] abilityScores) {
    		this.abilityScores = abilityScores;
    }
    
}