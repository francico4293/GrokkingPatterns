package cyclicsort;

public class SmallestMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int numsLength = nums.length;

        int idx = 0;
        while (idx < numsLength) {
            if (nums[idx] > 0 && nums[idx] <= numsLength && nums[idx] != nums[nums[idx] - 1]) {
                swap(nums, idx, nums[idx] - 1);
            } else {
                idx++;
            }
        }

        for (idx = 0; idx < numsLength; idx++) {
            if (nums[idx] != idx + 1) {
                return idx + 1;
            }
        }

        return numsLength + 1;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
