package com.ryu2u.exercise.YEAR_2023.month9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-15 13:16:05
 */
public class Test_20230914 {
    @Test
    public void test() {
        //ch 9
        // ch89
        // ch119
        System.out.println(getRow(0));
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    temp.add(1);
                } else {
                    temp.add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
                }
            }
            list.add(temp);
        }
        return list.get(rowIndex);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(head ^ list.get(j));
            }
            head <<= 1;
        }
        return list;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int y = 0;
        while (x > y) {
            int n = x % 10;
            y = y * 10 + n;
            x /= 10;
        }
        return x == y || x == y / 10;
    }


}