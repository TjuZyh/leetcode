package com.leetcode.DailyCheckIn._0729;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zyh
 * @Date 2022/7/29 5:49 下午
 * @Version 1.0
 */
public class validSquare_593 {
    /*
    * 判断是否为正方形只需要判断点之间的距离即可
    *   如果为正方形，则只会存在两种长度，即边长以及对角线
    * 设置一个set集，将点与点之间的距离全部存入，若set集的大小为2，则为正方形
    * */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Double> lengthSet = new HashSet<>();
        int[][] points = {p1 , p2 , p3 , p4};
        for(int i = 0 ; i < 3 ; i++){
            for(int j = i + 1 ; j < 4 ; j++){
                double curLength = Math.pow(points[i][0] - points[j][0] , 2) + Math.pow(points[i][1] - points[j][1] , 2);
                if(curLength == 0){
                    return false;
                }
                lengthSet.add(curLength);
            }
        }
        return lengthSet.size() <= 2;
    }
}
