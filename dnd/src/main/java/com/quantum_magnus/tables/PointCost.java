package com.quantum_magnus.tables;

public class PointCost {

	private String score;
	private String cost;
	
	public PointCost(String score, String cost) {
		this.score = score;
		this.cost = cost;
	}
	
	public String getScore() {
		return this.score;
	}
	
	public String getCost() {
		return this.cost;
	}
	
	public static PointCost[] getPointCostFirstHalf() {
		PointCost result[] = new PointCost[4];
		
		result[0] = new PointCost("8", "0");
		result[1] = new PointCost("9", "1");
		result[2] = new PointCost("10", "2");
		result[3] = new PointCost("11", "3");
		
		return result;
	}
	
	public static PointCost[] getPointCostSecondHalf() {
		PointCost result[] = new PointCost[4];

		result[0] = new PointCost("12", "4");
		result[1] = new PointCost("13", "5");
		result[2] = new PointCost("14", "7");
		result[3] = new PointCost("15", "9");
		
		return result;
	}
	
}