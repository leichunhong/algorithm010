package Week04.java;

/**
 * 〈功能简述〉<br>
 * 〈〉 122. 买卖股票的最佳时机 II
 *      动态规划的做法下来研究
 *
 * @author leichunhong
 * @create 2020-07-04
 * @since 1.0.0
 */
public class MaxProfit {
    /**
    * @auther  leichunhong
    * @desc 贪心算法
     *  步骤：1.定义返回的最大值profit
     *       2.循环数组每一天都是今天价格减去昨天价格
     *       3.当发现减去的差大于0说明转了累加到返回值上
     *       4.循环完返回
     *
    * @date  2020-07-04 15:29
    * @param  [prices]
    * @return  int
    */
    public int maxProfitII(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++){
          int  temp=prices[i]-prices[i-1];
          if(temp>0){
              profit+=temp;

          }

        }
        return profit;

    }


    /**
     * @param
     * @return int
     * 121:买卖股票的最佳时机I
     *     步骤：
     *     1.思路定义最小的min=Integer.MAX_VALUE;
     *     2.定义最小值0 因为最少就是0题目要求赚钱大于0
     *     3.循环股票 当循环的值比最小的值小 让最小值=当前循环的值
     *     4.当当前值减去我们定义的最小值>max 时 让最大值=当前循环值-min
     *     5.返回 max
     * @auther leichunhong
     * @desc
     * @date 2020-06-24 19:01
     */
    public int maxProfi1I(int prices[]) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;

            }
        }
        return max;


    }
}
