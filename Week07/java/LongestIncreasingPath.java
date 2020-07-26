package Week07.java;

/**
 * 〈功能简述〉<br>
 * 〈〉329. 矩阵中的最长递增路径
 *     理解题意： 每一个值都存在 四个方向都要比他小的值才能dfs
 *               dfs的参数：一版几维的需要传纬度值，比如二维需要穿横坐标i纵坐标j和原始数组和访问数组
 *               1.双向循环，判断访问的数据是初始值[0][0]的时候，进行dfs
 *               2.dfs(i,j,matrix,visited)
 *               3.dfs第一步check参数的合法性，
 *               4.返回出口visited[i][j] > 0 return visited[i][j？
 *               5.上下左右进行dfs： max = Math.max(max, dfs(i, j, matrix, visited)) i和j会变化
 *               6.visited[i][j] = max + 1;   return max + 1;
 *               时间和空间复杂度：O(m*n)
 * @author leichunhong
 * @create 2020-07-26
 * @since 1.0.0
 */
public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        //check
        if (matrix == null||matrix.length==0) {
            return 0;

        }
        int[][] visited = new int[matrix.length][matrix[0].length];
        //双层循环调用bfs
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j] == 0) {
                    max = Math.max(max, dfs(i, j, matrix, visited));
                }

            }


        }
        return max;


    }

    private int dfs(int i, int j, int[][] matrix, int[][] visited) {

        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return 0;
        }
        //？
        if (visited[i][j] > 0) {
            return visited[i][j];

        }
        int max = 0;
        //大与左边
        if (i - 1 >= 0 && matrix[i - 1][j] < matrix[i][j]) {
            max = Math.max(max, dfs(i - 1, j, matrix, visited));
        }
        //大与右边
        if (i + 1 < matrix.length && matrix[i + 1][j] < matrix[i][j]) {
            max = Math.max(max, dfs(i + 1, j, matrix, visited));
        }
        //大与上边
        if (j - 1 >= 0 && matrix[i][j - 1] < matrix[i][j]) {
            max = Math.max(max, dfs(i, j - 1, matrix, visited));
        }
        //大与下边
        if (j + 1 < matrix[0].length && matrix[i][j + 1] < matrix[i][j]) {
            max = Math.max(max, dfs(i, j + 1, matrix, visited));
        }
        //赋值
        visited[i][j] = max + 1;
        return max + 1;

    }

}
