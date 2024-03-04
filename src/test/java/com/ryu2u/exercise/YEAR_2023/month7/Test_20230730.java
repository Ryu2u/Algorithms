package com.ryu2u.exercise.YEAR_2023.month7;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-07-30 13:22:53
 */
public class Test_20230730 {
    @Test
    public void test() {
        // ch22
        System.out.println(generateParenthesis(3));
        // ch19

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = node;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return node.next;
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTracking(list, "", n, n);
        return list;
    }

    private void backTracking(List<String> list, String str, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left == right) {
            backTracking(list, str + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                backTracking(list, str + "(", left - 1, right);
            }
            backTracking(list, str + ")", left, right - 1);
        }
    }

}