package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int numsLength = nums.length;
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);

        for (int idx1 = 0; idx1 < numsLength - 2; idx1++) {
            if (idx1 > 0 && nums[idx1] == nums[idx1 - 1]) {
                continue;
            }

            search(nums, numsLength, idx1, results);
        }

        return results;
    }

    public void search(int[] nums, int numsLength, int idx1, List<List<Integer>> results) {
        int idx2 = idx1 + 1, idx3 = numsLength - 1;

        while (idx2 < idx3) {
            int currSum = nums[idx1] + nums[idx2] + nums[idx3];

            if (currSum < 0) {
                idx2++;
            } else if (currSum > 0) {
                idx3--;
            } else {
                results.add(List.of(nums[idx1], nums[idx2++], nums[idx3--]));

                while (idx2 < idx3 && nums[idx2] == nums[idx2 - 1]) {
                    idx2++;
                }

                while (idx2 < idx3 && nums[idx3] == nums[idx3 + 1]) {
                    idx3--;
                }
            }
        }
    }
}
