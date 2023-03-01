package mergeintervals;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int numberOfIntervals = intervals.length;
        List<int[]> mergedIntervals = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0], end = intervals[0][1];
        for (int idx = 1; idx < numberOfIntervals; idx++) {
            if (end >= intervals[idx][0]) {
                end = Math.max(end, intervals[idx][1]);
            } else {
                mergedIntervals.add(new int[] { start, end });
                start = intervals[idx][0];
                end = intervals[idx][1];
            }
        }

        mergedIntervals.add(new int[] { start, end });

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
