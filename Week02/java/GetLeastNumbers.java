package Week02.java;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * @create 2020-06-18
 * @since 1.0.0
 */
public class GetLeastNumbers {
    /**
    * @auther  leichunhong
    * @desc 自己的暴力就是排序 再 取前k个
    * @date  2020-06-18 10:16  
    * @param
    * @return  int[]
    */
    public static  int[] getLeastNumbers(int[] arr, int k) {

        int[]  arrs=new int[k];

        if(arr.length<k){
            return arrs;
        }
        Arrays.sort(arr);
        for(int i=0;i<k;i++){
            arrs[i]=arr[i];
        }
        return arrs;

    }

    public static void main(String[] args) {
        int[] arr=new int[]{3,2,1};
        getLeastNumbers(arr,2);

    }


    }
