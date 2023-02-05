package twopointers;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int numsLength = nums.length;
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);

        for (int idx1 = 0; idx1 < numsLength - 3; idx1++) {
            if (idx1 > 0 && nums[idx1] == nums[idx1 - 1]) {
                continue;
            }
            for (int idx2 = idx1 + 1; idx2 < numsLength - 2; idx2++) {
                if (idx2 > idx1 + 1 && nums[idx2] == nums[idx2 - 1]) {
                    continue;
                }

                search(nums, idx1, idx2, target, results);
            }
        }

        return results;
    }

    private void search(int[] nums, int idx1, int idx2, int target, List<List<Integer>> results) {
        int numsLength = nums.length;
        int idx3 = idx2 + 1, idx4 = numsLength - 1;

        while (idx3 < idx4) {
            int currSum = nums[idx1] + nums[idx2] + nums[idx3] + nums[idx4];

            if (nums[idx1] >= 0 && nums[idx2] >= 0 && nums[idx3] >= 0 && nums[idx4] >= 0 && currSum < 0) {
                return;
            }

            if (currSum < target) {
                idx3++;
            } else if (currSum > target) {
                idx4--;
            } else {
                results.add(List.of(nums[idx1], nums[idx2], nums[idx3], nums[idx4]));

                idx3++;
                while (idx3 < idx4 && nums[idx3] == nums[idx3 - 1]) {
                    idx3++;
                }

                idx4--;
                while (idx3 < idx4 && nums[idx4] == nums[idx4 + 1]) {
                    idx4--;
                }
            }
        }
    }
}
