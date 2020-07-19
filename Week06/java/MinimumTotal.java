package Week06.java;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉120. 三角形最小路径和
 * 1.自己写成贪心算法了，每一步最优结果不是最小值
 *
 * @author leichunhong
 * @create 2020-07-14
 * @since 1.0.0
 */
public class MinimumTotal {


    public static int minimumTotal1(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // dp中记录了求第i行时，第i+1的最小路径和
        // 第一次bd里面是 1 -1 3
        // 第二次
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
            }
        }
        return dp[0];
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle==null){
            return 0;
        }

        int[] db=new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            List<Integer> rows=triangle.get(i);
            for(int j=0;j<rows.size();j++){
                //b[j],db[j+1]是上一层的第一二个数据，算的是这一行的第一个j的数据
                db[j]=Math.min(db[j],db[j+1])+rows.get(j);

            }

        }
        return db[0];
    }


        /**
        * @auther  leichunhong
        * @desc 主要是找状态转移
         *     步骤1：记住二维的先申请二维数组 db[][]
         *        2.for循环从顶想下循环-外层循环
         *        3.内存循环子List就是List<Integer>
         *        4.状态转义就是一定确定有 db[i][j]=min(db[i+1][j],db[i+1][j+1]+rows.get(i))
         *
        * @date  2020-07-14 15:12
        * @param
        * @return  int
        */
    public static int minimumTotal(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // 加1可以不用初始化最后一行
        // 根据题意，行列值相同
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];

        for (int i=triangle.size()-1;i>=0;i--) {
            List<Integer> rows = triangle.get(i);
            for(int j=0;j<rows.size();j++){
                //dp[i+1]就是上一次放的那一行
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+rows.get(j);
            }
        }
        return dp[0][0];
    }

    /**
    * @auther  leichunhong
    * @desc  -1
     *       2 3
     *       1 -1 3
     *
    * @date  2020-07-15 22:14
    * @param 、
    * @return  void
    */
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(-1);
        list3.add(-3);

        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        System.out.println(minimumTotal1(list));

    }
}
