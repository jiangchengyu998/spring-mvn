package leetcode.s3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int lengthOfLongestSubstring(String s) {

        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();

        // 右指针，初始值为-1，相当于我们在字符串的左边界的左侧，还没开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一格字符
                occ.remove(s.charAt(i - 1));
            }

            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断的移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }

            ans = Math.max(ans, rk - i + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        String ban = "abcabc";
        System.out.println(Solution.lengthOfLongestSubstring(ban));
    }
}