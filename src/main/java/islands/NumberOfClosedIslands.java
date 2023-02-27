package islands;

public class NumberOfClosedIslands {

    public int closedIsland(int[][] grid) {
        int numberOfClosedIslands = 0;
        int numRows = grid.length, numCols = grid[0].length;

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (grid[rowIdx][colIdx] == 0 && isClosed(grid, rowIdx, colIdx)) {
                    numberOfClosedIslands++;
                }
            }
        }

        return numberOfClosedIslands;
    }

    private boolean isClosed(int[][] grid, int rowIdx, int colIdx) {
        if (grid[rowIdx][colIdx] == 1) {
            return true;
        }

        if (rowIdx == 0 || rowIdx == grid.length - 1 || colIdx == 0 || colIdx == grid[0].length - 1) {
            return false;
        }

        grid[rowIdx][colIdx] = 1;

        boolean up = isClosed(grid, rowIdx + 1, colIdx);
        boolean right = isClosed(grid, rowIdx, colIdx + 1);
        boolean down = isClosed(grid, rowIdx - 1, colIdx);
        boolean left = isClosed(grid, rowIdx, colIdx - 1);

        return up && right && down && left;
    }
}
