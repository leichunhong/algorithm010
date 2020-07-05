package Week04.java;

import java.util.ArrayList;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 322. 零钱兑换
 * 步骤：1.第一次循环循环 总金额
 *      2.第二次循环循环子集的金钱数
 *      3.总金额的i-循环的金钱树大于0时候
 *
 * @author leichunhong
 * @create 2020-06-30
 * @since 1.0.0
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {

        int[] f = new int[amount + 1];
        f[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 1; i <= amount; i++) {

            int cost = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (f[i - coins[j]] != Integer.MAX_VALUE)
                        cost = Math.min(cost, f[i - coins[j]] + 1);
                }
            }

            f[i] = cost;
        }

        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];

    }

    public static void main(String[] args) {
        int[] db = new int[]{1, 2, 5};
        System.out.println(coinChange(db, 11));
    }
}
