package com.ryu2u.medium;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

/**
 * @author Administrator
 * @Description:
 * @date 2023/8/22 9:49
 */
public class ch61_旋转链表 {

    @Test
    public void test() {

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        k %= len;
        for (int i = 0; i < k; i++) {
            ListNode node = head;
            ListNode fast = head.next;
            while (fast.next != null) {
                node = node.next;
                fast = fast.next;
            }
            fast.next = head;
            node.next = null;
            head = fast;
        }
        return head;
    }

}
