package Week04.java;

/**
 * 〈功能简述〉<br>
 * 〈〉 200. 岛屿数量
 *     步骤：1.定义返回count和二维数组的长度及x轴的长度都一样取grid[0].length
 *          2.双层循环循环二维数组
 *          3.当grid[i][j]='1' count++ dfs遍历老师的话把上下左右全部的1改完'0' 递归下去
 *          4.注意点grid[i][j]等的是char '1'  不是1或者0
 *          5.记得判断整个二维数组为null的情况
 *
 * @author leichunhong
 * @create 2020-07-05
 * @since 1.0.0
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        if (n == 0) {
            return 0;

        }
        int sz = grid[0].length;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < sz; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, n, sz);
                    count++;

                }

            }
        return count;

    }


    private void dfs(char[][] grid, int i, int j, int n, int sz) {

        if (i < 0 || j < 0 || i >= n || j >= sz || grid[i][j] == '0') {
            return;
        }
        //夷为平地 为0
        grid[i][j] = '0';
        dfs(grid, i + 1, j, n, sz);
        dfs(grid, i - 1, j, n, sz);
        dfs(grid, i, j + 1, n, sz);
        dfs(grid, i, j - 1, n, sz);
    }


}





