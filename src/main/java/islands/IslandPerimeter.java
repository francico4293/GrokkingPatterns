package islands;

import java.util.Stack;

public class IslandPerimeter {

    public static int INIT_GRID_SQUARE_PERIMETER = 4;

    public int islandPerimeter(int[][] grid) {
        int numRows = grid.length, numCols = grid[0].length;

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (grid[rowIdx][colIdx] == 1) {
                    return countPerimeter(grid, rowIdx, colIdx, numRows, numCols);
                }
            }
        }

        return -1;
    }

    public int countPerimeter(int[][] grid, int rowIdx, int colIdx, int numRows, int numCols) {
        int perimeter = 0;
        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Stack<int[]> gridCoordinates = new Stack<>();

        gridCoordinates.push(new int[] { rowIdx, colIdx });

        while (!gridCoordinates.isEmpty()) {
            int[] gridCoordinate = gridCoordinates.pop();
            rowIdx = gridCoordinate[0];
            colIdx = gridCoordinate[1];

            if (grid[rowIdx][colIdx] == 2) {
                continue;
            }

            grid[rowIdx][colIdx] = 2;

            int gridSquarePerimeter = INIT_GRID_SQUARE_PERIMETER;
            for (int[] direction : directions) {
                int newRowIdx = rowIdx + direction[0];
                int newColIdx = colIdx + direction[1];

                if (newRowIdx >= 0 && newRowIdx < numRows && newColIdx >= 0 && newColIdx < numCols) {
                    if (grid[newRowIdx][newColIdx] == 1) {
                        gridCoordinates.push(new int[] { newRowIdx, newColIdx });
                        gridSquarePerimeter--;
                    } else if (grid[newRowIdx][newColIdx] == 2) {
                        gridSquarePerimeter--;
                    }
                }
            }

            perimeter += gridSquarePerimeter;
        }

        return perimeter;
    }
}
