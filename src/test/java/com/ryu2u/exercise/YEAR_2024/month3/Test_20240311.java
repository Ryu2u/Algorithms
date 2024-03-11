package com.ryu2u.exercise.YEAR_2024.month3;

import org.junit.Test;
import com.ryu2u.entity.TreeNode;
import com.ryu2u.entity.ListNode;

/**
 * @author Ryu2u
 * @Description:
 * @date 2024-03-11 14:52:14
 */
public class Test_20240311 {

    @Test
    public void test0() {

    }


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    @Test
    public void test1() {

    }

    // ch24
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        head.next = node.next;
        node.next = head;
        head.next = swapPairs(head.next);
        return node;
    }


    @Test
    public void test2() {

    }

    // ch19
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    @Test
    public void test3() {

    }

    // ch160
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }


    @Test
    public void test4() {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode l1 = head;
        ListNode l2 = head;
        while (true) {
            if (l2.next == null || l2.next.next == null) {
                return null;
            }
            l1 = l1.next;
            l2 = l2.next.next;
            if (l1 == l2) {
                break;
            }
        }
        l1 = head;
        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

}