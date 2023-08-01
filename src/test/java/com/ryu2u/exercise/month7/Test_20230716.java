package com.ryu2u.exercise.month7;
import com.ryu2u.entity.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeModel;
import java.util.*;

/**
 * @author Administrator
 * @Description:
 * @date 2023-07-16 13:01:39
 */
public class Test_20230716	{
    @Test
    public void test(){
        // ch191
        String str = "11111111111111111111111111111101";
        int i = Integer.parseUnsignedInt(str, 2);
        System.out.println(hammingWeight(i));
        // ch145
        // ch94

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()){
            while (root != null){
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
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre){
                list.add(root.val);
                pre = root;
                root = null;
            }else{
                stack.push(root);
                root = root.right;
            }

        }
        return list;

    }

    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            if ((n & 1) == 1){
                count++;
            }
            n >>>= 1;
        }
        return count;
    }


}