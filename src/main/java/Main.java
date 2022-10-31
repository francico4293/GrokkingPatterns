import twopointers.TwoSum;
import twopointers.SeparateDuplicates;
import twopointers.SortedSquares;
import twopointers.ThreeSum;
import twopointers.ThreeSumClosest;
import twopointers.ThreeSumSmaller;
import twopointers.SubarrayProductLessThanK;
import twopointers.FourSum;
import twopointers.BackspaceStringCompare;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Boolean result = runBackspaceStringCompare();
        System.out.println("Result: " + result);
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
}
