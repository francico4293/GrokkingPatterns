package twopointers;

public class MinimumWindowSort {

    public int findUnsortedSubarray(int[] nums) {
        int numsLength = nums.length;

        int left = 0;
        while (left < numsLength - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        if (left == numsLength - 1) {
            return 0;
        }

        int right = numsLength - 1;
        while (nums[right] >= nums[right - 1]) {
            right--;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int idx = left; idx <= right; idx++) {
            min = Math.min(min, nums[idx]);
            max = Math.max(max, nums[idx]);
        }

        while (left > 0 && nums[left - 1] > min) {
            left--;
        }

        while (right < numsLength - 1 && nums[right + 1] < max) {
            right++;
        }

        return right - left + 1;
    }
}
