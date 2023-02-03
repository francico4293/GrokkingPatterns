package twopointers;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int numsLength = nums.length;
        int closestSum = Integer.MAX_VALUE;
        int smallestDifference = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int idx1 = 0; idx1 < numsLength; idx1++) {
            int idx2 = idx1 + 1, idx3 = numsLength - 1;
            while (idx2 < idx3) {
                int currSum = nums[idx1] + nums[idx2] + nums[idx3];
                int difference = Math.abs(currSum - target);

                if (currSum == target) {
                    return currSum;
                } else if (currSum > target) {
                    idx3--;
                } else {
                    idx2++;
                }

                if (difference < smallestDifference) {
                    smallestDifference = difference;
                    closestSum = currSum;
                }
            }
        }

        return closestSum;
    }
}
