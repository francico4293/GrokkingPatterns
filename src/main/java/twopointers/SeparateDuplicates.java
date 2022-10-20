package twopointers;

public class SeparateDuplicates {

    public int removeDuplicates(int[] nums) {
        int left = 0;
        int numsLength = nums.length;

        for (int right = 0; right < numsLength; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }

        return left + 1;
    }
}
