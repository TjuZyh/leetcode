package com.leetcode.weeks._0904;

/**
 * @Author zyh
 * @Date 2022/9/4 10:23
 * @Version 1.0
 */
// startPos = 1, endPos = 2, k = 3
public class _2 {
    private int sum = 0;
    public int numberOfWays(int startPos, int endPos, int k) {
        dfs(startPos , endPos , k);
        return sum;
    }

    public void dfs(int curPos , int endPos , int k){
        if(k < 0){
            return;
        }
        if(curPos == endPos && k == 0){
            sum++;
            return;
        }

        if(Math.abs(curPos - endPos) > k){
            return;
        }

        //剪枝 3 0 5 也被剪了
        if(Math.abs(curPos - endPos) != 1 && Math.abs(curPos - endPos) % 2 != k % 2){
            return;
        }

        dfs(curPos - 1 , endPos , k - 1);
        dfs(curPos + 1 , endPos , k - 1);

    }

    public static void main(String[] args) {
        System.out.println(new _2().numberOfWays(272, 270, 6));
        System.out.println(6 % -2);
    }
}
