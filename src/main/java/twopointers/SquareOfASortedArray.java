package twopointers;

public class SquareOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int numsLength = nums.length;
        int[] sortedSquaresArray = new int[numsLength];
        int left = 0, right = numsLength - 1, idx = numsLength - 1;

        while (left <= right) {
            int leftSquared = nums[left] * nums[left];
            int rightSquared = nums[right] * nums[right];

            if (leftSquared > rightSquared) {
                sortedSquaresArray[idx] = leftSquared;
                left++;
            } else {
                sortedSquaresArray[idx] = rightSquared;
                right--;
            }

            idx--;
        }

        return sortedSquaresArray;
    }
}
