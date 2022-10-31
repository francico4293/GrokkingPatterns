package mergeintervals;

import java.util.List;
import java.util.ArrayList;

public class IntervalsIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstListIdx = 0, secondListIdx = 0;
        int numIntervalsInFirstList = firstList.length, numIntervalsInSecondList = secondList.length;
        List<int[]> intersectingIntervals = new ArrayList<>();

        while (firstListIdx < numIntervalsInFirstList && secondListIdx < numIntervalsInSecondList) {
            if ((firstList[firstListIdx][0] >= secondList[secondListIdx][1] &&
                    firstList[firstListIdx][1] <= secondList[secondListIdx][1]) ||
                    (secondList[secondListIdx][0] >= firstList[firstListIdx][0] &&
                            secondList[secondListIdx][0] <= firstList[firstListIdx][1])) {
                intersectingIntervals.add(new int[] {
                        Math.max(firstList[firstListIdx][0], secondList[secondListIdx][0]),
                        Math.min(firstList[firstListIdx][1], secondList[secondListIdx][1])
                });
            }

            if (firstList[firstListIdx][1] < secondList[secondListIdx][1]) {
                firstListIdx++;
            } else {
                secondListIdx++;
            }
        }

        return intersectingIntervals.toArray(new int[intersectingIntervals.size()][]);
    }
}
