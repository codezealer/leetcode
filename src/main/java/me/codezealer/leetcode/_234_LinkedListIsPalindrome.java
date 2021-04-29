package me.codezealer.leetcode;

public class _234_LinkedListIsPalindrome {

    public static boolean isPalindrome(ListNode head) {
        ListNode forward = new ListNode();
        ListNode forwardCur = forward;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            forwardCur.next = new ListNode(cur.val);
            forwardCur = forwardCur.next;
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode reversed = prev;
        forward = forward.next;
        while (reversed != null && forward != null) {
            if (reversed.val != forward.val) {
                return false;
            }
            reversed = reversed.next;
            forward = forward.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode list = buildList(new int[] {1, 2});
        boolean isPalidrome = isPalindrome(list);
        System.out.println(isPalidrome);
    }

    private static ListNode buildList(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i=1; i<nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = cur.next;
        }
        return head;
    }
}
