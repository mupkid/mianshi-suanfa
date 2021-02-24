package com.example.nowcodernormal;

import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表
 * 题目描述
 * 将给定的单链表L： L0→L1→…→L{n-1}→Ln
 * 重新排序为：L0→Ln→L1→L{n-1}→L2→L{n-2}→…
 * 要求使用原地算法，不能改变节点内部的值，需要对实际的节点进行交换。
 * 例如：
 * 对于给定的单链表{10,20,30,40}，将其重新排序为{10,40,20,30}.
 */
public class NC2 {

    public static void main(String[] args) {

    }

    public void reorderList1(ListNode head) {
        if(head == null){
            return;
        }
        List<ListNode> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }
        int i=0, j = list.size()-1;
        while(i<j){
            list.get(i).next=list.get(j);
            i++;
            if(i==j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next=null;
    }

    public void reorderList2(ListNode head) {
        // 利用快慢指针把链表对半分
        // 后半逆序
        // 后半逐个间隔插入前半
        if(head==null||head.next==null||head.next.next==null){
            return;
        }

        ListNode slow = head, fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headList = head;
        ListNode tailList = slow.next;
        slow.next = null;

        tailList = reverse(tailList);
        insert(headList, tailList);
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private void insert(ListNode listA, ListNode listB){
        ListNode nodeA = listA, nodeB =listB;
        while(nodeB != null){
            ListNode nodeANext = nodeA.next;
            ListNode nodeBNext = nodeB.next;
            nodeA.next = nodeB;
            nodeB.next = nodeANext;
            nodeA = nodeANext;
            nodeB = nodeBNext;
        }
    }

    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}
