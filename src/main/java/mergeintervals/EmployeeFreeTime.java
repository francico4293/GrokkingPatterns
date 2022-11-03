package mergeintervals;

import utils.Interval;

import java.util.List;
import java.util.ArrayList;

public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> freeTime = new ArrayList<>();
        List<Interval> intervals = createIntervalsListFromEmployeeSchedules(schedule);
        List<Interval> mergedIntervals = mergeAndSortIntervals(intervals);

        int numIntervals = mergedIntervals.size();
        for (int idx = 1; idx < numIntervals; idx++) {
            if (mergedIntervals.get(idx).start >= mergedIntervals.get(idx - 1).end) {
                freeTime.add(new Interval(
                        mergedIntervals.get(idx - 1).end,
                        mergedIntervals.get(idx).start)
                );
            }
        }

        return freeTime;
    }

    public List<Interval> createIntervalsListFromEmployeeSchedules(List<List<Interval>> schedule) {
        List<Interval> intervals = new ArrayList<>();

        for(List<Interval> s : schedule) {
            intervals.addAll(s);
        }

        return intervals;
    }

    public List<Interval> mergeAndSortIntervals(List<Interval> intervals) {
        int numIntervals = intervals.size();
        List<Interval> mergedIntervals = new ArrayList<>();

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (int idx = 1; idx < numIntervals; idx++) {
            if (intervals.get(idx).start <= end) {
                end = Math.max(end, intervals.get(idx).end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = intervals.get(idx).start;
                end = intervals.get(idx).end;
            }
        }

        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }
}
