package io.github.nathanvegetable.numbers;

import java.util.Scanner;

/**
 * Project: Find Cost of Tile to Cover W x H Floor - Calculate the total cost of
 * tile it would take to cover a floor plan of width and height, using a cost
 * entered by the user.
 * 
 * @author NathanVegetable
 *
 */
public class FindCostOfTileToCoverWxHFloor {
	public static final int DEFAULT_TILE_WIDTH = 12;
	public static final int DEFAULT_TILE_HEIGHT = 12;
	public static final int DEFAULT_FLOOR_PLAN_WIDTH = 1500;
	public static final int DEFAULT_FLOOR_PLAN_HEIGHT = 1000;

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter the cost of tiles: ");
		double cost = inputScanner.nextDouble();
		cost = FindCostOfTileToCoverWxHFloor.findCostOfDefaultPlan(cost);
		System.out.println("For a floor plan with " + DEFAULT_FLOOR_PLAN_WIDTH + " width, " + DEFAULT_FLOOR_PLAN_HEIGHT
				+ " height");
		System.out.println("Using tiles that are " + DEFAULT_TILE_WIDTH + "x" + DEFAULT_TILE_HEIGHT);
		System.out.println("The total cost is $" + cost);
		inputScanner.close();
	}

	/**
	 * Uses {@link #DEFAULT_TILE_HEIGHT}, {@link #DEFAULT_TILE_WIDTH},
	 * {@link #DEFAULT_FLOOR_PLAN_WIDTH} and {@link #DEFAULT_FLOOR_PLAN_HEIGHT} with
	 * a custom <b>tileCost</b> and finds the total cost.
	 * 
	 * @param tileCost
	 *            The cost for each tile
	 * @return How much it would cost to fill the entire floor plan with tiles
	 * @see {@link #findCostOfFloorPlan(double, int, int, int, int)}
	 */
	public static double findCostOfDefaultPlan(double tileCost) {
		return findCostOfFloorPlan(tileCost, DEFAULT_TILE_WIDTH, DEFAULT_TILE_HEIGHT, DEFAULT_FLOOR_PLAN_WIDTH,
				DEFAULT_FLOOR_PLAN_HEIGHT);
	}

	/**
	 * 
	 * @param tileCost
	 *            The cost for each tile
	 * @param tileWidth
	 *            The width of each tile
	 * @param tileHeight
	 *            The height of each tile
	 * @param floorPlanWidth
	 *            The entire floor plan's width
	 * @param floorPlanHeight
	 *            The entire floor plan's height
	 * @return How much it would cost to fill the entire floor plan with tiles
	 */
	public static double findCostOfFloorPlan(double tileCost, int tileWidth, int tileHeight, int floorPlanWidth,
			int floorPlanHeight) {
		double tilesWidthNeeded = Math.ceil((double) floorPlanWidth / (double) tileWidth);
		double tilesHeightNeeded = Math.ceil((double) floorPlanHeight / (double) tileHeight);
		double tilesNeeded = tilesWidthNeeded * tilesHeightNeeded;
		return tileCost * tilesNeeded;
	}
}
