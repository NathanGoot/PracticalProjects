package io.github.nathanvegetable.numbers;

/**
 * Project: Find Cost of Tile to Cover W x H Floor - Calculate the total cost of
 * tile it would take to cover a floor plan of width and height, using a cost
 * entered by the user.
 * 
 * @author NathanVegetable
 *
 */
public class FindCostOfTileToCoverWxHFloor {
	public final int DEFAULT_TILE_WIDTH = 12;
	public final int DEFAULT_TILE_HEIGHT = 12;
	public final int DEFAULT_FLOOR_PLAN_WIDTH = 1500;
	public final int DEFAULT_FLOOR_PLAN_HEIGHT = 1000;

	public double findCostOfDefaultPlan(double tileCost) {
		return findCostOfFloorPlan(tileCost, DEFAULT_TILE_WIDTH, DEFAULT_TILE_HEIGHT, DEFAULT_FLOOR_PLAN_WIDTH,
				DEFAULT_FLOOR_PLAN_HEIGHT);
	}

	public double findCostOfFloorPlan(double tileCost, int tileWidth, int tileHeight, int floorPlanWidth,
			int floorPlanHeight) {
		double tilesWidthNeeded = Math.ceil((double) floorPlanWidth / (double) tileWidth);
		double tilesHeightNeeded = Math.ceil((double) floorPlanHeight / (double) tileHeight);
		double tilesNeeded = tilesWidthNeeded * tilesHeightNeeded;
		return tileCost * tilesNeeded;
	}
}
