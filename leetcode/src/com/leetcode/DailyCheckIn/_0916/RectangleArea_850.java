package com.leetcode.DailyCheckIn._0916;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/9/16 13:28
 * @Version 1.0
 */
/*
* rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
* */
public class RectangleArea_850 {
    private int MOD = (int)1e9 + 7;
    public int rectangleArea(int[][] rectangles) {
        List<Integer> xList = new ArrayList<>();
        for(int[] l : rectangles){
            xList.add(l[0]);
            xList.add(l[2]);
        }
        Collections.sort(xList);
        long ans = 0;
        for(int i = 1 ; i < xList.size() ; i++){
            int a = xList.get(i - 1);
            int b = xList.get(i);
            int len = b - a;
            if(len == 0) continue;
            List<int[]> lines = new ArrayList<>();
            //查询在[a,b]之间的高度
            for(int[] l : rectangles){
                if(l[0] <= a && l[2] >= b){
                    lines.add(new int[]{l[1] , l[3]});
                }
            }
            //对矩形的上下界进行排序，按下界升序排列，若下界相同则按上界升序排列
            Collections.sort(lines , (l1 , l2) -> {
                return l1[0] != l2[0] ? l1[0] - l2[0] : l1[1] - l2[1];
            });
            //求当前[a,b]内高度的并集
            long tot = 0 , l = -1 , r = -1;
            for(int[] cur : lines){
                if(cur[0] > r){
                    tot += r - l;
                    l = cur[0]; r = cur[1];
                }else if(cur[1] > r){
                    r = cur[1];
                }
            }
            tot += r - l;
            ans += tot * len;
            ans %= MOD;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(new RectangleArea_850().rectangleArea(new int[][]{{0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}}));
    }
}
