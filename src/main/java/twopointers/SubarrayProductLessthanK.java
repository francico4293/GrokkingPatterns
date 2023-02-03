package twopointers;

public class SubarrayProductLessthanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int left = 0;
        int count = 0;
        int numsLength = nums.length;

        for (int right = 0; right < numsLength; right++) {
            product *= nums[right];

            while (product >= k && left <= right) {
                product /= nums[left++];
            }

            count += (right - left) + 1;
        }

        return count;
    }
}
