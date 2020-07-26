package Week01.leichunhong.java;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉88. 合并两个有序数组
 *
 * @author leichunhong
 * @create 2020-07-07
 * @since 1.0.0
 */
public class Merge {

    public  static void merge(int[] nums1, int m, int[] nums2, int n) {

        for(int i=0;i<nums2.length;i++){
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println("数组：" + Arrays.toString(nums1));

    }

    public  static void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }





    public static void main(String[] args) {
      int[]  nums1 = new int[]{1,2,3,0,0,0};
      int[]  nums2 = new int[]{2,5,6};
      merge( nums1, 3, nums2, 2);

    }
}
