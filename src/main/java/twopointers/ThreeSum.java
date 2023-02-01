package twopointers;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int numsLength = nums.length;
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);

        for (int idx = 0; idx < numsLength; idx++) {
            if (idx > 0 && nums[idx] == nums[idx - 1]) {
                continue;
            }

            search(nums, idx, results);
        }

        return results;
    }

    private void search(int[] nums, int idx1, List<List<Integer>> results) {
        int numsLength = nums.length;
        int idx2 = idx1 + 1, idx3 = numsLength - 1;

        while (idx2 < idx3) {
            int currSum = nums[idx1] + nums[idx2] + nums[idx3];

            if (currSum == 0) {
                results.add(List.of(nums[idx1], nums[idx2], nums[idx3]));

                idx2++;
                while (idx2 < idx3 && nums[idx2] == nums[idx2 - 1]) {
                    idx2++;
                }

                idx3--;
                while (idx2 < idx3 && nums[idx3] == nums[idx3 + 1]) {
                    idx3--;
                }
            } else if (currSum > 0) {
                idx3--;
            } else {
                idx2++;
            }
        }
    }
}
