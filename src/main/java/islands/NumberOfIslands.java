package islands;

import java.util.Stack;

public class NumberOfIslands {
    private static final char ZERO = '0';
    private static final char ONE = '1';

    public int numIslands(char[][] grid) {
        int totalIslands = 0;
        int numRows = grid.length, numCols = grid[0].length;

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (grid[rowIdx][colIdx] == ONE) {
                    depthFirstSearch(grid, rowIdx, colIdx);
                    totalIslands++;
                }
            }
        }

        return totalIslands;
    }

    private void depthFirstSearch(char[][] grid, int rowIdx, int colIdx) {
        if (rowIdx < 0 || rowIdx >= grid.length || colIdx < 0 || colIdx >= grid[0].length) {
            return;
        }

        if (grid[rowIdx][colIdx] == ZERO) {
            return;
        }

        grid[rowIdx][colIdx] = ZERO;

        depthFirstSearch(grid, rowIdx + 1, colIdx);
        depthFirstSearch(grid, rowIdx, colIdx + 1);
        depthFirstSearch(grid, rowIdx - 1, colIdx);
        depthFirstSearch(grid, rowIdx, colIdx - 1);
    }
}
