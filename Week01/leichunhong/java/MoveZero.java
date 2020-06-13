package Week01.leichunhong.java;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉思路：非0向前移动没问题，最后一步把0换到后面去有点没搞懂
 *
 * @author leichunhong
 * @create 2020-06-09
 * @since 1.0.0
 */
public class MoveZero {


    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("数组：" + Arrays.toString(nums));
            //是0不做处理，不是0的话让这个数往非0的这个j开始的index移动就是nums[j]=nums[i](非0)，然后移动的这个非0的位置拿0替换就是num[i]=0
            if (nums[i] != 0) {
                System.out.println("i:" + i);
                System.out.println("j:" + j);
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }

        }

    }


    /**
     * @param
     * @return void
     * @auther leichunhong
     * @desc 这种方法很容易懂
     * @date 2020-06-09 13:45
     */
    public static void moveZeroes2(int[] nums) {
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }


    /**
     * @param
     * @return
     * @auther leichunhong
     * @desc 默写老师的代码
     * @date 2020-06-09 13:31
     */
    public static void moveZeroes1(int[] nums) {
        //记非0的index
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("数组：" + Arrays.toString(nums));
            if (nums[i] != 0) {
                //非0 往前放
                nums[j] = nums[i];
                if (i != j) {
                    //移走的i的位置放0
                    nums[i] = 0;
                }
                j++;
            }

        }
        System.out.println("数组：" + Arrays.toString(nums));

    }

    /**
     * @param
     * @return void
     * @auther leichunhong
     * 第一遍
     * @desc 默写很容易懂的写法
     * @date 2020-06-09 13:47
     */
    public static void moveZeroes3(int[] nums) {

        //第一遍只要是非0的统统都赋给nums[j]
        int j=0;
        for (int num : nums) {
            if(num!=0){
                nums[j]=num;
                j++;
            }
        }
        //替换后面的末尾的元素都赋为0即可从j起最后肯定是0
        for(int i=j;i<nums.length;i++){
            nums[i]=0;
        }

    }




    /**
    * @auther  leichunhong
    * @desc 移动0第二遍 默写
    * @date  2020-06-10 13:38
    * @param
    * @return  void
    */

    public static void moveZeroes4(int[] nums) {


        int j=0;
        for (int num : nums) {
            if(num!=0){
                nums[j]=num;
                j++;
            }

        }
        for(int i=j;i<nums.length;i++){
            nums[i]=0;
        }

    }



        public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 3, 0, 4};
        moveZeroes1(arr);
    }

}
