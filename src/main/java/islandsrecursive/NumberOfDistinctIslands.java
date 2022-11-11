package islandsrecursive;

import java.util.Set;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    private static final char ORIGIN = 'O';
    private static final char UP = 'U';
    private static final char DOWN = 'D';
    private static final char RIGHT = 'R';
    private static final char LEFT = 'L';
    private static final char BACK = 'B';

    public int numDistinctIslands(int[][] grid) {
        Set<String> islands = new HashSet<>();
        int numRows = grid.length, numCols = grid[0].length;

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (grid[rowIdx][colIdx] == 1) {
                    StringBuilder islandAsString = new StringBuilder();
                    depthFirstSearch(grid, rowIdx, colIdx, ORIGIN, islandAsString);
                    islands.add(islandAsString.toString());
                }
            }
        }

        return islands.size();
    }

    private void depthFirstSearch(int[][] grid, int rowIdx, int colIdx, char direction, StringBuilder islandAsString) {
        if (rowIdx < 0 || rowIdx >= grid.length || colIdx < 0 || colIdx >= grid[0].length) {
            return;
        }

        if (grid[rowIdx][colIdx] == 0) {
            return;
        }

        grid[rowIdx][colIdx] = 0;

        islandAsString.append(direction);

        depthFirstSearch(grid, rowIdx + 1, colIdx, DOWN, islandAsString);
        depthFirstSearch(grid, rowIdx, colIdx + 1, RIGHT, islandAsString);
        depthFirstSearch(grid, rowIdx - 1, colIdx, UP, islandAsString);
        depthFirstSearch(grid, rowIdx, colIdx - 1, LEFT, islandAsString);

        islandAsString.append(BACK);
    }
}
