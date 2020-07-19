package Week06.java;

/**
 * 〈功能简述〉<br>
 * 〈〉53. 最大子序和
 *
 * @author leichunhong
 * @create 2020-07-16
 * @since 1.0.0
 */
public class MaxSubArray {
    /**
    * @auther  leichunhong
    * @desc   这个暴力我写的跟shi一样的代码
    * @date  2020-07-16 14:30  
    * @param  [nums] 
    * @return  int
    */
    public static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];

        }
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            int temp = nums[i];
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, temp);
                if (j < nums.length - 1) {
                    temp += nums[j + 1];
                }
            }
            sum = Math.max(sum, max);

        }
        return sum;


    }


    public static int maxSubArray1(int[] nums) {
        int ans=nums[0];
        int sum=0;
        for (int num : nums) {
            if(sum>0){
                sum+=num;
            }else{
                sum=num;
            }
            ans=Math.max(ans,sum);

        }
        return ans;
    }

    /**
    * @auther  leichunhong
    * @desc 思路：如果相加没有nums[i]大，那么就舍弃nums[i]前面的从ums[i]重新开始算
     *           开始没想通这个点 想通了就写出来了。
     *           自己的思路是从每一位开始往后算求出最大的。递推公式我都写出来了，我以为是一遍过去搞不定。。。。
    * @date  2020-07-16 14:35
    * @param  [nums]
    * @return  int
    */

    public static int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //如果相加没有nums[i]大，那么就舍弃nums[i]前面的从ums[i]重新开始算
            dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,9,10,-21,100,200};
        System.out.println(maxSubArray2(nums));

    }
}
