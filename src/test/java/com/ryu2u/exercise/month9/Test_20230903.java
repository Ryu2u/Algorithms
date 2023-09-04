package com.ryu2u.exercise.month9;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-04 17:22:49
 */
public class Test_20230903 {
    @Test
    public void test() {
        //ch21
        ListNode list1 = ListNode.arrayToListNode(new int[]{1, 2, 4});
        ListNode list2 = ListNode.arrayToListNode(new int[]{1, 3, 4});
        ListNode.printList(list1);
        ListNode.printList(list2);
        ListNode listNode = mergeTwoLists(list1, list2);
        ListNode.printList(listNode);
        // ch55
        System.out.println(canJump(new int[]{0, 1}));
        // ch40

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(list,candidates ,target,0);
        return list;
    }

    List<Integer> temp = new ArrayList<>();
    int sum = 0;

    private void backTracking(List<List<Integer>> list, int[] arr, int target, int index) {
        if (sum > target) {
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
            backTracking(list, arr, target, i + 1);
            temp.remove(temp.size() - 1);
            sum -= arr[i];
        }

    }


    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        for (int i = 0; i < nums.length; ) {
            int n = nums[i];
            int j = i;
            int max = 0;
            if (i + n >= nums.length - 1) {
                return true;
            }
            for (int k = i + 1; k <= i + n; k++) {
                int len = k + nums[k];
                if (max <= len) {
                    max = len;
                    j = k;
                }
            }
            i = j;
            if (i < nums.length - 1 && max == 0) {
                return false;
            }
        }
        return true;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(0);
        ListNode newNode = node;
        while (list1 != null && list2 != null) {
            int n1 = list1.val;
            int n2 = list2.val;
            if (n1 <= n2) {
                node.next = new ListNode(n1);
                list1 = list1.next;
            } else {
                node.next = new ListNode(n2);
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 != null) {
            while (list1 != null) {
                node.next = new ListNode(list1.val);
                list1 = list1.next;
                node = node.next;
            }
        } else {
            while (list2 != null) {
                node.next = new ListNode(list2.val);
                list2 = list2.next;
                node = node.next;
            }
        }
        return newNode.next;
    }


}