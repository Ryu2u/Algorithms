package com.ryu2u.easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 *
 * 提示：
 * 1 <= n <= 45
 *
 * @author Ryu2u
 * @Description:
 * @date 2023/6/18 13:51
 */
public class ch70_爬楼梯 {
    /**
     * 动态规划: f(x) = f(x- 1) + f(x -2)
     * 爬到第x级台阶的方案为 爬到(x -1)级台阶爬一级 + 爬到(x -2)级台阶的方案爬两级
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int[] pb = new int[n + 1];
        pb[1] = 1;
        pb[2] = 2;
        for (int i = 3; i <= n; i++) {
            pb[i] = pb[i - 1] + pb[i - 2];
        }
        return pb[n];
    }


    /**
     * 动态规划优化
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        int count = 1;
        int first = 0;
        int second = 0;
        for (int i = 1; i <= n; i++) {
            second = first; // 上两级台阶的方案
            first = count; // 上一级台阶的方案
            count = first + second; // 计算当前台阶的方案
        }
        return count;
    }

    /**
     * 递归方法(n=45时会超时)
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if(n == 1){
            return 1;
        }else if(n== 2){
            return 2;
        }else{
            return climbStairs2(n-1) + climbStairs2( n -2);
        }
    }

    public static int climbStairs4(int n) {
        int count = 1;
        int q = 0;
        int p = 0;
        for (int i = 1; i <= n; i++) {
            q = p; // 前两级台阶
            p = count; // 上一级台阶
            count = q + p;
        }
        return count;
    }



    public static void main(String[] args) {
        System.out.println(climbStairs(13));
        System.out.println(climbStairs3(3));

    }

}
