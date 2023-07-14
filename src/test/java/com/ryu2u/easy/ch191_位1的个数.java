package com.ryu2u.easy;

import org.junit.Test;

/**
 *
 * @author Administrator
 * @Description:
 * @date 2023-06-30 13:28:51
 */
public class ch191_位1的个数	{

    @Test
    public void test(){
        String str = "11111111111111111111111111111101";
        int i = Integer.parseUnsignedInt(str, 2);
        System.out.println(i);
        System.out.println(hammingWeight(i));
    }

    public int hammingWeight(int n) {
        if (n== 0){
            return 0;
        }
        int count = 0;
        while(n != 0){
            if ((n & 0x01) == 1){
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

}