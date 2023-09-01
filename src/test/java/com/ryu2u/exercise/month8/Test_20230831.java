package com.ryu2u.exercise.month8;

import com.ryu2u.entity.ListNode;
import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-31 11:41:27
 */
public class Test_20230831 {
    @Test
    public void test() {
        // ch49
        // ch2
        // ch101

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if (n1 == null) {
            return false;
        } else if (n2 == null) {
            return false;
        }else if(n1.val != n2.val){
            return false;
        } else {
            return isSame(n1.left, n2.right) && isSame(n1.right, n2.left);
        }

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode node = new ListNode(0);
        ListNode res = node;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            carry = 0;
            if (sum >= 10) {
                carry = sum / 10;
                sum %= 10;
            }
            node.next = new ListNode(sum);
            node = node.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            node.next = new ListNode(carry);
        }
        return res.next;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            if (!map.containsKey(key)) {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key, temp);
            } else {
                map.get(key).add(str);
            }
        }
        for (String s : map.keySet()) {
            list.add(map.get(s));
        }
        return list;
    }


}