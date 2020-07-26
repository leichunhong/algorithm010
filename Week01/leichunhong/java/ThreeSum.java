package Week01.leichunhong.java;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 三数之和
 * 步骤：1.定义返回数组List<List<Integer>>
 * 2.判断list为空和list.sise<3退出
 * 3.Array.sort(nums)
 * 4.双层循环 外层循环1=0 到length-1
 * 5.判断i>0 break;
 * 6.i>0判断重复i和i-1重复continue
 * 7.定义左index l和右index r
 * 8.循环l到r往中间找 while(l<r)
 * 9.真正算sum=nums[i]+nums[l]+nums[r]
 * 10.if(sum==0)
 * 11.返回数组ans.add(Array.aslist(nums[i]+nums[l]+nums[r]))
 * 12.l和r靠近中去重while(l<r&&nums[l]==nums[l+1]) l++
 * 13.l和r靠近中去重while(l<r&&nums[r]==nums[r-1]) r--
 * 14.l++;r--;
 * 15.else(sum<0) l++
 * 16.else(sum>0) r--
 * 17.return ans数组
 *
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
     * @param
     * @return void
     * @auther leichunhong
     * @desc 三数之和第二遍  默写有点困难  还要加油！！
     * @date 2020-06-13 20:54
     */

    public static List<List<Integer>> threeSum2(int[] nums) {
        //1.创建返回对象
        List<List<Integer>> array = new ArrayList<>();
        int len = nums.length;

        //2.小与3返回
        if (nums == null && len < 3) {
            return array;
        }


        //排序
        Arrays.sort(nums);
        //循环 循环nums[i]
        for (int i = 0; i < len; i++) {
            //大于0跳出去
            if (nums[i] > 0) {
                break;
            }
            //去重下一个循环
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //定义左右 起点
            int l = i + 1;
            int r = len - 1;
            //只要小与都循环
            while (l < r) {
                //算和
                int sum = nums[i] + nums[l] + nums[r];
                //==0
                if (sum == 0) {
                    array.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;

                } else if (sum > 0) {
                    r--;
                }

            }

        }
        return array;


    }


    /**
     * 〈功能简述〉<br>
     * 〈〉
     * 三数之和
     * 步骤：1.定义返回数组List<List<Integer>>
     * 2.判断list为空和list.sise<3退出
     * 3.Array.sort(nums)
     * 4.双层循环 外层循环1=0 到length-1
     * 5.判断i>0 break;
     * 6.i>0判断重复i和i-1重复continue
     * 7.定义左index l和右index r
     * 8.循环l到r往中间找 while(l<r)
     * 9.真正算sum=nums[i]+nums[l]+nums[r]
     * 10.if(sum==0)
     * 11.返回数组ans.add(Array.aslist(nums[i]+nums[l]+nums[r]))
     * 12.l和r靠近中去重while(l<r&&nums[l]==nums[l+1]) l++
     * 13.l和r靠近中去重while(l<r&&nums[r]==nums[r-1]) r--
     * 14.l++;r--;
     * 15.else(sum<0) l++
     * 16.else(sum>0) r--
     * 17.return ans数组
     *
     * @author leichunhong
     * @create 2020-06-12
     * @since 1.0.0
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i + 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l++]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r--]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }

            }

        }
        return ans;
    }







    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        //先排序
        Arrays.sort(nums);
        //只循环到nums.length - 3
        for (int i = 0; i < nums.length - 2; i++) {
            // 去除指针i可能的重复情况
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                // 去除j可能重复的情况
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //左
                int left = j + 1;
                //右
                int right = nums.length - 1;
                //二分的例子一样 不是<=
                while (left < right) {
                    // 不满足条件或者重复的，继续遍历
                    //
                    if ((left != j + 1 && nums[left] == nums[left - 1]) || nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else if ((right != nums.length - 1 && nums[right] == nums[right + 1]) || nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);

                        result.add(list);
                        // 满足条件的，进入下一次遍历
                        left++;
                        right--;
                    }
                }

            }
        }

        return result;
    }


    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 去除指针i可能的重复情况
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                // 去除j可能重复的情况
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //左
                int left = j + 1;
                //右
                int right = nums.length - 1;
                //二分的例子一样 不是<=
                while (left < right) {
                    // 左边不满足条件或者重复的，继续遍历 或者小于target 时候left++
                    if ((left > j + 1 && nums[left] == nums[left - 1]) || nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                        // 右边不满足条件或者重复的，继续遍历 或者>target 时候right++
                    } else if ((right < nums.length - 1 && nums[right] == nums[right + 1]) || nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                        left++;
                        right--;
                    }
                }

            }
        }

        return ans;
    }


    public static int jump(int[] nums) {
        //跳的边界
        int end = 0;
        //从边界到能跳到几步的最大值
        int max = 0;
        //步数
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            //因为在i位置上跳的最远是nums[i] 所以i到i+nums[i]的位置的最大值max
            max = Math.max(max,  i+nums[i]);
            //起跳 表示上次能达到的做大位置必须换下一个最大位置
            if (i == end) {
                end = max;
                steps++;
            }
        }
        return steps;


    }


    public int jump2(int[] nums) {
        //上一次换绳子能到的最高位置,比赛开始时为0
        int MyHighestPosition = 0;
        //我们遇到的绳子中能爬的最高的那根的位置,当然是你喜欢的那一根
        int myLoveRopePosition = 0;
        //必须更换绳子的次数
        int mustChangeTime = 0;
        /*每一爬一米都有一次更换绳子的机会，所有绳子你都够得到，但是我们只在必须更换绳子的时候才去更换，因为我们在攀岩，每次更换都耗费大量体力*/
        for (int i = 0; i < nums.length - 1; i++) {
            //为了减少更换次数，每次遇到一个绳子我们从中选取一个能爬的最远的给它系一个红丝带，当然可以打个蝴蝶结，表示你爱它，当你需要更换的时候你就会选择它
            myLoveRopePosition = Math.max(myLoveRopePosition, nums[i] + i);
            //到这里你发现上次更换绳子后你只能爬到这里了，下面更换绳子
            if (i == MyHighestPosition) {
                /*选择最远的那条绳子，且记录下一次必须更换的位置*/
                MyHighestPosition = myLoveRopePosition;
                //更换次数加1
                mustChangeTime++;
            }
        }
        return mustChangeTime;
    }


    public static void main(String[] args) {
        int[] a = new int[]{3,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(jump(a));
    }

}
