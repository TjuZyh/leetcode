package com.leetcode.DailyCheckIn._0730;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/7/30 5:36 下午
 * @Version 1.0
 */
public class LargestComponentSize2_952 {
    /*
    * 解题思路：
    * 并查集的思想，用数组记录数之间的关联关系（存在公因数），从1一直存到最大数
    * */
    public static int largestComponentSize(int[] nums) {
        int m = Arrays.stream(nums).max().getAsInt();
        UnionFind uf = new UnionFind(m + 1);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    //这里很巧妙，是降低时间复杂度的关键
                    // 如果i是num的因数，则num、i和num/i都是相连的，将其union即可
                    uf.union(num, i);
                    uf.union(num, num / i);
                }
            }
        }
        int[] counts = new int[m + 1];
        int ans = 0;
        //寻找每一个num对应的root，然后累加计数
        for (int num : nums) {
            int root = uf.find(num);
            counts[root]++;
            ans = Math.max(ans, counts[root]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(largestComponentSize(new int[]{4,6,15,35}));

    }
}
class UnionFind {
    int[] parent;
    int[] rank;


    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        //下面的目的是 使相连的数的根保持一致 便于后续累加求最大值
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
