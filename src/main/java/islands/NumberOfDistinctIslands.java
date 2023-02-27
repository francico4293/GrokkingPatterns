package islands;

import java.util.Set;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    private static final String ORIGIN = "O";
    private static final String LEFT = "L";
    private static final String RIGHT = "R";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String BACK = "B";

    public int numDistinctIslands(int[][] grid) {
        Set<String> islands = new HashSet<>();
        int numRows = grid.length, numCols = grid[0].length;

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx< numCols; colIdx++) {
                if (grid[rowIdx][colIdx] == 1) {
                    StringBuilder islandPattern = new StringBuilder(ORIGIN);
                    depthFirstSearch(grid, rowIdx, colIdx, islandPattern);
                    islands.add(islandPattern.toString());
                }
            }
        }

        return islands.size();
    }

    private void depthFirstSearch(int[][] grid, int rowIdx, int colIdx, StringBuilder islandPattern) {
        if (rowIdx < 0 || rowIdx >= grid.length || colIdx < 0 || colIdx >= grid[0].length) {
            return;
        }

        if (grid[rowIdx][colIdx] == 0) {
            return;
        }

        grid[rowIdx][colIdx] = 0;

        depthFirstSearch(grid, rowIdx + 1, colIdx, islandPattern.append(DOWN));
        depthFirstSearch(grid, rowIdx, colIdx + 1, islandPattern.append(RIGHT));
        depthFirstSearch(grid, rowIdx - 1, colIdx, islandPattern.append(UP));
        depthFirstSearch(grid, rowIdx, colIdx - 1, islandPattern.append(LEFT));

        islandPattern.append(BACK);
    }
}
