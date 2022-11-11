package slidingwindow;

public class MaxConsecutiveOnes {

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int numsLength = nums.length;
        int zerosInWindow = 0;
        int longestLength = 0;

        for (int right = 0; right < numsLength; right++) {
            if (nums[right] == 0) {
                zerosInWindow++;
            }

            while (zerosInWindow > k) {
                if (nums[left++] == 0) {
                    zerosInWindow--;
                }
            }

            longestLength = Math.max(longestLength, (right - left) + 1);
        }

        return longestLength;
    }
}
