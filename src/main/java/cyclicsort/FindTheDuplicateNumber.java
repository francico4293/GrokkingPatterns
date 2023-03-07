package cyclicsort;

public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int numsLength = nums.length;

        int idx = 0;
        while (idx < numsLength) {
            if (nums[idx] != nums[nums[idx] - 1]) {
                swap(nums, idx, nums[idx] - 1);
            } else {
                idx++;
            }
        }

        for (idx = 0; idx < numsLength; idx++) {
            if (nums[idx] != idx + 1) {
                return nums[idx];
            }
        }

        return -1;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
