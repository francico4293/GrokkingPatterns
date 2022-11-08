package islandsrecursive;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        int numRows = grid.length, numCols = grid[0].length;

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (grid[rowIdx][colIdx] == 1) {
                    area = Math.max(area, depthFirstSearch(grid, rowIdx, colIdx));
                }
            }
        }

        return area;
    }

    private int depthFirstSearch(int[][] grid, int rowIdx, int colIdx) {
        if (rowIdx < 0 || rowIdx >= grid.length || colIdx < 0 || colIdx >= grid[0].length) {
            return 0;
        }

        if (grid[rowIdx][colIdx] == 0) {
            return 0;
        }

        grid[rowIdx][colIdx] = 0;

        int area = 1;

        area += depthFirstSearch(grid, rowIdx + 1, colIdx);
        area += depthFirstSearch(grid, rowIdx, colIdx + 1);
        area += depthFirstSearch(grid, rowIdx - 1, colIdx);
        area += depthFirstSearch(grid, rowIdx, colIdx - 1);

        return area;
    }
}
