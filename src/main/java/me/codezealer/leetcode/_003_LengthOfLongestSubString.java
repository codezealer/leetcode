package me.codezealer.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 */
public class _003_LengthOfLongestSubString {

    /**
     * 最简单的就是双循环
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            String str = s.substring(i, i + 1);
            for (int j = i + 1; j < s.length(); j++) {
                if (str.contains(String.valueOf(s.charAt(j)))) {
                    break;
                } else {
                    str = str.concat(String.valueOf(s.charAt(j)));
                }
                if (str.length() > max) {
                    max = str.length();
                }
            }
        }
        return max;
    }

    /**
     * 双指针，类似于窗口的思想
     * 用一个set来存储不同的字符
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int start = 0, end = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while (start < n && end < n) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                res = Math.max(res, set.size());
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }
}
