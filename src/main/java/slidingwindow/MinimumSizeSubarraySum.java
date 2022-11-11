package slidingwindow;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int currSum = 0;
        int left = 0;
        int numsLength = nums.length;

        for (int right = 0; right < numsLength; right++) {
            currSum += nums[right];

            while (currSum >= target) {
                minLength = Math.min(minLength, (right - left) + 1);
                currSum -= nums[left++];
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }

        return minLength;
    }
}
