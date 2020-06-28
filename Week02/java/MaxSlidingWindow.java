package Week02.java;

/**
 * 〈功能简述〉<br>
 * 〈〉239. 滑动窗口最大值
 *
 * @author leichunhong
 * @create 2020-06-21
 * @since 1.0.0
 */
public class MaxSlidingWindow {

    /**
    * @auther  leichunhong
    * @desc 暴力步骤 1.定义个n-k+1的数组
     *              2.外从i=0循环到 n-k+1
     *              3.内循环从i到i+k，取最大的值
     *              5.数组放值
    * @date  2020-06-21 13:20
    * @param  [nums, k]
    * @return  int[]
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        if (n * k == 0) return new int[0];

        for(int i=0;i<n-k+1;i++){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                max=Math.max(max,nums[j]);
            }
            ans[i]=max;
        }
        return ans;



    }



    }
