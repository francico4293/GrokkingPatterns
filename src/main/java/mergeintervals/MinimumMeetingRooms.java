package mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
        int numRooms = 0;
        PriorityQueue<Integer> meetings = new PriorityQueue<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] interval : intervals) {
            while (!meetings.isEmpty() && interval[0] >= meetings.peek()) {
                meetings.poll();
            }

            meetings.offer(interval[1]);

            numRooms = Math.max(numRooms, meetings.size());
        }

        return numRooms;
    }
}
