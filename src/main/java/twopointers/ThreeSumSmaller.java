package twopointers;

import java.util.Arrays;

public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        int numsLength = nums.length;
        int count = 0;

        Arrays.sort(nums);

        for (int idx1 = 0; idx1 < numsLength; idx1++) {
            int idx2 = idx1 + 1, idx3 = numsLength - 1;
            while (idx2 < idx3) {
                int currSum = nums[idx1] + nums[idx2] + nums[idx3];

                if (currSum < target) {
                    count += idx3 - idx2;
                    idx2++;
                } else {
                    idx3--;
                }
            }
        }

        return count;
    }
}
