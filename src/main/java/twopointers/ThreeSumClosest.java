package twopointers;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int closestDifference = Integer.MAX_VALUE;
        int closestSum = Integer.MAX_VALUE;
        int numsLength = nums.length;

        Arrays.sort(nums);

        for (int idx1 = 0; idx1 < numsLength - 2; idx1++) {
            if (idx1 > 0 && nums[idx1] == nums[idx1 - 1]) {
                continue;
            }

            int idx2 = idx1 + 1, idx3 = numsLength - 1;
            while (idx2 < idx3) {
                int currSum = nums[idx1] + nums[idx2] + nums[idx3];

                if (Math.abs(currSum - target) < closestDifference) {
                    closestDifference = Math.abs(currSum - target);
                    closestSum = currSum;
                }

                if (currSum < target) {
                    idx2++;
                } else if (currSum > target) {
                    idx3--;
                } else {
                    return currSum;
                }
            }
        }

        return closestSum;
    }
}
