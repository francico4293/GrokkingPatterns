import twopointers.TwoSum;
import twopointers.SeparateDuplicates;
import twopointers.SortedSquares;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] result = runSortedSquares();
        System.out.println("Result: " + Arrays.toString(result));
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
}
