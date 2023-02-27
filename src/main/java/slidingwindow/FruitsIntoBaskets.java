package slidingwindow;

import java.util.Map;
import java.util.HashMap;

public class FruitsIntoBaskets {

    public int totalFruit(int[] fruits) {
        int numFruits = fruits.length;
        int windowStart = 0;
        int distinctFruit = 0;
        int maxFruit = 0;
        Map<Integer, Integer> fruitInWindowMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < numFruits; windowEnd++) {
            int currFruitAtWindowEnd = fruits[windowEnd];

            if (fruitInWindowMap.containsKey(currFruitAtWindowEnd)) {
                fruitInWindowMap.put(currFruitAtWindowEnd, fruitInWindowMap.get(currFruitAtWindowEnd) + 1);
            } else {
                fruitInWindowMap.put(currFruitAtWindowEnd, 1);
                distinctFruit++;
            }

            while (distinctFruit > 2) {
                int currFruitAtWindowStart = fruits[windowStart++];

                if (fruitInWindowMap.get(currFruitAtWindowStart) == 1) {
                    fruitInWindowMap.remove(currFruitAtWindowStart);
                    distinctFruit--;
                } else {
                    fruitInWindowMap.put(currFruitAtWindowStart, fruitInWindowMap.get(currFruitAtWindowStart) - 1);
                }
            }

            maxFruit = Math.max(maxFruit, windowEnd - windowStart + 1);
        }

        return maxFruit;
    }
}
