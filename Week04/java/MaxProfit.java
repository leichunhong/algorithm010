package Week04.java;

/**
 * 〈功能简述〉<br>
 * 〈〉 122. 买卖股票的最佳时机 II
 * 动态规划的做法下来研究
 *
 * @author leichunhong
 * @create 2020-07-04
 * @since 1.0.0
 */
public class MaxProfit {
    /**
     * @param [prices]
     * @return int
     * @auther leichunhong
     * @desc 贪心算法
     * 步骤：1.定义返回的最大值profit
     * 2.循环数组每一天都是今天价格减去昨天价格
     * 3.当发现减去的差大于0说明赚了累加到返回值上
     * 4.循环完返回
     * @date 2020-07-04 15:29
     */
    public int maxProfitII(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                profit += temp;

            }

        }
        return profit;

    }


    /**
     * @param
     * @return int
     * 121:买卖股票的最佳时机I
     * 步骤：
     * 1.思路定义最小的min=Integer.MAX_VALUE;
     * 2.定义最小值0 因为最少就是0题目要求赚钱大于0
     * 3.循环股票 当循环的值比最小的值小 让最小值=当前循环的值
     * 4.当当前值减去我们定义的最小值>max 时 让最大值=当前循环值-min
     * 5.返回 max
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

    /**
     * @param
     * @return int
     * @auther leichunhong
     * @desc 过第二遍
     * @date 2020-07-05 20:08
     */
    public int maxProfit1(int[] prices) {
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

    /**
     * @param
     * @return int
     * @auther leichunhong
     * @desc 白板写的代码
     * @date 2020-07-05 20:13
     */
    public int maxProfi2(int[] prices) {
        int n = prices.length;
        int db_i_0 = 0;
        int db_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            db_i_0 = Math.max(db_i_0, db_i_1 + prices[i]);
            db_i_1 = Math.max(db_i_1, -prices[i]);
        }
        return db_i_0;
    }

    /**
     * @param
     * @return int
     * @auther leichunhong
     * @desc 白板写的 买卖股票的最佳时机 II 但是效率不高主要掌握这种方法
     * @date 2020-07-05 20:18
     */
    public int maxProfitII1(int[] prices) {
        int n = prices.length;
        int db_i_0 = 0;
        int db_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            //每天多次买卖
            int temp = db_i_0;
            db_i_0 = Math.max(db_i_0, db_i_1 + prices[i]);
            db_i_1 = Math.max(db_i_1, temp - prices[i]);

        }
        return db_i_0;

    }

    /**
     * @param [prices]
     * @return int
     * @auther leichunhong
     * @desc 写第二遍 贪心算法  买卖股票的最佳时机 II
     * @date 2020-07-05 20:21
     */
    public int maxProfitII2(int[] prices) {

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                max += temp;
            }

        }
        return max;
    }

    /**
     * @param
     * @return int
     * @auther leichunhong
     * @desc 309. 最佳买卖股票时机含冷冻期
     * @date 2020-07-05 20:55
     */
    public int maxProfitIII(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 代表 dp[i-2][0]
        for (int i = 0; i < n; i++) {
            //代表上次没有持股可以多次买卖的for循环需要加这个临时变量代表上次没有持股的时候的状态
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            //这个是需要从dp[i-2][0]-减去当前值因为中间有冷冻期
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            //w为啥赋值给i-2
            dp_pre_0 = temp;
        }
        return dp_i_0;


    }

    /**
    * @auther  leichunhong
    * @desc 714. 买卖股票的最佳时机含手续费
    * @date  2020-07-10 11:37
    * @param  [prices, fee]
    * @return  int
    */
    public int maxProfitIIII(int[] prices, int fee) {
        int n=prices.length;
        int db_i_0=0;
        int db_i_1=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            //多次需要定临时变量
            int temp=db_i_0;
            db_i_0=Math.max(db_i_0,db_i_1+prices[i]);
            //交易手续费需要-free
            db_i_1=Math.max(db_i_1,temp-prices[i]-fee);
        }
        return db_i_0;

    }

    /**
    * @auther  leichunhong
    * @desc 123. 买卖股票的最佳时机 III  不对
    * @date  2020-07-10 11:37
    * @param
    * @return  int
    */
    public int maxProfitIIII(int[] prices) {
        int n = prices.length;
        int max_k=2;
        int[][][] db=new int[n][max_k+1][2];
        for (int i = 0; i < n; i++) {
            for(int k=max_k;k>=1;k--){
                if(i-1==-1){
                    db[i][k][0]=0;

                }
                db[i][k][0]=Math.max(db[i][k][0],db[i][k][1]+prices[i]);
                db[i][k][1]=Math.max(db[i][k][1],db[i-1][k-1][0]-prices[i]);

            }

        }
        return db[n-1][max_k][0];
    }



    /**
     * @auther  leichunhong
     * @desc 123. 买卖股票的最佳时机 III  不对
     * @date  2020-07-10 11:37
     * @param
     * @return  int
     */


    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // dp[i][j] ，表示 [0, i] 区间里，状态为 j 的最大收益
        // j = 0：什么都不操作
        // j = 1：第 1 次买入一支股票
        // j = 2：第 1 次卖出一支股票
        // j = 3：第 2 次买入一支股票
        // j = 4：第 2 次卖出一支股票

        // 初始化
        int[][] dp = new int[len][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 3 状态都还没有发生，因此应该赋值为一个不可能的数
        for (int i = 0; i < len; i++) {
            dp[i][3] = Integer.MIN_VALUE;
        }

        // 状态转移只有 2 种情况：
        // 情况 1：什么都不做
        // 情况 2：由上一个状态转移过来
        for (int i = 1; i < len; i++) {
            // j = 0 的值永远是 0
            dp[i][0] = 0;
            //买入 或者昨天没有 今天买了-prices[i]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            //第二天卖出
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            //买
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            //卖
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        // 最大值只发生在不持股的时候，因此来源有 3 个：j = 0 ,j = 2, j = 4
        return Math.max(0, Math.max(dp[len - 1][2], dp[len - 1][4]));
    }


}
