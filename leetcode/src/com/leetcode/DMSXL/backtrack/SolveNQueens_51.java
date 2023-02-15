package com.leetcode.DMSXL.backtrack;

import java.util.*;

/**
 * @Author zyh
 * @Date 2023/2/15 18:39
 * @Version 1.0
 */
/*
* n皇后问题:将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击
*   皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子
* 输入：n = 4
* 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
* */
public class SolveNQueens_51 {
    //创建三个集合，分别记录在列以及两个方向斜线上的已经存在皇后的位置
    //使用数组记录每行放置皇后的下标
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        //索引为行位置，值为列位置
        int[] queue = new int[n];
        Arrays.fill(queue, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(ans, queue, n, 0, columns, diagonals1, diagonals2);
        return ans;
    }

    public void backtrack(List<List<String>> ans, int[] queue, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if(row == n) {
            List<String> board = generateBoard(queue, n);
            ans.add(board);
        }else {
            for(int i = 0; i < n; i++) {
                if(columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if(diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if(diagonals2.contains(diagonal2)) {
                    continue;
                }
                queue[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(ans, queue, n, row + 1, columns, diagonals1, diagonals2);
                queue[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queue, int n) {
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queue[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
