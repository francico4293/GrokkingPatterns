package mergeintervals;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int numIntervals = intervals.length + 1;
        List<int[]> sortedIntervals = insertAndSortIntervals(intervals, newInterval);
        List<int[]> mergedIntervals = new ArrayList<>();

        int start = sortedIntervals.get(0)[0], end = sortedIntervals.get(0)[1];
        for (int idx = 1; idx < numIntervals; idx++) {
            if (sortedIntervals.get(idx)[0] <= end) {
                end = Math.max(end, sortedIntervals.get(idx)[1]);
            } else {
                mergedIntervals.add(new int[] { start, end });
                start = sortedIntervals.get(idx)[0];
                end = sortedIntervals.get(idx)[1];
            }
        }

        mergedIntervals.add(new int[] { start, end });

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public List<int[]> insertAndSortIntervals(int[][] intervals, int[] newInterval) {
        List<int[]> sortedIntervals = new ArrayList<>(Arrays.asList(intervals));
        sortedIntervals.add(newInterval);

        sortedIntervals.sort((a, b) -> Integer.compare(a[0], b[0]));

        return sortedIntervals;
    }
}
