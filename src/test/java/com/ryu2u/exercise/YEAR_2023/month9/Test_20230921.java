package com.ryu2u.exercise.YEAR_2023.month9;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-22 09:22:39
 */
public class Test_20230921 {
    @Test
    public void test() {
        // ch82
        // ch78
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
        // ch91
        String str = "11106";
        System.out.println(numDecodings(str));
        System.out.println(numDecodings2(str));
    }

    public int numDecodings(String s) {
        int[] f = new int[s.length() + 1];
        f[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[s.length()];
    }

    public int numDecodings2(String s) {
        int x = 0;
        int y = 1;
        int z = 0;
        for (int i = 1; i <= s.length(); i++) {
            x = 0;
            if (s.charAt(i - 1) != '0') {
                x += y;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                x += z;
            }
            z = y;
            y = x;
        }
        return x;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(list, nums, 0);
        return list;
    }

    List<Integer> temp = new ArrayList<>();

    private void backTrack(List<List<Integer>> list, int[] arr, int index) {
        list.add(new ArrayList<>(temp));
        for (int i = index; i < arr.length; i++) {
            temp.add(arr[i]);
            backTrack(list, arr, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode();
        ListNode newNode = node;
        while (head != null) {
            if (head.next != null && head.next.val == head.val) {
                while (head.next != null && head.next.val == head.val) {
                    head = head.next;
                }
            } else {
                node.next = new ListNode(head.val);
                node = node.next;
            }
            head = head.next;
        }
        return newNode.next;
    }


}