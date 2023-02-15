package com.leetcode.DMSXL.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/2/15 19:41
 * @Version 1.0
 */
/*
* 编写一个程序，通过填充空格来解决数独问题
* */
public class SolveSudoku_37 {
    //使用三个集合分别记录同一行、同一列、同一九宫格出现的数字
    //line[2][4]表示第二行5已经出现
    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    //表示九宫格已经出现的位置和数字
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    //利用space记录空白的位置，即需要填的位置
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        //遍历棋盘，将空的位置记录，未空的位置更新三个集合
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                }else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }
        backtrack(board, 0);
    }

    public void backtrack(char[][] board, int pos) {
        if(pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for(int digit = 0; digit < 9 && !valid; digit++) {
            if(!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                backtrack(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }

    }
}
