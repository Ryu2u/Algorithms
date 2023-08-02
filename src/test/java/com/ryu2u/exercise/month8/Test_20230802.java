package com.ryu2u.exercise.month8;

import org.junit.Test;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-02 11:35:29
 */
public class Test_20230802 {
    @Test
    public void test() {
        //ch36
        // ch33
        int[] nums = {4, 5, 6, 7, 8, 0, 1, 2};
        int target = 8;
        System.out.println(search(nums, target));
        // ch34

    }

    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int max = -1;
        int min = nums.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                max = mid;
                min = mid;
                int n = mid;
                while (mid >= 0 && nums[mid] == target) {
                    min = mid;
                    mid--;
                }
                while (n < nums.length && nums[n] == target) {
                    max = n;
                    n++;
                }

                return new int[]{min,max};
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return new int[]{-1,-1};
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[r]) {
                if (target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (nums[l] <= nums[mid]) {
                    if (target >= nums[l] && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else if (nums[mid] <= nums[r]) {
                    if (target <= nums[r] && target > nums[mid]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        return -1;

    }

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] boxs = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '1';
                    rows[i][index]++;
                    columns[j][index]++;
                    boxs[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || boxs[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }

            }
        }
        return true;

    }


}