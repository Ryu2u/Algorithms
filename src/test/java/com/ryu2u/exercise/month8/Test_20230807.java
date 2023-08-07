package com.ryu2u.exercise.month8;

import com.ryu2u.entity.ListNode;
import com.sun.xml.internal.txw2.output.DumpSerializer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-07 17:18:59
 */
public class Test_20230807 {
    @Test
    public void test() {
        // ch46
        // ch6
        // ch19

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0,head);
        ListNode newNode = node;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            node = node.next;
        }
        node.next = node.next.next;
        return newNode.next;
    }

    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (int j = 0; j < s.length(); j++) {
            list.get(i).append(s.charAt(j));
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder b : list) {
            sb.append(b);
        }
        return sb.toString();
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(list, nums, used);
        return list;
    }

    List<Integer> temp = new ArrayList<>();

    private void backTracking(List<List<Integer>> list, int[] arr, boolean[] used) {
        if (temp.size() == arr.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                temp.add(arr[i]);
                used[i] = true;
                backTracking(list, arr, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }


}