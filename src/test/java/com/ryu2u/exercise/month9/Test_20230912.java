package com.ryu2u.exercise.month9;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-12 16:52:13
 */
public class Test_20230912 {
    @Test
    public void test() {
        // ch343
        System.out.println(integerBreak(5));
        // ch89

        // ch86
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode node = new ListNode();
        ListNode newNode = node;
        ListNode l1 = head;
        while (l1 != null) {
            if (l1.val < x) {
                node.next = new ListNode(l1.val);
                node = node.next;
            }
            l1 = l1.next;
        }
        while (head != null) {
            if (head.val >= x) {
                node.next = new ListNode(head.val);
                node = node.next;
            }
            head = head.next;
        }
        return newNode.next;
    }

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(head ^ list.get(j));
            }
            head <<= 1;
        }
        return list;

    }

    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n % 3;
        int i = n / 3;
        if (a == 0) {
            return (int) Math.pow(3, i);
        } else if (a == 1) {
            return (int) Math.pow(3, i - 1) * 4;
        } else {
            return (int) Math.pow(3, i) * 2;
        }
    }


}