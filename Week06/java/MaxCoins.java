package Week06.java;

/**
 * 〈功能简述〉<br>
 *     每日一题
 * 〈〉 312. 戳气球 困难 做不出来！
 *        db方程的理解：算i到j之间的需要引入最后一个呗戳破的状态k
 *                     =戳破i到k之间的气球db[i][k]，再戳破k到j之间的气球db[k][j]此时剩下的未戳破的是 i k j
 *                      最后戳破k 根据题意就是得分就是points[i]*points[k]*points[j]
 *                      =db[i][k]+db[k][j]+points[i]*points[j]*points[k]
 * @author leichunhong
 * @create 2020-07-19
 * @since 1.0.0
 */
public class MaxCoins {
    public int maxCoins(int[] nums) {

        int n=nums.length;

        //虚拟两个哨兵 points[0]和points[n+1]：就是求points[0]和points[n+1]之间
        //points[1]到points[n]之间的的最值
        int[] points=new int[n+2];
        //哨兵赋值
        points[0]=points[n+1]=1;
        //根据nums组装新数组points
        for(int i=1;i<=n;i++){
            points[i]=nums[i-1];
        }
        //db
        int[][] db=new int[n+2][n+2];
        //i 从下往上
        for(int i=n;i>=0;i--){
            //j 从i+1往右
            for(int j=i+1;j<n+2;j++){
                //k代表最后一个戳破气球的状态 从i+1到j
                for(int k=i+1;k<j;k++){
                    //db方程
                    db[i][j]=Math.max(db[i][j],
                            db[i][k]+db[k][j]+points[i]*points[j]*points[k]);
                }
            }
        }
        return db[0][n+1];
    }



}
