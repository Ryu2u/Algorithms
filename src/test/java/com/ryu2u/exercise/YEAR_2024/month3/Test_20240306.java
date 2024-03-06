package com.ryu2u.exercise.YEAR_2024.month3;

import org.junit.Test;
import com.ryu2u.entity.TreeNode;
import com.ryu2u.entity.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2024-03-06 14:16:05
 */
public class Test_20240306 {

    @Test
    public void test0() {
        int[][] ints = generateMatrix(3);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    // ch59
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int t = 0, b = n - 1, l = 0, r = n - 1;
        int count = 1;
        while (count <= n * n) {
            for (int i = l; i <= r && count <= n * n; i++) {
                matrix[t][i] = count++;
            }
            t++;
            for (int i = t; i <= b && count <= n * n; i++) {
                matrix[i][r] = count++;
            }
            r--;
            for (int i = r; i >= l && count <= n * n; i--) {
                matrix[b][i] = count++;
            }
            b--;
            for (int i = b; i >= t && count <= n * n; i--) {
                matrix[i][l] = count++;
            }
            l++;
        }

        return matrix;
    }


    @Test
    public void test1() {

    }

    // ch54
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = m * n;
        List<Integer> vec = new ArrayList<>();
        int t = 0, b = m - 1, l = 0, r = n - 1;
        int c = 0;
        while (c < x) {
            for (int i = l; i <= r && c < x; i++) {
                vec.add(matrix[t][i]);
                c++;
            }
            t++;
            for (int i = t; i <= b && c < x; i++) {
                vec.add(matrix[i][r]);
                c++;
            }
            r--;
            for (int i = r; i >= l && c < x; i--) {
                vec.add(matrix[b][i]);
                c++;
            }
            b--;
            for (int i = b; i >= t && c < x; i--) {
                vec.add(matrix[i][l]);
                c++;
            }
            l ++;
        }
        return vec;
    }

    @Test
    public void test2() {

    }

    // ch203
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode node = new ListNode(0,head);
        ListNode newNode = node;
        while(node.next != null){
            if (node.next.val == val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return newNode.next;
    }

    @Test
    public void test3() {

    }

    @Test
    public void test4() {

    }

}