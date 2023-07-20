package com.ryu2u.easy;

import com.sun.media.jfxmediaimpl.HostUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * <p>
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * <p>
 * <p>
 * 提示：
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/20 17:27
 */
public class ch228_汇总区间 {

    @Test
    public void test() {
        int[] nums = {-2147483648,-2147483647,2147483647};
        System.out.println(summaryRanges(nums));

    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length <= 0) {
            return list;
        }
        list.add(String.valueOf(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int pre = nums[i - 1];
            if (num - pre == 1) {
                String str = list.get(list.size() - 1);
                int k = str.lastIndexOf("->");
                if (k != -1){
                    str = str.substring(0,k);
                }
                str += "->" + num;
                list.set(list.size()-1,str);
            } else {
                list.add(String.valueOf(num));
            }
        }
        return list;

    }


}
