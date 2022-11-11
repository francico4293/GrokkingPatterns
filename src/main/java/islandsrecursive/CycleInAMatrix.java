package islandsrecursive;

public class CycleInAMatrix {

    public boolean containsCycle(char[][] grid) {
        int numRows = grid.length, numCols = grid[0].length;
        boolean[][] visited = new boolean[numRows][numCols];

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (!visited[rowIdx][colIdx] &&
                        depthFirstSearch(grid, visited, rowIdx, colIdx, rowIdx, colIdx, grid[rowIdx][colIdx])) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean depthFirstSearch(char[][] grid, boolean[][] visited, int rowIdx, int colIdx, int prevRowIdx,
                                    int prevColIdx, char startLetter) {
        if (rowIdx < 0 || rowIdx >= grid.length || colIdx < 0 || colIdx >= grid[0].length) {
            return false;
        }

        if (grid[rowIdx][colIdx] != startLetter) {
            return false;
        }

        if (visited[rowIdx][colIdx]) {
            return true;
        }

        visited[rowIdx][colIdx] = true;

        boolean down = (rowIdx + 1 != prevRowIdx || colIdx != prevColIdx) &&
                depthFirstSearch(grid, visited, rowIdx + 1, colIdx, rowIdx, colIdx, startLetter);
        boolean right = (rowIdx != prevRowIdx || colIdx + 1 != prevColIdx) &&
                depthFirstSearch(grid, visited, rowIdx, colIdx + 1, rowIdx, colIdx, startLetter);
        boolean up = (rowIdx - 1 != prevRowIdx || colIdx != prevColIdx) &&
                depthFirstSearch(grid, visited, rowIdx - 1, colIdx, rowIdx, colIdx, startLetter);
        boolean left = (rowIdx != prevRowIdx || colIdx - 1 != prevColIdx) &&
                depthFirstSearch(grid, visited, rowIdx, colIdx - 1, rowIdx, colIdx, startLetter);

        return down || right || up || left;
    }
}
