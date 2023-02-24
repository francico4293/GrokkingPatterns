package islands;

public class BiggestIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int numRows = grid.length, numCols = grid[0].length;

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (grid[rowIdx][colIdx] == 1) {
                    maxArea = Math.max(maxArea, findIslandArea(grid, rowIdx, colIdx));
                }
            }
        }

        return maxArea;
    }

    private int findIslandArea(int[][] grid, int rowIdx, int colIdx) {
        if (rowIdx < 0 || rowIdx >= grid.length || colIdx < 0 || colIdx >= grid[0].length) {
            return 0;
        }

        if (grid[rowIdx][colIdx] == 0) {
            return 0;
        }

        grid[rowIdx][colIdx] = 0;

        int down = findIslandArea(grid, rowIdx + 1, colIdx);
        int right = findIslandArea(grid, rowIdx, colIdx + 1);
        int up = findIslandArea(grid, rowIdx - 1, colIdx);
        int left = findIslandArea(grid, rowIdx, colIdx - 1);

        return 1 + down + right + up + left;
    }
}
