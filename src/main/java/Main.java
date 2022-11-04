import mergeintervals.*;

import twopointers.*;

import cyclicsort.*;

import utils.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> results = runFirstKMissingPositiveNumbers();
        System.out.println("Results: " + results);
    }

    public static int[] runTwoSum() {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;

        TwoSum twoSum = new TwoSum();
        return twoSum.twoSum(nums, target);
    }

    public static int runSeparateDuplicates() {
        int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

        SeparateDuplicates separateDuplicates = new SeparateDuplicates();
        return separateDuplicates.removeDuplicates(nums);
    }

    public static int[] runSortedSquares() {
        int[] nums = new int[] { -4, -1, 0, 3, 10 };

        SortedSquares sortedSquares = new SortedSquares();
        return sortedSquares.sortedSquares(nums);
    }

    public static List<List<Integer>> runThreeSum() {
        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };

        ThreeSum threeSum = new ThreeSum();
        return threeSum.threeSum(nums);
    }

    public static int runThreeSumClosest() {
        int[] nums = new int[] { -1, 2, 1, -4 };
        int target = 1;

        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        return threeSumClosest.threeSumClosest(nums, target);
    }

    public static int runThreeSumSmaller() {
        int[] nums = new int[] {3,2,-2,6,2,-2,6,-2,-4,2,3,0,4,4,1};
        int target = 3;

        ThreeSumSmaller threeSumSmaller = new ThreeSumSmaller();
        return threeSumSmaller.threeSumSmaller(nums, target);
    }

    public static int runSubarrayProductLessThanK() {
        int[] nums = new int[] { 10, 5, 2, 6 };
        int k = 100;

        SubarrayProductLessThanK subarrayProductLessThanK = new SubarrayProductLessThanK();
        return subarrayProductLessThanK.numSubarrayProductLessThanK(nums, k);
    }

    public static List<List<Integer>> runFourSum() {
        int[] nums = new int[] { 1, 0, -1, 0, -2, 2 };
        int target = 0;

        FourSum fourSum = new FourSum();
        return fourSum.fourSum(nums, target);
    }

    public static Boolean runBackspaceStringCompare() {
        String s = "ab##";
        String t = "c#d#";

        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        return backspaceStringCompare.backspaceCompare(s, t);
    }

    public static int runMinimumWindowSort() {
        int[] nums = new int[] { 2, 6, 4, 8, 10, 9, 15 };

        MinimumWindowSort minimumWindowSort = new MinimumWindowSort();
        return minimumWindowSort.findUnsortedSubarray(nums);
    }

    public static int[][] runMergeIntervals() {
        int[][] intervals = new int[][] { { 8, 10 }, { 1, 3 }, { 15, 18 }, { 2, 6 } };

        MergeIntervals mergeIntervals = new MergeIntervals();
        return mergeIntervals.merge(intervals);
    }

    public static int[][] runInsertInterval() {
        int[][] intervals = new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = new int[] { 4, 8 };

        InsertInterval insertInterval = new InsertInterval();
        return insertInterval.insert(intervals, newInterval);
    }

    public static int[][] runIntervalsIntersection() {
        int[][] firstList = new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] secondList = new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

        IntervalsIntersection intervalsIntersection = new IntervalsIntersection();
        return intervalsIntersection.intervalIntersection(firstList, secondList);
    }

    public static int runMinimumMeetingRooms() {
        int[][] intervals = new int[][] { { 4, 5 }, { 2, 3 }, { 2, 4 }, { 3, 5 } };

        MinimumMeetingRooms minimumMeetingRooms = new MinimumMeetingRooms();
        return minimumMeetingRooms.minMeetingRooms(intervals);
    }

    public static List<Interval> runEmployeeFreeTime() {
        List<List<Interval>> schedules = new ArrayList<>(
                List.of(
                        List.of(new Interval(1, 3), new Interval(6, 7)),
                        List.of(new Interval(2, 4)),
                        List.of(new Interval(2, 5), new Interval(9, 12))
                )
        );

        EmployeeFreeTime employeeFreeTime = new EmployeeFreeTime();
        return employeeFreeTime.employeeFreeTime(schedules);
    }

    public static void runCyclicSort() {
        int[] nums = new int[] { 2, 6, 4, 3, 1, 5 };

        System.out.println("Before: " + Arrays.toString(nums));

        CyclicSort cyclicSort = new CyclicSort();
        cyclicSort.sort(nums);

        System.out.println("After: " + Arrays.toString(nums));
    }

    public static int runMissingNumber() {
        int[] nums = new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 };

        MissingNumber missingNumber = new MissingNumber();
        return missingNumber.missingNumber(nums);
    }

    public static List<Integer> runFindAllMissingNumbers() {
        int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };

        FindAllMissingNumbers findAllMissingNumbers = new FindAllMissingNumbers();
        return findAllMissingNumbers.findDisappearedNumbers(nums);
    }

    public static int runFindTheDuplicateNumber() {
        int[] nums = new int[] { 3, 1, 3, 4, 2 };

        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        return findTheDuplicateNumber.findDuplicate(nums);
    }

    public static List<Integer> runFindAllDuplicateNumbers() {
        int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };

        FindAllDuplicateNumbers findAllDuplicateNumbers = new FindAllDuplicateNumbers();
        return findAllDuplicateNumbers.findDuplicates(nums);
    }

    public static int runFirstMissingPositive() {
        int[] nums = new int[] { 3, 4, -1, 1 };

        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        return firstMissingPositive.firstMissingPositive(nums);
    }

    public static List<Integer> runFirstKMissingPositiveNumbers() {
        int[] nums = new int[] { -2, -3, 4 };
        int k = 2;

        FirstKMissingPositiveNumbers firstKMissingPositiveNumbers = new FirstKMissingPositiveNumbers();
        return firstKMissingPositiveNumbers.firstKMissing(nums, k);
    }
}
