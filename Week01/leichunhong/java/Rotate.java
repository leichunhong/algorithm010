package Week01.leichunhong.java;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉189. 旋转数组
 *
 * @author leichunhong
 * @create 2020-07-06
 * @since 1.0.0
 */
public class Rotate {
    /**
     * @param [nums, k]
     * @return void
     * @auther leichunhong
     * @desc 自己写的不对 不能这样写
     * @date 2020-07-06 14:12
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return;
        }

        int[] newNums = new int[nums.length];
        int j = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            newNums[j] = nums[i];
            j++;
        }

        for (int i = 0; i < nums.length - k; i++) {
            newNums[j] = nums[i];
            j++;
        }


    }

    /**
     * @param
     * @return void
     * @auther leichunhong
     * @desc 这也不对
     * @date 2020-07-06 14:13
     */
    public static void rotate1(int[] nums, int k) {
        nums = Arrays.copyOf(nums, nums.length + k);
        if (nums == null || k > nums.length) {
            return;
        }

        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        int n = k;
        for (int i = 0; i < k; i++) {
            nums[i] = nums[nums.length - n];
            n--;
        }
        nums = Arrays.copyOf(nums, nums.length - k);
        System.out.println(Arrays.toString(nums));

    }

    /**
     * @param
     * @return void
     * @auther leichunhong
     * @desc  思路：换位置
     *        1.把整个数组交换一遍位置 0到length-1
     *        2.把前k个交换位置
     *        3.把剩余的交换位置
     *        4.搞定
     *
     * @date 2020-07-06 14:13
     */
    public static void rotate3(int[] nums, int k) {
        k = k % nums.length;
        //从0到length-1交换 倒序 [7, 6, 5, 4, 3, 2, 1]
        reverse(nums, 0, nums.length - 1);
        //交换前k个             [5, 6, 7, 4, 3, 2, 1]
        reverse(nums, 0, k - 1);
        //交换k到length - 1     [5, 6, 7, 1, 2, 3, 4]
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate3(nums, 3);
    }

}
