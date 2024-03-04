package com.ryu2u.exercise.YEAR_2023.month9;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-15 13:16:37
 */
public class Test_20230917 {
    @Test
    public void test() {
        // ch11
        // ch202
        // ch50
        System.out.println(myPow(2, 10));

    }

    public double myPow(double x, int n) {
        long N = n;
        return n >= 0 ? quickPow(x, N) : 1 / quickPow(x, N);
    }

    StringBuilder sb = new StringBuilder();
    double sum = 1;

    private double quickPow(double x, long N) {
        if (N == 0) {
            return 1;
        }
        double v = quickPow(x, N / 2);
        return N % 2 == 0 ? v * v : v * v * x;
    }


    public boolean isHappy(int n) {
        Set<Integer> set = new TreeSet<>();
        while (true) {
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
            n = getNext(n);
        }

    }

    private int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int x = n % 10;
            sum += x * x;
            n /= 10;
        }
        return sum;
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = 0;
        while (l < r) {
            int x = r - l;
            int y = Math.min(height[l], height[r]);
            area = Math.max(area, x * y);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;

    }


}