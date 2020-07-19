package Week06.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 62. 不同路径
 *
 * @author leichunhong
 * @create 2020-07-14
 * @since 1.0.0
 */
public class UniquePaths {

    /**
     * @param
     * @return int
     * @auther leichunhong
     * @desc 二维的做法
     * 1、步骤按照规律只能想左或者向下走，状态转移公式就是： dp[i][j] = dp[i][j-1] + dp[i-1][j];
     * 2、注意第一行和第一列都应该是1 我用循环赋值了
     * 3、返回db[m-1][n-1]的值就是最终步数
     * 时间复杂度O(m*n) 空间复杂度dp[m][n]
     * @date 2020-07-14 17:10
     */
    public static int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * @param [m, n]
     * @return int
     * @auther leichunhong
     * @desc 降纬度思路：
     * 一维就是放一行或者一列的数据，列就是从左往右推，每次循环列拿当前的值和db存的上一列的值错位相加。
     * 依次往后到最后一个格子就ok啦，行的话从上往下推，每次循环行拿当前的值和db上一行存的值错位相加，
     * 一直推到最后一行最后一个格子 就ok啦！！！
     * 1.拿m是3，n是4 举例 m是行 n是列
     * <p>
     * 2.第一遍列db[n]=[1,1,1,1] 是四个一就是第一列的数据
     * <p>
     * 3.循环当前第二列依次拿当前列的值和上一列的值db[n]=[1,1,1,1]错位相加 结果db[n]= [1,2,3,4]
     * 比如第二列的2的值求法这一列i是1：
     * db[i]+db[i-1]=1+1=2 就是 db[1]=1, db[i-1]=db[0]=1相加就是2 数组变成 db[n]=[1,2,1,1]
     * <p>
     * 4.下一个3的值db[i]+db[i-1]=db[2]+db[1]=1+2=3这个db就是上一行求出来的db[n]=[1,2,1,1]，那么db会变成 bd[n]=[1,2,3,1]
     * <p>
     * 5.下一个4的值db[i]+db[i-1]=db[3]+db[2]=1+3=4
     * <p>
     * 6.第三列i是2循环四步db变化
     * db[n]=[1,3,3,4]--->db[n]=[1,3,6,4]---->db[n]=[1,3,6,10]
     * <p>
     * 6.每列这样递推到最后一列最后一个格子就ok了
     * <p>
     * 当然你也可以行递推
     * 举例的3*4的步数就是
     * 1 1 1
     * 1 2 3
     * 1 3 6
     * 1 4 10
     * @date 2020-07-14 17:10
     */
    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[(n - 1)];
    }

   /**
   * @auther  leichunhong
   * @desc
   * @date  2020-07-16 09:58  
   * @param
   * @return  int
   */
    public static int uniquePaths2(int m, int n) {
        int[] db = new int[n];
        //把第一列全部为1
        for (int i = 0; i < n; i++) {
            db[i] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //db[j-1] 拿第一遍例子说明这个db[j-1]就是第一次循环n放进去的1数据
                db[j]=db[j]+db[j-1];
            }

        }
        //长度是你最好一个格子就是n-1
        return db[n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths1(3, 4));
    }
}
