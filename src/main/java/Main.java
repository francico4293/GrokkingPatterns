import twopointers.TwoSum;
import twopointers.SeparateDuplicates;
import twopointers.SortedSquares;
import twopointers.ThreeSum;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> results = runThreeSum();
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
}
