package com.ryu2u.exercise.YEAR_2023.month7;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author Administrator
 * @Description:
 * @date 2023/7/17 14:48
 */
public class Test_20230717 {

    @Test
    public void test(){
        // ch202
        // ch205
        // ch145
        // ch94
        // ch144


    }


    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            if (root.right != null){
                stack.push(root.right);
            }
            if (root.left != null){
                stack.push(root.left);
            }
        }
        return list;

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre){
                list.add(root.val);
                pre =root;
                root = null;
            }else{
                stack.push(root);
                root = root.right;
            }
        }
        return list;

    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if ((map1.containsKey(cs) && map1.get(cs) != ct) || (map2.containsKey(ct) && map2.get(ct) != cs)){
                return false;
            }else{
                map1.put(cs,ct);
                map2.put(ct,cs);
            }
        }
        return true;
    }


    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            set.add(n);
            n = getNext(n);
            if (set.contains(n)){
                return false;
            }
        }
        return true;
    }

    private int getNext(int n){
        int sum = 0;
        while(n != 0){
            int x = n % 10;
            sum += x * x;
            n /= 10;
        }
        return sum;
    }




}
