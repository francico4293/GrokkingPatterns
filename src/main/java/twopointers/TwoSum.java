package twopointers;

import java.util.Map;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int numsLength = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int idx = 0; idx < numsLength; idx++) {
            int numToFind = target - nums[idx];

            if (map.containsKey(numToFind)) {
                return new int[] { map.get(numToFind), idx };
            } else {
                map.put(nums[idx], idx);
            }
        }

        return new int[] { -1, -1 };
    }
}
