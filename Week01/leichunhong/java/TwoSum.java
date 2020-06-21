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
 * 步骤：1.定义返回数组map<Integer,Integer>
 *      2.循环数组 先暴力往map添加key=nums[i] 和valus=i
 *      3.在循环里面 put上面处理 if(map.containsKey(tag-nums[i])) return
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
    * @date  2020-06-15 12:34
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
