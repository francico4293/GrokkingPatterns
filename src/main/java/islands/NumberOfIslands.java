package islands;

import java.util.Stack;

public class NumberOfIslands {
    public static char ZERO = '0';
    public static char ONE = '1';

    public int numIslands(char[][] grid) {
        int count = 0;
        int numRows = grid.length, numCols = grid[0].length;

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (grid[rowIdx][colIdx] == ONE) {
                    count++;
                    depthFirstSearch(grid, rowIdx, colIdx, numRows, numCols);
                }
            }
        }

        return count;
    }

    public void depthFirstSearch(char[][] grid, int rowIdx, int colIdx, int numRows, int numCols) {
        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Stack<int[]> islandCoordinates = new Stack<>();

        islandCoordinates.push(new int[] { rowIdx, colIdx });

        while (!islandCoordinates.isEmpty()) {
            int[] islandCoordinate = islandCoordinates.pop();
            rowIdx = islandCoordinate[0];
            colIdx = islandCoordinate[1];

            if (grid[rowIdx][colIdx] == ZERO) {
                continue;
            }

            grid[rowIdx][colIdx] = ZERO;

            for (int[] direction : directions) {
                int newRowIdx = rowIdx + direction[0];
                int newColIdx = colIdx + direction[1];
                if (newRowIdx >= 0 && newRowIdx < numRows &&
                        newColIdx >= 0 && newColIdx < numCols && grid[newRowIdx][newColIdx] == ONE) {
                    islandCoordinates.push(new int[] { newRowIdx, newColIdx });
                }
            }
        }
    }
}
