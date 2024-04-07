package com.ryu2u.exercise.YEAR_2024.month4;

import org.junit.Test;
import com.ryu2u.entity.TreeNode;
import com.ryu2u.entity.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2024-04-07 11:57:45
 */
public class Test_20240407 {

    @Test
    public void test0() {

    }

    // ch160
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }

    @Test
    public void test1() {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0, head);
        head = node;
        ListNode newNode = node;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        while (node.next != null) {
            node = node.next;
            head = head.next;
        }
        head.next = head.next.next;

        return newNode.next;
    }

    @Test
    public void test2() {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode node = cur.next;
            ListNode next = cur.next.next;
            cur.next = next;
            node.next = next.next;
            next.next = node;
            cur = cur.next.next;
        }

        return dummy.next;
    }


    @Test
    public void test3() {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    @Test
    public void test4() {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>(16);
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String s = Arrays.toString(cs);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(str);
                map.put(s,temp);
            }
        }
        List<List<String>> list = new ArrayList<>();

        for (String s : map.keySet()) {
            list.add(map.get(s));
        }

        return list;
    }

}