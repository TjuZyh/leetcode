package com.leetcode.weeks._0904;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/9/4 10:23
 * @Version 1.0
 */
// startPos = 1, endPos = 2, k = 3
public class _2 {
    /*
    * 需要记忆化DFS，用map存储已经递归过的信息，下次遇到直接在map中获取即可
    * 注意leetcode用例过多，容易结果爆掉，需要mod (int)1e9 + 7
    * */
    private int mod = (int)1e9 + 7;
    //创建一个map，用于记忆化DFS
    //map中对应位置代表含义：Map<startPos , Map<k , ans>>
    private Map<Integer , Map<Integer , Integer>> map = new HashMap<>();
    public int numberOfWays(int startPos, int endPos, int k) {
        return dfs(startPos , endPos , k);
    }

    public int dfs(int curPos , int endPos , int k){
        if(k == 0){
            return curPos == endPos ? 1 : 0;
        }

        //当前curPos以及k的情况，之前是否也走过，走过的话直接取值即可
        if(map.containsKey(curPos) && map.get(curPos).containsKey(k)){
            return map.get(curPos).get(k);
        }

        //剪枝：如果剩余要走的路比k大，那么一定不会走到终点
        if(k < Math.abs(curPos - endPos)){
            return 0;
        }

        int left = dfs(curPos - 1 , endPos , k - 1);
        int right = dfs(curPos + 1 , endPos , k - 1);


        Map<Integer , Integer> m = new HashMap<>();
        m.put(k , (left+ right) % mod);
        map.put(curPos , m);

        return (left + right) % mod;
    }

    public static void main(String[] args) {
        System.out.println(new _2().numberOfWays(272, 270, 6));
        System.out.println(6 % -2);
    }
}
