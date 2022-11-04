package islands;

import java.util.Stack;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int numRows = grid.length, numCols = grid[0].length;

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (grid[rowIdx][colIdx] == 1) {
                    maxArea = Math.max(
                            maxArea,
                            depthFirstSearch(grid, rowIdx, colIdx, numRows, numCols)
                    );
                }
            }
        }

        return maxArea;
    }

    public int depthFirstSearch(int[][] grid, int rowIdx, int colIdx, int numRows, int numCols) {
        int area = 0;
        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Stack<int[]> islandCoordinates = new Stack<>();

        islandCoordinates.push(new int[] { rowIdx, colIdx });

        while (!islandCoordinates.isEmpty()) {
            int[] islandCoordinate = islandCoordinates.pop();
            rowIdx = islandCoordinate[0];
            colIdx = islandCoordinate[1];

            if (grid[rowIdx][colIdx] == 0) {
                continue;
            }

            grid[rowIdx][colIdx] = 0;
            area++;

            for (int[] direction : directions) {
                int newRowIdx = rowIdx + direction[0];
                int newColIdx = colIdx + direction[1];
                if (newRowIdx >= 0 && newRowIdx < numRows &&
                        newColIdx >= 0 && newColIdx < numCols && grid[newRowIdx][newColIdx] == 1) {
                    islandCoordinates.push(new int[] { newRowIdx, newColIdx });
                }
            }
        }

        return area;
    }
}
