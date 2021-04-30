package me.codezealer.leetcode;

import java.util.Stack;

/**
 * // push(x) —— 将元素 x 推入栈中。
 * // pop() —— 删除栈顶的元素。
 * // top() —— 获取栈顶元素。
 * // getMin() —— 检索栈中的最小元素。
 */

public class _155_MinStack {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-1);
//        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
    }


    /**
     * 最简单的就是在getMin的时候做一下处理，取出最小的数即可。
     */
    static class MinStack {

        Stack<Integer> stack = new Stack<>();


        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int val) {
            stack.add(val);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            int min = Integer.MAX_VALUE;
            for (Integer item : stack) {
                if (item < min) {
                    min = item;
                }
            }
            return min;
        }
    }
}
