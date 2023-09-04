package com.ryu2u.entity;


/**
 * 链表类
 *
 * @author Administrator
 * @Description:
 * @date 2023/6/13 13:27
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        System.out.print(head.val);
        while (head.next != null) {
            System.out.print(" --> ");
            System.out.print(head.next.val);
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode arrayToListNode(int[] arr) {
        if (arr.length <= 0) {
            return null;
        }
        ListNode node = new ListNode(arr[0]);
        ListNode newNode = node;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        return newNode;
    }


}
