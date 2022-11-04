package cyclicsort;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class FirstKMissingPositiveNumbers {

    public List<Integer> firstKMissing(int[] nums, int k) {
        int numsLength = nums.length;
        List<Integer> missingPositiveNumbers = new ArrayList<>();
        Set<Integer> positiveNumbersInArray = new HashSet<>();

        int idx = 0;
        while (idx < numsLength) {
            if (nums[idx] > 0 && nums[idx] <= numsLength && nums[idx] != nums[nums[idx] - 1]) {
                swap(nums, idx, nums[idx] - 1);
            } else {
                idx++;
            }
        }

        idx = 0;
        while (k > 0 && idx < numsLength) {
            if (nums[idx] != idx + 1) {
                missingPositiveNumbers.add(idx + 1);
                positiveNumbersInArray.add(nums[idx]);
                k--;
            }

            idx++;
        }

        int missing = numsLength + 1;
        while (k > 0) {
            if (!positiveNumbersInArray.contains(missing)) {
                missingPositiveNumbers.add(missing++);
                k--;
            } else {
                missing++;
            }
        }

        return missingPositiveNumbers;
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
