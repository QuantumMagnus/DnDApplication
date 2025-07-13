package com.quantum_magnus.grid_contents;

public class Dragonborn {
	
	private String ancestor;
	private String element;
	
	public Dragonborn(String ancestor, String element) {
		this.ancestor = ancestor;
		this.element = element;
	}
	
	public String getAncestor() {
		return this.ancestor;
	}
	
	public String getElement() {
		return this.element;
	}
	
	public static Dragonborn[] getDragonbornFirstHalf() {
		Dragonborn[] result = new Dragonborn[5];
		
		result[0] = new Dragonborn("Black", "Acid");
		result[1] = new Dragonborn("Blue", "Lightning");
		result[2] = new Dragonborn("Brass", "Fire");
		result[3] = new Dragonborn("Bronze", "Lightning");
		result[4] = new Dragonborn("Copper", "Acid");
		
		return result;
	}
	
	public static Dragonborn[] getDragonbornSecondHalf() {
		Dragonborn[] result = new Dragonborn[5];
		
		result[0] = new Dragonborn("Gold", "Fire");
		result[1] = new Dragonborn("Green", "Poison");
		result[2] = new Dragonborn("Red", "Fire");
		result[3] = new Dragonborn("Silver", "Cold");
		result[4] = new Dragonborn("White", "Cold");
		
		return result;
	}
	
}