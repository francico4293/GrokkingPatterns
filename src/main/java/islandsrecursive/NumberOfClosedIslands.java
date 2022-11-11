package islandsrecursive;

public class NumberOfClosedIslands {

    public int closedIsland(int[][] grid) {
        int count = 0;
        int numRows = grid.length, numCols = grid[0].length;

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (grid[rowIdx][colIdx] == 0 && depthFirstSearch(grid, rowIdx, colIdx)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean depthFirstSearch(int[][] grid, int rowIdx, int colIdx) {
        if (rowIdx < 0 || rowIdx >= grid.length || colIdx < 0 || colIdx >= grid[0].length) {
            return false;
        }

        if (grid[rowIdx][colIdx] == 1) {
            return true;
        }

        return depthFirstSearch(grid, rowIdx + 1, colIdx) &&
                depthFirstSearch(grid, rowIdx, colIdx + 1) &&
                depthFirstSearch(grid, rowIdx - 1, colIdx) &&
                depthFirstSearch(grid, rowIdx, colIdx - 1);
    }
}
