package twopointers;

public class SortColors {

    public void sortColors(int[] nums) {
        int numsLength = nums.length;
        int left = 0, idx = 0, right = numsLength - 1;

        while (idx <= right) {
            int currColor = nums[idx];

            if (currColor == 0) {
                swap(nums, left, idx);
                left++;
                idx++;
            } else if (currColor == 1) {
                idx++;
            } else {
                swap(nums, right, idx);
                right--;
            }
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
