package Week07.java;

/**
 * 〈功能简述〉<br>
 * 〈〉64. 最小路径和
 *
 * @author leichunhong
 * @create 2020-07-23
 * @since 1.0.0
 */
public class MinPathSum {

    /**
     * @param [grid]
     * @return int
     * @auther leichunhong
     * @desc 复习一遍最小路径和
     * db方程：  db[i][j]+=min(db[i-1][j],[i][j-1])
     * @date 2020-07-23 18:18
     */
    public int minPathSum(int[][] grid) {
        //行
        int m = grid[0].length;
        //列
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }

            }
        }
        return grid[n - 1][m - 1];
    }

    /**
    * @auther  leichunhong
    * @desc
    * @date  2020-07-23 22:45
    * @param  [S] 
    * @return  java.lang.String
    */
    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0, j = S.length() - 1; i < j; ) {
            if (!Character.isLetter(sb.charAt(i))) {
                ++i;
            } else if (!Character.isLetter(sb.charAt(j))) {
                --j;
            } else {
                sb.setCharAt(i, S.charAt(j));
                sb.setCharAt(j--, S.charAt(i++));
            }
        }
        return sb.toString();
    }



}
