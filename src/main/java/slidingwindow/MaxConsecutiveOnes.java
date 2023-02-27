package slidingwindow;

public class MaxConsecutiveOnes {

    public int longestOnes(int[] nums, int k) {
        int numsLength = nums.length;
        int windowStart = 0;
        int longestSubarray = 0;
        int zerosInWindow = 0;

        for (int windowEnd = 0; windowEnd < numsLength; windowEnd++) {
            if (nums[windowEnd] == 0) {
                zerosInWindow++;
            }

            while (zerosInWindow > k) {
                if (nums[windowStart] == 0) {
                    zerosInWindow--;
                }

                windowStart++;
            }

            longestSubarray = Math.max(longestSubarray, windowEnd - windowStart + 1);
        }

        return longestSubarray;
    }
}
