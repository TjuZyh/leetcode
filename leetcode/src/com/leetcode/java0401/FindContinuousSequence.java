package com.leetcode.java0401;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。\
* 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
* */
public class FindContinuousSequence {
    /*
    * 暴力枚举
    * */
    public static int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        for(int i = 1 ; i <= target / 2 ; i++){
            if(getArr(target , i)[0] != -1){
                res.add(getArr(target , i));
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    //start位置开始，存在累加等于target返回数组；不存在返回-1
    public static int[] getArr(int target , int start){
        int i = start , sum = 0 , cnt = 0;
        while(sum < target){
            sum += i;
            i++;
            cnt++;
        }
        if(sum == target){
            int[] res = new int[cnt];
            for(int j = 0 ; j < cnt ; j++){
                res[j] = start;
                start++;
            }
            return res;
        }else{
            return new int[]{-1};
        }
    }

    /*
    * 双指针 + 滑动窗口
    * */
    public static int[][] findContinuousSequence1(int target) {
        int i = 1 , j = 2 , sum = 3;
        List<int[]> res = new ArrayList<>();
        while(i < j){
            //累加和等于target，则记录数组
            if(sum == target){
                int[] tmp = new int[j - i - 1];
                for(int k = i ; k <= j ; k++){
                    tmp[k - i] = k;
                }
                res.add(tmp);
            }
            //如果累加和大于target
            if(sum >= target){
                sum -= i;
                i++;
            }else{ //如果累加和小于target
                j++;
                sum += j;
            }
        }
        //数组空间等于0时，将会动态的创建和集合size相同空间大小的数组，性能是最好的
        //new int[0][] = new int[res.size()][]
        return res.toArray(new int[0][]);

    }


    public static void main(String[] args) {
        Arrays.stream(findContinuousSequence(15)).forEach(arr -> Arrays.stream(arr).forEach(System.out::println));
    }
}
