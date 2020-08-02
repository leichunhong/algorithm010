package Week08.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉     51. N皇后
 * 回朔模板
 * 看不懂有些 需要下来再多做几遍
 *
 * @author leichunhong
 * @create 2020-07-28
 * @since 1.0.0
 */
public class SolveNQueens {

    //返回集合
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        //定义二维数组
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //空位
                board[i][j] = '.';
            }
        }
        dfs(board, 0);
        return ans;

    }

    private void dfs(char[][] board, int colIndex) {
        if (colIndex == board.length) {
            ans.add(construct(board));
            return;
        }

        //主业务
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, colIndex)) {
                //做当前业务
                board[i][colIndex] = 'Q';
                //下探
                dfs(board, colIndex + 1);
                //恢复
                board[i][colIndex] = '.';

            }
        }


    }

    //判断
    private boolean validate(char[][] board, int x, int colIndex) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < colIndex; j++) {
                //?????
                boolean flag = (x + j == colIndex + i || x + colIndex == i + j || x == i);
                if (board[i][j] == 'Q' && flag) {
                    return false;

                }

            }

        }
        return true;

    }

    /**
     * @param
     * @return java.util.List<java.lang.String>
     * @auther leichunhong
     * @desc 封装成List<String> 放到ans
     * @date 2020-07-28 21:50
     */
    private List<String> construct(char[][] board) {
        //内层的List<String>
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;

    }





    /*public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }

        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }*/


}
