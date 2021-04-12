package me.codezealer.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 n/2 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class _169_MajorityElement {

    /**
     * 最简单的思路就是直接迭代，存储每个数字出现的次数，次数最多的就是
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            Integer val = map.get(nums[i]);
            if(val == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], ++val);
            }
        }
        int max = Integer.MIN_VALUE;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == max) {
                return entry.getKey();
            }
        }

        return 0;
    }

    /**
     * 采用排序的方法，中间的数字，一定是要找的数
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,3,4};
        System.out.println(majorityElement(nums));
    }

}
