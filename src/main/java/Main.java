import slidingwindow.MaximumSizeSubarraySum;

public class Main {

    public static void main(String[] args) {
        int target = 4;
        int[] nums = new int[] { 1, 4, 4 };

        MaximumSizeSubarraySum maximumSizeSubarraySum = new MaximumSizeSubarraySum();
        int result = maximumSizeSubarraySum.minSubArrayLen(target, nums);
        System.out.println("Result " + result);
    }
}
