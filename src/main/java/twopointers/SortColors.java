package twopointers;

public class SortColors {

    public void sortColors(int[] nums) {
        int numsLength = nums.length;
        int left = 0, right = numsLength - 1;

        int idx = 0;
        while (idx <= right) {
            if (nums[idx] == 0) {
                swap(nums, idx, left);
                left++;
                idx++;
            } else if (nums[idx] == 1) {
                idx++;
            } else {
                swap(nums, idx, right);
                right--;
            }
        }
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];

        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
