package me.codezealer.leetcode;

import java.util.*;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 */

public class _136_SingleNumber {

    /**
     * 常规思路，遍历数组，然后用map存储每个数字的次数即可
     * 然后遍历map，次数为1的数字就是目标数
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            Integer val = map.get(nums[i]);
            if (val == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], ++val);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 直接把所有数字进行异或，因为两个相同的数字异或为0
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        int res = 0;
        for (int i=0; i<nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {4,1,2,1,2};
        System.out.println(singleNumber1(nums));
    }
}
