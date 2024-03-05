package com.ryu2u.exercise.YEAR_2024.month3;

import org.junit.Test;
import com.ryu2u.entity.TreeNode;
import com.ryu2u.entity.ListNode;

/**
 * @author Ryu2u
 * @Description:
 * @date 2024-03-05 09:54:47
 */
public class Test_20240305 {

    @Test
    public void test0() {

    }

    // ch27
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] != val) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }

    @Test
    public void test1() {

    }

    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 1;
        while (r < nums.length) {
            if (nums[l] != nums[r]) {
                nums[++l] = nums[r];
            }
            r++;
        }
        return l + 1;
    }


    @Test
    public void test2() {

    }

    @Test
    public void test3() {

    }

    @Test
    public void test4() {

    }

}