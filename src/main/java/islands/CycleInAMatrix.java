package islands;

public class CycleInAMatrix {

    public boolean containsCycle(char[][] grid) {
        int numRows = grid.length, numCols = grid[0].length;

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (Character.isLowerCase(grid[rowIdx][colIdx]) &&
                        depthFirstSearch(grid, rowIdx, colIdx, rowIdx, colIdx)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean depthFirstSearch(char[][] grid, int prevRowIdx, int prevColIdx, int currRowIdx, int currColIdx) {
        if (currRowIdx < 0 || currRowIdx >= grid.length || currColIdx < 0 || currColIdx >= grid[0].length) {
            return false;
        }

        if (Character.toLowerCase(grid[currRowIdx][currColIdx]) !=
                Character.toLowerCase(grid[prevRowIdx][prevColIdx])) {
            return false;
        }

        if (Character.isUpperCase(grid[currRowIdx][currColIdx])) {
            return true;
        }

        grid[currRowIdx][currColIdx] = Character.toUpperCase(grid[currRowIdx][currColIdx]);

        boolean down = (prevRowIdx != currRowIdx + 1 || prevColIdx != currColIdx) &&
                depthFirstSearch(grid, currRowIdx, currColIdx, currRowIdx + 1, currColIdx);
        boolean right = (prevRowIdx != currRowIdx || prevColIdx != currColIdx + 1) &&
                depthFirstSearch(grid, currRowIdx, currColIdx, currRowIdx, currColIdx + 1);
        boolean up = (prevRowIdx != currRowIdx - 1 || prevColIdx != currColIdx) &&
                depthFirstSearch(grid, currRowIdx, currColIdx, currRowIdx - 1, currColIdx);
        boolean left = (prevRowIdx != currRowIdx || prevColIdx != currColIdx - 1) &&
                depthFirstSearch(grid, currRowIdx, currColIdx, currRowIdx, currColIdx - 1);

        return down || right || up || left;
    }
}
