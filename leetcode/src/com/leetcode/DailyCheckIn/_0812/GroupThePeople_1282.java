package com.leetcode.DailyCheckIn._0812;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/8/12 10:17
 * @Version 1.0
 */
public class GroupThePeople_1282 {
    /*
    * hash
    * 解题思路：两步分组 [2,1,3,3,3,2,3,3,3]
    *   1. 将拥有同一组大小的组员分为一组 [1] [0,5] [2,3,4,6,7,8]
    *   2. 将同一大小组员进行拆分成相应大小为一组 [2,3,4] [6,7,8]
    * */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer , List<Integer>> hashMap = new HashMap<>();
        for(int i = 0 ; i < groupSizes.length ; i++){
            if(hashMap.get(groupSizes[i]) == null){
                List<Integer> group = new ArrayList<>();
                group.add(i);
                hashMap.put(groupSizes[i] , group);
            }else{
                List<Integer> curGroup = hashMap.get(groupSizes[i]);
                curGroup.add(i);
                hashMap.put(groupSizes[i] , curGroup);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(Integer k : hashMap.keySet()){
            if(hashMap.get(k).size() == k){
                ans.add(hashMap.get(k));
            }else{
                List<List<Integer>> split = spiteList(hashMap.get(k), k);
                for(List<Integer> l : split){
                    ans.add(l);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> spiteList(List<Integer> arr , int size){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < arr.size() / size ; i++){
            List<Integer> cur = new ArrayList<>();
            int flag = i * size;
            for(int j = 0 ; j < size ; j++){
                cur.add(arr.get(flag + j));
            }
            ans.add(cur);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,3,3,2,3,3,3};

        new GroupThePeople_1282().groupThePeople(arr).forEach(System.out::println);
    }

}
