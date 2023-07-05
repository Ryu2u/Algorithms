package com.ryu2u.easy;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *
 *
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 * 提示：
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * @author Administrator
 * @Description:
 * @date 2023/6/30 11:30
 */
public class ch121_买卖股票的最佳时机 {
    /**
     * 超时
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int len = prices.length;
        int max = 0;
        for (int i = 0; i <= len - 1; i++) {
            int in = prices[i];
            for (int j = i + 1; j <= len - 1; j++) {
                int out = prices[j];
                max = Math.max(max,out-in);
            }
        }
        return max;
    }

    /**
     * 贪心算法
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        int len = prices.length;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < len; i++) {
            int price = prices[i];
            min = Math.min(min, price);
            max = Math.max(max,price -min);
        }
        return max;
    }

    /**
     * 第i天的最大利润 = Max{ 前i-1天的最大利润 , 第i天的价格 - 前i-1天的最低价格 }
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp = new int[len];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            int price = prices[i];
            min = Math.min(min,price);
            dp[i] = Math.max(dp[i-1],price - min);
        }
        return dp[len-1];
    }



    public static void main(String[] args) throws IOException {
//        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {7,6,4,3,1};
        List<Integer> list = new ArrayList<>();
        File file = new File("C:\\Users\\Administrator\\Desktop\\data.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while((line = br.readLine()) != null){
            line = line.trim();
            line = line.replace(",", "");
            if (!"".equals(line)){
                int num = Integer.parseInt(line,10);
                list.add(num);
            }
        }
        int[] prices = list.stream().mapToInt(Integer::intValue).toArray();
        int i = maxProfit(prices);
        System.out.println(i);
    }

    @Test
    public void test01(){
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {2,7,1,5,4};
        int i = maxProfit(prices);
        System.out.println(i);

    }

}
