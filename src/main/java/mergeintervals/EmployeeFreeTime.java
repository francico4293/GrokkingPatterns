package mergeintervals;

import helpers.Interval;

import java.util.List;
import java.util.ArrayList;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> combinedAndSortedSchedules = combineAndSortSchedules(schedule);
        List<Interval> mergedSchedules = mergeSchedules(combinedAndSortedSchedules);
        return findEmployeeFreeTime(mergedSchedules);
    }

    private List<Interval> combineAndSortSchedules(List<List<Interval>> schedules) {
        List<Interval> combinedAndSortedSchedules = new ArrayList<>();

        for (List<Interval> schedule : schedules) {
            combinedAndSortedSchedules.addAll(schedule);
        }

        combinedAndSortedSchedules.sort((a, b) -> Integer.compare(a.start, b.start));

        return combinedAndSortedSchedules;
    }

    private List<Interval> mergeSchedules(List<Interval> schedules) {
        int numberOfSchedules = schedules.size();
        List<Interval> mergedSchedules = new ArrayList<>();

        int start = schedules.get(0).start, end = schedules.get(0).end;
        for (int idx = 1; idx < numberOfSchedules; idx++) {
            if (end >= schedules.get(idx).start) {
                end = Math.max(end, schedules.get(idx).end);
            } else {
                mergedSchedules.add(new Interval(start, end));
                start = schedules.get(idx).start;
                end = schedules.get(idx).end;
            }
        }

        mergedSchedules.add(new Interval(start, end));

        return mergedSchedules;
    }

    private List<Interval> findEmployeeFreeTime(List<Interval> schedules) {
        int numberOfSchedules = schedules.size();
        List<Interval> freeTime = new ArrayList<>();

        for (int idx = 0; idx < numberOfSchedules - 1; idx++) {
            freeTime.add(new Interval(schedules.get(idx).end, schedules.get(idx + 1).start));
        }

        return freeTime;
    }
}
