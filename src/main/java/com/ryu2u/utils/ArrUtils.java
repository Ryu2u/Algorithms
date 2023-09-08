package com.ryu2u.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Administrator
 * @Description:
 * @date 2023/9/8 9:53
 */
public class ArrUtils {

    public static int[] stringArrToIntArr(String strArr) {
        strArr = strArr.replace("[", "");
        strArr = strArr.replace("]", "");
        String[] split = strArr.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            int num = Integer.valueOf(split[i]);
            arr[i] = num;
        }
        return arr;
    }

    public static int[][] stringArrToMatrixArr(String strArr) {
        strArr = strArr.substring(strArr.indexOf('[') + 1);
        strArr = strArr.substring(0, strArr.lastIndexOf(']'));
        String[] split = strArr.split("],");
        int[][] matrix = new int[split.length][];
        for (int i = 0; i < split.length; i++) {
            int[] arr = stringArrToIntArr(split[i]);
            matrix[i] = arr;
        }
        return matrix;
    }

    public static void main(String[] args) {
        String str = "[[1,3,2],[2,6],[8,10],[15,18]]";
        int[][] ints = stringArrToMatrixArr(str);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }

    }

}
