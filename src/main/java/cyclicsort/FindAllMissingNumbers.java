package cyclicsort;

import java.util.List;
import java.util.ArrayList;

public class FindAllMissingNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int numsLength = nums.length;
        List<Integer> missingNumbers = new ArrayList<>();

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
                missingNumbers.add(idx + 1);
            }
        }

        return missingNumbers;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
