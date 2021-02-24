package com.example.nowcodernormal;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class NC78 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
