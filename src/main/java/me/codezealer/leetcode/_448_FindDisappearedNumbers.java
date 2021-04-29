package me.codezealer.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _448_FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        for (int i=0; i<nums.length; i++) {
            int num = Math.abs(nums[i]);
            int index = num - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        for (int i=0; i<length; i++) {
            if (nums[i] > 0) {
                list.add(i+1);
            }
        }

        return list;
    }
}
