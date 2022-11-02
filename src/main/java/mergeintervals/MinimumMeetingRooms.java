package mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
        int minRoomsNeeded = 0;
        PriorityQueue<Integer> meetingsInProcess = new PriorityQueue<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] interval : intervals) {
            while (!meetingsInProcess.isEmpty() && meetingsInProcess.peek() <= interval[0]) {
                meetingsInProcess.poll();
            }

            meetingsInProcess.offer(interval[1]);

            minRoomsNeeded = Math.max(minRoomsNeeded, meetingsInProcess.size());
        }

        return minRoomsNeeded;
    }
}
