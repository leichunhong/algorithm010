package Week09.java;

/**
 * 〈功能简述〉<br>
 * 〈〉746. 使用最小花费爬楼梯
 *
 * @author leichunhong
 * @create 2020-08-04
 * @since 1.0.0
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {

        int size = cost.length;
        int[] mincost = new int[size];

        mincost[0] = 0;
        mincost[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < size; i++) {
            mincost[i] = Math.min(cost[i - 1] + cost[i], cost[i - 2] + cost[i - 1]);

        }
        return mincost[size - 1];

    }

   /**
   * @auther  leichunhong
   * @desc 自底向上 从0和i-1 和1和i
    *      第三步=第一层跨两层
    *      第三步=第二层跨一层
   * @date  2020-08-04 20:15  
   * @param  [cost] 
   * @return  int
   */
    public int minCostClimbingStairsI(int[] cost) {
        int size = cost.length;
        int mincost0 = 0;
        int mincost1 = Math.min(cost[0], cost[1]);
        int mincost = 0;
        for (int i = 2; i < size; i++) {
            mincost=Math.min(mincost0 + cost[i-1], mincost1 + cost[i]);
            mincost0=mincost1;
            mincost1=mincost;

        }
        return mincost1;

    }

}
