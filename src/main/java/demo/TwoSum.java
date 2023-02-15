package demo;

import java.util.HashMap;

public class TwoSum {
    // [1, 4, 7, 23, 9], and target = 13
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[]{nums[map.get(j)]/*j*/, nums[i]};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
