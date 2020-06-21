package Week01.leichunhong.java;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 三数之和
 * 步骤：1.定义返回数组List<List<Integer>>
 *      2.判断list为空和list.sise<3退出
 *      3.Array.sort(nums)
 *      4.双层循环 外层循环1=0 到length-1
 *        5.判断i>0 break;
 *        6.i>0判断重复i和i-1重复continue
 *        7.定义左index l和右index r
 *        8.循环l到r往中间找 while(l<r)
 *        9.真正算sum=nums[i]+nums[l]+nums[r]
 *        10.if(sum==0)
 *          11.返回数组ans.add(Array.aslist(nums[i]+nums[l]+nums[r]))
 *          12.l和r靠近中去重while(l<r&&nums[l]==nums[l+1]) l++
 *          13.l和r靠近中去重while(l<r&&nums[r]==nums[r-1]) r--
 *          14.l++;r--;
 *        15.else(sum<0) l++
 *        16.else(sum>0) r--
 *      17.return ans数组
 * @author leichunhong
 * @create 2020-06-12
 * @since 1.0.0
 */
public class ThreeSum {
    /**
     * @param
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @auther leichunhong
     * @desc 先暴力一下
     * @date 2020-06-12 00:18
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return Collections.emptyList();

        }
        //排序
        Arrays.sort(nums);
        //set 主要是不放重复的数据
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(value);
                    }

                }

            }

        }
        return new ArrayList<>(result);

    }


    /**
     * @param
     * @return
     * @auther leichunhong
     * @desc
     * @date 2020-06-12 16:21
     */
    public static List<List<Integer>> threeSum1(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null && len < 3) {
            return ans;
        }
        Arrays.sort(nums); //排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break; //有点没想通为啥break不是  continue 忘记了因为是排序的 到了大于0就不用再找啦！擦！
            }
            //从小往大找 发现和前面一个数一样就循环下一个！
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //想想为啥不是从i和len开始！
            //因为第i个位置是第一个值先确定下来了，从i+1和len-1的位置开始往中间找 每找一个和这个不变的第i位置相加判断是否是0
            //一遍过去i++ 再一遍一直循环下去！
            int L = i + 1;
            int R = len - 1;
            //为啥不是<= 因为=就重合了
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    //值为0 放在数组中没毛病！
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //当第L的位置和第L+1的位置一样说明重复L++
                    //为啥不比较L和L-1  最开始的-1会和i重复？
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    //当第R的位置和R-1相等R--
                    //为啥不比较R和R+1  会越界？
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;

                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;
    }







        /**
        * @auther  leichunhong
        * @desc 三数之和第二遍  默写有点困难  还要加油！！
        * @date  2020-06-13 20:54
        * @param
        * @return  void
        */

        public static List<List<Integer>> threeSum2(int[] nums) {
            //1.创建返回对象
            List<List<Integer>> array=new ArrayList<>();
            int len=nums.length;

            //2.小与3返回
            if(nums==null&&len<3){
                return array;
            }


            //排序
            Arrays.sort(nums);
            //循环 循环nums[i]
            for(int i=0;i<len;i++){
                 //大于0跳出去
                if(nums[i]>0){
                    break;
                }
                //去重下一个循环
                if(i>0&&nums[i]==nums[i-1]){
                    continue;
                }
                //定义左右 起点
                int l=i+1;
                int r=len-1;
                //只要小与都循环
                while(l<r){
                    //算和
                    int sum=nums[i]+nums[l]+nums[r];
                    //==0
                    if(sum==0){
                        array.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while(l<r&&nums[l]==nums[l+1]){
                            l++;
                        }
                        while(l<r&&nums[r]==nums[r-1]){
                            r--;
                        }
                        l++;
                        r--;
                    }else if(sum<0){
                        l++;

                    }else if(sum>0){
                        r--;
                    }

                }

            }
            return array;


        }

    public static void main(String[] args) {
        int[]  a=new int[]{1,-3,3,0,5};
        System.out.println(threeSum1(a));
    }


    /**
     * 〈功能简述〉<br>
     * 〈〉
     * 三数之和
     * 步骤：1.定义返回数组List<List<Integer>>
     *      2.判断list为空和list.sise<3退出
     *      3.Array.sort(nums)
     *      4.双层循环 外层循环1=0 到length-1
     *        5.判断i>0 break;
     *        6.i>0判断重复i和i-1重复continue
     *        7.定义左index l和右index r
     *        8.循环l到r往中间找 while(l<r)
     *        9.真正算sum=nums[i]+nums[l]+nums[r]
     *        10.if(sum==0)
     *          11.返回数组ans.add(Array.aslist(nums[i]+nums[l]+nums[r]))
     *          12.l和r靠近中去重while(l<r&&nums[l]==nums[l+1]) l++
     *          13.l和r靠近中去重while(l<r&&nums[r]==nums[r-1]) r--
     *          14.l++;r--;
     *        15.else(sum<0) l++
     *        16.else(sum>0) r--
     *      17.return ans数组
     * @author leichunhong
     * @create 2020-06-12
     * @since 1.0.0
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        if(nums==null||nums.length<3){
            return ans;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                break;
            }
            if(i>0&&nums[i]==nums[i+1]){
                continue;
            }
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
               int sum=nums[i]+nums[l]+nums[r];
               if(sum==0){
                   ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                   while(l<r&&nums[l]==nums[l++]){
                       l++;
                   }
                   while(l<r&&nums[r]==nums[r--]){
                       r--;
                   }
                   l++;
                   r--;
               }else if(sum<0){
                   l++;
               }else if(sum>0){
                   r--;
               }

            }

        }
        return ans;
    }



    }
