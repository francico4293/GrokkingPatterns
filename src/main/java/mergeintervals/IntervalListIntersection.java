package mergeintervals;

import java.util.List;
import java.util.ArrayList;

public class IntervalListIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstListLength = firstList.length, secondListLength = secondList.length;
        int firstListIdx = 0, secondListIdx = 0;
        List<int[]> results = new ArrayList<>();

        while (firstListIdx < firstListLength && secondListIdx < secondListLength) {
            if ((firstList[firstListIdx][0] >= secondList[secondListIdx][0] &&
                    firstList[firstListIdx][0] <= secondList[secondListIdx][1]) ||
                    secondList[secondListIdx][0] >= firstList[firstListIdx][0] &&
                            secondList[secondListIdx][0] <= firstList[firstListIdx][1]) {
                int start = Math.max(firstList[firstListIdx][0], secondList[secondListIdx][0]);
                int end = Math.min(firstList[firstListIdx][1], secondList[secondListIdx][1]);
                results.add(new int[] { start, end });
            }

            if (firstList[firstListIdx][1] < secondList[secondListIdx][1]) {
                firstListIdx++;
            } else {
                secondListIdx++;
            }
        }

        return results.toArray(new int[results.size()][]);
    }
}
