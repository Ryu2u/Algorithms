package com.ryu2u.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 * <p>
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *
 * @author Administrator
 * @Description:
 * @date 2023/6/21 9:09
 */
public class ch88_合并两个有序数组 {
    /**
     * 时间复杂度O(m+n)
     * 空间复杂度为O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int i = m + n - 1;
        m--;
        n--;
        while (n >= 0) {
            if (m >= 0 && nums1[m] > nums2[n]) {
                int temp = nums1[i];
                nums1[i] = nums1[m];
                nums1[m] = temp;
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }
            i--;
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            int j = i + m;
            nums1[j] = nums2[i];
        }
        sort(nums1, 0, nums1.length - 1);
    }

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int l = low;
        int r = high;
        int k = arr[l];
        while (l < r) {
            while (arr[r] >= k && l < r) {
                r--;
            }
            int temp;
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            while (arr[l] <= k && l < r) {
                l++;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
        sort(arr, l + 1, high);
        sort(arr, low, r - 1);
    }


    @Test
    public void test() {
//        int[] nums1 = {1,2,3,0,0,0};
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {0};
        merge(nums1, 3, nums2, 0);
        System.out.println(Arrays.toString(nums1));
    }


}
