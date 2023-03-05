package com.leetcode.DMSXL.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/3/5 21:00
 * @Version 1.0
 */
/*
* 请你重新构造并返回输入数组people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人
*   输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
*   输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
* */
public class ReconstructQueue_406 {
    //贪心问题：存在两个维度 高度/排位，只能先考虑一个维度后考虑另外一个维度
    //贪心思路：先考虑高度，按照高度从大到小排序，后根据排位依次插入即可
    //解释：因为后插入的元素比之前的元素低，所以可以随便插入不会影响原数组的排列
    public int[][] reconstructQueue(int[][] people) {
        //排序：身高从大到小排，身高相同则排位从小到大排
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }else {
                    return o2[0] - o1[0];
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        for(int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
