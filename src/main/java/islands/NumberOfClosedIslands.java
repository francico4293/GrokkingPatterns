package islands;

import java.util.Stack;

public class NumberOfClosedIslands {

    public int closedIsland(int[][] grid) {
        int numClosedIslands = 0;
        int numRows = grid.length, numCols = grid[0].length;

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (grid[rowIdx][colIdx] == 0 && isClosed(grid, rowIdx, colIdx, numRows, numCols)) {
                    numClosedIslands++;
                }
            }
        }

        return numClosedIslands;
    }

    public boolean isClosed(int[][] grid, int rowIdx, int colIdx, int numRows, int numCols) {
        boolean isIslandClosed = true;
        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Stack<int[]> islandCoordinates = new Stack<>();

        islandCoordinates.push(new int[] { rowIdx, colIdx });

        while (!islandCoordinates.isEmpty()) {
            int[] islandCoordinate = islandCoordinates.pop();
            rowIdx = islandCoordinate[0];
            colIdx = islandCoordinate[1];

            if (rowIdx == 0 || rowIdx == numRows - 1 || colIdx == 0 || colIdx == numCols - 1) {
                isIslandClosed = false;
            }

            if (grid[rowIdx][colIdx] == 1) {
                continue;
            }

            grid[rowIdx][colIdx] = 1;

            for (int[] direction : directions) {
                int newRowIdx = rowIdx + direction[0];
                int newColIdx = colIdx + direction[1];
                if (newRowIdx >= 0 && newRowIdx < numRows && newColIdx >= 0 && newColIdx < numCols &&
                        grid[newRowIdx][newColIdx] == 0) {
                    islandCoordinates.push(new int[] { newRowIdx, newColIdx });
                }
            }
        }

        return isIslandClosed;
    }
}
