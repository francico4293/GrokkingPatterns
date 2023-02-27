package slidingwindow;

public class MaximumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int numsLength = nums.length;
        int minLength = numsLength + 1;
        int windowStart = 0;
        int sumInWindow = 0;

        for (int windowEnd = 0; windowEnd < numsLength; windowEnd++) {
            sumInWindow += nums[windowEnd];

            while (sumInWindow >= target) {
                sumInWindow -= nums[windowStart++];
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
            }
        }

        return minLength == numsLength + 1 ? 0 : minLength;
    }
}
