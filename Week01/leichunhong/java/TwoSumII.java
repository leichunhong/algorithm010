package Week01.leichunhong.java;

import java.util.HashMap;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * @create 2020-07-20
 * @since 1.0.0
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
           if (map.containsKey(target-numbers[i])){
               return new int[]{map.get(target-numbers[i]),i+1};

           }

            map.put(numbers[i],i+1);
        }
        return null;

    }


    public int[] twoSum1(int[] numbers, int target) {

         int left=0;
         int ritht=numbers.length-1;
         while(left<=ritht){
             int sum=numbers[left]+numbers[ritht];

             if(sum==target){
                 return   new int[]{left+1, left+1};

             }else if(sum>target){
                 ritht--;

             }else{
                 left++;
             }


         }
        return new int[]{-1, -1};

    }



}
