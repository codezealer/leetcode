package me.codezealer.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 如下面的两个链表：
 * 在节点 c1 开始相交。
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
 * skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
 * ,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 示例 2：
 * 输入：intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，
 * 链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4 ]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 */


public class _160_GetIntersectionNode {

    /**
     * 遍历链表A，并用set来存储
     * 遍历链表B，判断B的节点是否在A中存在，第一次存在的那个就是相交的节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
