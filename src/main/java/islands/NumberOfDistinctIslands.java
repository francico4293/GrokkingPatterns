package islands;

import java.util.Set;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    private static final char ORIGIN = 'O';
    private static final char DOWN = 'D';
    private static final char UP = 'U';
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    private static final char BACK = 'B';

    public int numDistinctIslands(int[][] grid) {
        Set<String> distinctIslands = new HashSet<>();
        int numRows = grid.length, numCols = grid[0].length;
        boolean[][] visited = new boolean[numRows][numCols];

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (grid[rowIdx][colIdx] == 1 && !visited[rowIdx][colIdx]) {
                    StringBuilder stringBuilder = new StringBuilder();
                    depthFirstSearch(grid, visited, rowIdx, colIdx, ORIGIN, stringBuilder);
                    distinctIslands.add(stringBuilder.toString());
                }
            }
        }

        return distinctIslands.size();
    }

    private void depthFirstSearch(int[][] grid, boolean[][] visited, int rowIdx, int colIdx, char direction,
                                  StringBuilder islandAsString) {
        if (rowIdx < 0 || rowIdx >= grid.length || colIdx < 0 || colIdx >= grid[0].length) {
            return;
        }

        if (grid[rowIdx][colIdx] == 0 || visited[rowIdx][colIdx]) {
            return;
        }

        visited[rowIdx][colIdx] = true;

        islandAsString.append(direction);

        depthFirstSearch(grid, visited, rowIdx + 1, colIdx, DOWN, islandAsString);
        depthFirstSearch(grid, visited, rowIdx, colIdx + 1, RIGHT, islandAsString);
        depthFirstSearch(grid, visited, rowIdx - 1, colIdx, UP, islandAsString);
        depthFirstSearch(grid, visited, rowIdx, colIdx - 1, LEFT, islandAsString);

        islandAsString.append(BACK);
    }
}
