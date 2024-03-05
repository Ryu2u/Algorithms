package com.ryu2u.medium;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Administrator
 * @Description:
 * @date 2024/3/5 17:09
 */
public class ch904_水果成篮 {
    @Test
    public void test(){

    }

    public int totalFruit(int[] fruits) {
        int i = 0;
        int n = fruits.length;
        int sub_len = 0;
        HashMap<Integer,Integer> map = new HashMap<>(4);
        for (int j = 0; j < n; j++) {
            if (map.containsKey(fruits[j])){
                int c = map.get(fruits[j]) + 1;
                map.put(fruits[j],c);
            }else{
                map.put(fruits[j],1);
            }
            while (map.size() > 2){
                int count = map.get(fruits[i]);
                count--;
                map.put(fruits[i],count);
                if (count == 0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            sub_len = Math.max(sub_len,j - i + 1);
        }

        return sub_len;
    }

}
