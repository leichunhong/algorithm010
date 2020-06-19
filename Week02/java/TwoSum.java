package Week02.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉 1. 两数之和
 *
 * @author leichunhong
 * @create 2020-06-14
 * @since 1.0.0
 */
public class TwoSum {

    /**
    * @auther  leichunhong
    * @desc 哈希映射
    * @date  2020-06-15 12:34
    * @param
    * @return  int[]
    */
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            //if(map.get(target-nums[i])!=null){
            if(map.containsKey(target-nums[i])){
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return nums;

    }




}
