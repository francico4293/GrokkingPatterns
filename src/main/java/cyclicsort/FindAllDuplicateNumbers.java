package cyclicsort;

import java.util.List;
import java.util.ArrayList;

public class FindAllDuplicateNumbers {

    public List<Integer> findDuplicates(int[] nums) {
        int numsLength = nums.length;
        List<Integer> duplicateNumbers = new ArrayList<>();

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
                duplicateNumbers.add(nums[idx]);
            }
        }

        return duplicateNumbers;
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
