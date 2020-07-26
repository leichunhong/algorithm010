package Week04.java;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 42.
 *
 * @author leichunhong
 * @create 2020-07-11
 * @since 1.0.0
 */
public class TrapWater {

    /**
     * @param [height]
     * @return int
     * @auther leichunhong
     * @desc 来研究下经典代码
     * 核心思路：循环x轴 i 接雨水就是 i的左边最高的 或者i的右边最高的 取最小的min(L_max,R_max)-height[i]
     * L_max=max(height[012.....i])
     * R_max=max(height[i.....n-1])
     * height[i]：y轴的高度（黑色块）
     * 循环完依次累加
     * @date 2020-07-11 23:09
     */
    public int trap(int[] height) {
        int a = 0;
        int b = height.length - 1;
        int max = 0;
        int leftmax = 0;
        int rightmax = 0;
        while (a <= b) {
            leftmax = Math.max(leftmax, height[a]);
            rightmax = Math.max(rightmax, height[b]);
            if (leftmax < rightmax) {
                max += (leftmax - height[a]);
                a++;
            } else {
                max += (rightmax - height[b]);
                b--;
            }
        }
        return max;
    }

    /**
     * @param [height]
     * @return int
     * @auther leichunhong
     * @desc
     * @date 2020-07-11 23:21
     */
    public int trap1(int[] height) {
        //左边
        int a = 0;
        //右边
        int b = height.length - 1;
        //返回的最大值 初始值0
        int max = 0;
        //最大左最高 初始值0
        int leftmax = 0;
        //最大右最该 初始值0
        int rightmax = 0;
        //a<=b很像二分法的 left<Right
        //两边往中间夹     bi
        while (a <= b) {
            //依次状态装换左边的最大值
            leftmax = Math.max(leftmax, height[a]);
            //依次状态装换右边的最大值
            rightmax = Math.max(rightmax, height[b]);
            //说明左边最小 max+左边的最大值-左边的高度height[a]
            if (leftmax < rightmax) {
                max += (leftmax - height[a]);
                a++;
                //说明右边最小 max+右边的最大值-右边的高度height[b]
            } else {
                max += (rightmax - height[b]);
                b--;
            }

        }
        return max;


    }

    public int trapII(int[] height) {
        int a=0;
        int b=height.length-1;
        int max=0;
        int leftMax=0;
        int rightMax=0;
        while(a<=b){
            leftMax=Math.max(leftMax,height[a]);
            rightMax=Math.max(rightMax,height[b]);
            if(leftMax<rightMax){
                max+=(leftMax-height[a]);
                a++;
            }else{
                max+=(rightMax-height[b]);
                b--;
            }

        }
        return max;


    }

    /**
     * @param [nums]
     * @return java.util.List<java.lang.Integer>
     * @auther leichunhong
     * @desc 315. 计算右侧小于当前元素的个数
     * @date 2020-07-11 23:34
     */
    public static List<Integer> countSmaller(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        int b = nums.length;
        for (int i = 0; i < b; i++) {
            int dept = 0;
            for (int j = i + 1; j < b; j++) {
                if (nums[j] < nums[i]) {
                    dept++;

                }

            }
            ans.add(dept);
        }
        return ans;

    }

    
    /**
    * @auther  leichunhong
    * @desc 350. 两个数组的交集 II
     *          1.用 HashMap重点写不重复 value 值是1
     *          2.判断是否存在的条件是在map里面并且value>0 判断过的就不再二次判断啦
     *          3.开始写的时候用list存放发现重复的没处理 转用map写
     *
    * @date  2020-07-13 16:35  
    * @param
    * @return  int[]
    */
    public static int[] intersect(int[] nums1, int[] nums2) {


        HashMap<Integer, Integer> map = new HashMap();
        for (int nums : nums2) {
            if (map.containsKey(nums)) {
                map.put(nums, map.get(nums) + 1);
            } else {
                map.put(nums, 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i]) && map.get(nums1[i]) > 0) {
                ans.add(nums1[i]);
                map.put(nums1[i], map.get(nums1[i]) - 1);
            }

        }
        int[] ins1 = new int[ans.size()];
        for (int i = 0; i < ins1.length; i++) {
            ins1[i] = ans.get(i);
        }
        return ins1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2, 2};

        System.out.println(intersect(nums, num2));
    }
}
