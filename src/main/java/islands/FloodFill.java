package islands;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        depthFirstSearch(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void depthFirstSearch(int[][] image, int sr, int sc, int targetColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }

        if (image[sr][sc] != targetColor || image[sr][sc] == newColor) {
            return;
        }

        image[sr][sc] = newColor;

        depthFirstSearch(image, sr + 1, sc, targetColor, newColor);
        depthFirstSearch(image, sr, sc + 1, targetColor, newColor);
        depthFirstSearch(image, sr - 1, sc, targetColor, newColor);
        depthFirstSearch(image, sr, sc - 1, targetColor, newColor);
    }
}
