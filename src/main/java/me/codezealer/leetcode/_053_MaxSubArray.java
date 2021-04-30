package me.codezealer.leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 */

public class _053_MaxSubArray {

    /**
     * 迭代数组并进行求和，如果发现和是负数，则将和设置为0，重新开始求和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (ans < 0) {
                ans = 0;
            }
            ans += nums[i];
            max = Math.max(ans, max);
        }
        return max;
    }

}
