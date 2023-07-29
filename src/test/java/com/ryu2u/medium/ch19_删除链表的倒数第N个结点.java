package com.ryu2u.medium;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023/7/29 18:01
 */
public class ch19_删除链表的倒数第N个结点 {
    @Test
    public void test() {

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode first = head;
        ListNode slow = node;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return node.next;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return null;
        } else if (head.next == null && n == 1) {
            return null;
        }

        int count = 0;
        ListNode slow = head;
        ListNode newHead = head;
        while (head != null) {
            if (count > n) {
                slow = slow.next;
            }
            head = head.next;
            count++;
        }
        if (count <= n) {
            return newHead.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return newHead;

    }


}
