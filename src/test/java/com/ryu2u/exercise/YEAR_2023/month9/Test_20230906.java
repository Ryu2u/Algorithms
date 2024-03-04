package com.ryu2u.exercise.YEAR_2023.month9;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-06 15:33:54
 */
public class Test_20230906 {
    @Test
    public void test() {
        // ch83
        ListNode listNode = ListNode.arrayToListNode(new int[]{1, 1, 2, 3, 3});
        ListNode listNode1 = deleteDuplicates(listNode);
        ListNode.printList(listNode1);
        // ch118
        System.out.println(generate(5));
        // ch46
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(list,nums,used);
        return list;
    }

    List<Integer> temp = new ArrayList<>();
    private void backTracking(List<List<Integer>> list, int[] arr, boolean[] used) {
        if (temp.size() == arr.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]){
                temp.add(arr[i]);
                used[i] =true;
                backTracking(list, arr, used);
                temp.remove(temp.size()-1);
                used[i] = false;
            }
        }


    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (0 == j || j == i) {
                    temp.add(1);
                } else {
                    temp.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(temp);
        }
        return list;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return node;
    }

}