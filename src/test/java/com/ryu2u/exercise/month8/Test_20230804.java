package com.ryu2u.exercise.month8;

import com.ryu2u.entity.ListNode;
import com.sun.xml.internal.bind.v2.util.EditDistance;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-04 10:56:08
 */
public class Test_20230804 {
    @Test
    public void test() {
        // ch40
        // ch19
        // ch17
        System.out.println(letterCombinations(""));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if ("".equals(digits)) {
            return list;
        }
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        lettersTracking(list, letters, digits, 0);
        return list;

    }

    StringBuilder sb = new StringBuilder();

    private void lettersTracking(List<String> list, String[] letters, String digits, int num) {
        if (num == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String str = letters[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            lettersTracking(list, letters, digits, num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(0, head);
        ListNode newNode = node;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            node = node.next;
        }
        node.next = node.next.next;

        return newNode.next;

    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        combination(list, candidates, target, 0);
        return list;
    }

    List<Integer> temp = new ArrayList<>();
    int sum = 0;

    private void combination(List<List<Integer>> list, int[] arr, int target, int index) {
        if (target < sum) {
            return;
        }
        if (target == sum) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            temp.add(arr[i]);
            sum += arr[i];
            combination(list, arr, target, i + 1);
            sum -= arr[i];
            temp.remove(temp.size() - 1);
        }

    }


}