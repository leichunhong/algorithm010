package Week07.java;

/**
 * 〈功能简述〉<br>
 * 〈〉130. 被围绕的区域
 *
 * @author leichunhong
 * @create 2020-07-26
 * @since 1.0.0
 */
public class Solve {


    public void solveII(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        //第一列和最后一列
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfsII(i, 1, board);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfsII(i, board[0].length - 2, board);
            }

        }

        //第一行和最后一行
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O')
                dfsII(1, i, board);
            if (board[board.length - 1][i] == 'O')
                dfsII(board.length - 2, i, board);
        }

        //中间的 为啥把*变成X TODO
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }


    }

    private void dfsII(int i, int j, char[][] board) {
        if (i <= 0 || i >= board.length - 1 || j <= 0 || j >= board[0].length - 1 || board[i][j] == 'X') {
            return;
        }
        if (board[i][j] == '*') {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '*';
        }
        dfsII(i + 1, j, board);
        dfsII(i - 1, j, board);
        dfsII(i, j + 1, board);
        dfsII(i, j - 1, board);
    }



}
