package Week09.java;

/**
 * 〈功能简述〉<br>
 * 〈〉63. 不同路径 II
 *
 * @author leichunhong
 * @create 2020-08-03
 * @since 1.0.0
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] db = new int[m][n];
        //有障碍把后面全部整成障碍物
        for (int i = 0; i < m && obstacleGrid[i][0] != 1; i++) {
            db[i][0] = 1;
        }
        //一样有障碍把后面全部整成障碍物
        for (int j = 0; j < n&&obstacleGrid[0][j] != 1;j++) {
            db[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //计算无障碍物的
                if(obstacleGrid[i][j] != 1){
                    db[i][j]=db[i][j-1]+db[i-1][j];
                }


            }

        }
        return db[m-1][n-1];

    }


}
