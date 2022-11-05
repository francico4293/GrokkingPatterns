package islands;

import java.util.Stack;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int targetColor = image[sr][sc];
        int numRows = image.length, numCols = image[0].length;
        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Stack<int[]> imageCoordinates = new Stack<>();

        imageCoordinates.push(new int[] { sr, sc });

        while (!imageCoordinates.isEmpty()) {
            int[] imageCoordinate = imageCoordinates.pop();
            sr = imageCoordinate[0];
            sc = imageCoordinate[1];

            if (image[sr][sc] == color) {
                continue;
            }

            image[sr][sc] = color;

            for (int[] direction : directions) {
                int newSr = sr + direction[0];
                int newSc = sc + direction [1];

                if (newSr >= 0 && newSr < numRows && newSc >= 0 && newSc < numCols &&
                        image[newSr][newSc] == targetColor) {
                    imageCoordinates.push(new int[] { newSr, newSc });
                }
            }
        }

        return image;
    }
}
