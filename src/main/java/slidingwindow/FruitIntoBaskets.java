package slidingwindow;

import java.util.Map;
import java.util.HashMap;

public class FruitIntoBaskets {
    public static final int MAX_DISTINCT_FRUIT = 2;

    public int totalFruit(int[] fruits) {
        int left = 0;
        int distinctFruitCount = 0;
        int numFruits = fruits.length;
        int maxNumberOfFruit = 0;
        Map<Integer, Integer> distinctFruitInWindow = new HashMap<>();

        for (int right = 0; right < numFruits; right++) {
            int currFruit = fruits[right];

            if (distinctFruitInWindow.containsKey(currFruit)) {
                distinctFruitInWindow.put(currFruit, distinctFruitInWindow.get(currFruit) + 1);
            } else {
                distinctFruitInWindow.put(currFruit, 1);
                distinctFruitCount++;
            }

            while (distinctFruitCount > MAX_DISTINCT_FRUIT) {
                currFruit = fruits[left++];

                if (distinctFruitInWindow.get(currFruit) == 1) {
                    distinctFruitInWindow.remove(currFruit);
                    distinctFruitCount--;
                } else {
                    distinctFruitInWindow.put(currFruit, distinctFruitInWindow.get(currFruit) - 1);
                }
            }

            maxNumberOfFruit = Math.max(maxNumberOfFruit, (right - left) + 1);
        }

        return maxNumberOfFruit;
    }
}
