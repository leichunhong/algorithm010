package Week06.java;

/**
 * 〈功能简述〉<br>
 * 〈〉198. 打家劫舍
 *
 * @author leichunhong
 * @create 2020-07-17
 * @since 1.0.0
 */
public class Rob {
    /**
     * @param
     * @return int
     * @auther leichunhong
     * @desc
     * @date 2020-07-17 23:22
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] db = new int[n][2];
        //没有偷
        db[0][0] = 0;
        //偷第一个
        db[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            // 今天没偷=昨天没偷和昨天偷了的最大值
            db[i][0] = Math.max(db[i - 1][0], db[i - 1][1]);
            //今天偷了=昨天肯定没偷+今天偷了
            db[i][1] = db[i - 1][0] + nums[i];

        }
        return Math.max(db[n - 1][0], db[n - 1][1]);
    }


    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] db = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            db[i] = Math.max(db[i + 1], db[i + 2] + nums[i]);
        }
        return db[0];
    }


    public int rob2(int[] nums) {
        int n = nums.length;
        // 记录 dp[i+1] 和 dp[i+2]
        int dp_i_1 = 0, dp_i_2 = 0;
        // 记录 dp[i]
        int dp_i = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }


}
