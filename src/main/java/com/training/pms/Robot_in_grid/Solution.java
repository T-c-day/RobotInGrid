package com.training.pms.Robot_in_grid;

/* 
 * We want the robot to go from top left to bottom right while avoiding columns that are off limits.
 * 
 * grid = [[0,0,0],
           [0,1,0],
           [0,0,0]]
 */

class Solution {
	
	public int robotInGrid(int[][] grid) {
		
		int rows = grid.length;
		int columns = grid[0].length;
		
		
		int [][] diff = new int[rows][columns];
		
		//navigate the rows
		for (int i=0; i < rows; i++) {
			if (grid[i][0] == 1) break;
			diff[i][0]=1;
		}
		
		//repeat process for the columns
		for (int j=0; j < columns; j++) {
			if (grid[0][j] == 1) break;
			diff[0][j]=1;
		}
		
		//time to make the path
		for (int i=1;i<rows; i++) {
			for (int j=1; j < columns; j++) {
				if(grid[i][j] == 1) continue;
				diff[i][j] = diff [i-1][j] + diff[i][j-1];
			}
		}
		return diff[rows-1][columns-1];
	}
}


