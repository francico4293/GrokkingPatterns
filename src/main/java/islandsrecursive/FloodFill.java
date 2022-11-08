package islandsrecursive;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        depthFirstSearch(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void depthFirstSearch(int[][] image, int rowIdx, int colIdx, int color, int targetColor) {
        if (rowIdx < 0 || rowIdx >= image.length || colIdx < 0 || colIdx >= image[0].length) {
            return;
        }

        if (image[rowIdx][colIdx] == color) {
            return;
        }

        if (image[rowIdx][colIdx] != targetColor) {
            return;
        }

        image[rowIdx][colIdx] = color;

        depthFirstSearch(image, rowIdx + 1, colIdx, color, targetColor);
        depthFirstSearch(image, rowIdx, colIdx + 1, color, targetColor);
        depthFirstSearch(image, rowIdx - 1, colIdx, color, targetColor);
        depthFirstSearch(image, rowIdx, colIdx - 1, color, targetColor);
    }
}
