package com.ryu2u.exercise.YEAR_2023.month7;
import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author Administrator
 * @Description:
 * @date 2023-07-19 09:56:17
 */
public class Test_20230719	{
    @Test
    public void test(){
        //ch111
        //ch202
        System.out.println(isHappy(7));
        //ch144

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null){
            return list;
        }
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

    public void preorder(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
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

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else if (root.left == null && root.right == null){
            return 1;
        }else if (root.left == null){
            return minDepth(root.right) + 1;
        }else if (root.right == null){
            return minDepth(root.left) + 1;
        }else{
            return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
        }

    }




}