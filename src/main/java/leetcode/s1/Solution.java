package leetcode.s1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(nums, 18)));
        System.out.println(Arrays.toString(solution.twoSum1(nums, 18)));
    }
}
