package twopointers;

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int product = 1;
        int count = 0;
        int numsLength = nums.length;

        for (int right = 0; right < numsLength; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left++];
            }

            count += (right - left) + 1;
        }

        return count;
    }
}
