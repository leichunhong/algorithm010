package Week01.leichunhong.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉 暴力循环
 *
 * @author leichunhong
 * @create 2020-06-14
 * @since 1.0.0
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];

        if (nums == null || nums.length < 2) {
            return nums;

        }
        for (int i = 0; i < nums.length; i++) {
            int r = nums.length - 1;
            while (i < r) {
                if (nums[i] + nums[r] == target) {
                    array[0] = i;
                    array[1] = r;
                    return array;
                } else {
                    r--;
                }
            }
        }
        return array;

    }
    /**
    * @auther  leichunhong
    * @desc 哈希映射
    * @date  2020-06-14 20:46  
    * @param  [nums, target] 
    * @return  int[]
    */
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[] {map.get(target-nums[i]),i};

            }
            map.put(nums[i],i);

        }
        return nums;

    }


    public static void main(String[] args) {
        int[] array = new int[]{3,2,4};
       System.out.println(Arrays.toString(twoSum(array, 6)));

    }


}
