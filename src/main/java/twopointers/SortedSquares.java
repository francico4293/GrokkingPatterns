package twopointers;

public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int numsLength = nums.length;
        int[] sortedSquaresArray = new int[numsLength];
        int idx = numsLength - 1, left = 0, right = numsLength - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                sortedSquaresArray[idx] = leftSquare;
                left++;
            } else {
                sortedSquaresArray[idx] = rightSquare;
                right--;
            }

            idx--;
        }

        return sortedSquaresArray;
    }
}
