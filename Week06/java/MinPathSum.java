package Week06.java;

/**
 * 〈功能简述〉<br>
 * 〈〉64. 最小路径和
 * 步骤：1.先算第一行每次从1开始使用grid[0][i]+grid[0][i-1]累加
 *      2.再算第一列每次从1开始使用grid[j][0]+grid[j-1][0]累加
 *      3.二维数组就是grid[i][j]+=grid[i-1][j]+grid[i][j-1]
 * 时间复杂度：O(m*n) 空间复杂度：O(1)没有额外的空间
 *
 * @author leichunhong
 * @create 2020-07-13
 * @since 1.0.0
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        //行
        int n = grid[0].length;
        //列
        int m = grid.length;
        //处理只有第一行
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        //处理只有第一行
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);

            }
        }
        return grid[m - 1][n - 1];
    }


    public int minPathSum1(int[][] grid) {
        //行
        int n = grid[0].length;
        //列
        int m = grid.length;
        //在循环里面处理只有第一列和第一行
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 & j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }

            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * @param
     * @return
     * @auther leichunhong
     * @desc * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：每次只能向下或者向右移动一步
     * [1,3,1]
     * [1,5,1]
     * [4,2,1]
     * 步骤看见这个题：1.首先想双层循环
     * 2.处理只有一行和一列的数据
     * 3.大于一行和一列的情况比如拿第二行的5举例，5这个格子怎么走来的
     * 因为只能向下走到5或者只能向右走到5，例子中就是从1右走到5或者从3下来到5，那就是i-1或者j-1就是db[i][j]=db[i-1][j]+db[i][j-1]
     * 需要取最小db[i][j]=min(db[i-1][j]+db[i][j-1])
     * @date 2020-07-16 10:11
     */

    public int minPathSum2(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }

            }
        }
        return grid[n - 1][m - 1];

    }


}
