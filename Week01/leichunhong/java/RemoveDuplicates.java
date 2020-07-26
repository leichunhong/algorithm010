package Week01.leichunhong.java;

import java.util.HashSet;
import java.util.Set;

/**
 * 〈功能简述〉<br>
 * 〈〉26. 删除排序数组中的重复项
 *
 * @author leichunhong
 * @create 2020-07-06
 * @since 1.0.0
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            nums[j] = nums[i];
            set.add(nums[i]);
            j++;

        }
        return j;

    }

    /**
    * @auther  leichunhong
    * @desc 因为是排序好的可以这样做
    * @date  2020-07-06 10:34
    * @param
    * @return  int
    */
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i == 0 || n > nums[i - 1]) {
                nums[i++] = n;
            }
        }
        return i;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

}
