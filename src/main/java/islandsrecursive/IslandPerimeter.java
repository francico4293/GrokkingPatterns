package islandsrecursive;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int numRows = grid.length, numCols = grid[0].length;

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (grid[rowIdx][colIdx] == 1) {
                    return depthFirstSearch(grid, rowIdx, colIdx);
                }
            }
        }

        return -1;
    }

    private int depthFirstSearch(int[][] grid, int rowIdx, int colIdx) {
        if (rowIdx < 0 || rowIdx >= grid.length || colIdx < 0 || colIdx >= grid[0].length) {
            return 1;
        }

        if (grid[rowIdx][colIdx] == 0) {
            return 1;
        }

        if (grid[rowIdx][colIdx] == 2) {
            return 0;
        }

        grid[rowIdx][colIdx] = 2;

        int down = depthFirstSearch(grid, rowIdx + 1, colIdx);
        int right = depthFirstSearch(grid, rowIdx, colIdx + 1);
        int up = depthFirstSearch(grid, rowIdx - 1, colIdx);
        int left = depthFirstSearch(grid, rowIdx, colIdx - 1);

        return down + right + up + left;
    }
}
