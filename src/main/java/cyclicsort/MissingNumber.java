package cyclicsort;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int numsLength = nums.length;

        int idx = 0;
        while (idx < numsLength) {
            if (nums[idx] < numsLength && nums[idx] != nums[nums[idx]]) {
                swap(nums, idx, nums[idx]);
            } else {
                idx++;
            }
        }

        for (idx = 0; idx < numsLength; idx++) {
            if (nums[idx] != idx) {
                return idx;
            }
        }

        return numsLength;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
