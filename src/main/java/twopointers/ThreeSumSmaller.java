package twopointers;

import java.util.Arrays;

// nums = [-2,0,1,3], target = 4

public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        int numsLength = nums.length;

        Arrays.sort(nums);

        for (int idx1 = 0; idx1 < numsLength - 2; idx1++) {
            int idx2 = idx1 + 1, idx3 = numsLength - 1;
            while (idx2 < idx3) {
                int currSum = nums[idx1] + nums[idx2] + nums[idx3];

                if (currSum >= target) {
                    idx3--;
                } else {
                    count += (idx3 - idx2);
                    idx2++;
                }
            }
        }

        return count;
    }
}
