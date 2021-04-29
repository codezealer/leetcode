package me.codezealer.leetcode;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */

public class _020_IsValidBrackets {

    /**
     * 用栈逐个字符入栈，入之前先匹配一下是否是一对，如果一对则做处理
     * 最后判断栈是否为空
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            final Character c = s.charAt(i);
            if (stack.size() == 0) {
                stack.add(c);
                continue;
            }
            Character first = stack.peek();
            if ((first.equals('(') && c.equals(')'))
                    || (first.equals('[') && c.equals(']'))
                    || (first.equals('{') && c.equals('}'))) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        if (stack.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValid1(String s) {
        int length;
        do {
            length = s.length();
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        } while (length != s.length());

        return s.length() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }


}
