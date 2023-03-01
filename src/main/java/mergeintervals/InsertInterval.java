package mergeintervals;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int numberOfIntervals = intervals.length + 1;
        List<int[]> combinedIntervals = combineAndSortIntervals(intervals, newInterval);
        List<int[]> mergedIntervals = new ArrayList<>();

        int start = combinedIntervals.get(0)[0], end = combinedIntervals.get(0)[1];
        for (int idx = 1; idx < numberOfIntervals; idx++) {
            if (end >= combinedIntervals.get(idx)[0]) {
                end = Math.max(end, combinedIntervals.get(idx)[1]);
            } else {
                mergedIntervals.add(new int[] { start, end });
                start = combinedIntervals.get(idx)[0];
                end = combinedIntervals.get(idx)[1];
            }
        }

        mergedIntervals.add(new int[] { start, end });

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    private List<int[]> combineAndSortIntervals(int[][] intervals, int[] newInterval) {
        List<int[]> combinedAndSortedIntervals = new ArrayList<>(Arrays.asList(intervals));

        combinedAndSortedIntervals.add(newInterval);
        combinedAndSortedIntervals.sort((a, b) -> Integer.compare(a[0], b[0]));

        return combinedAndSortedIntervals;
    }
}
