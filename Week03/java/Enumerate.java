package Week03.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 78. 子集：给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 步骤：两个循环，一个循环给的数组，再循环返回的数组，，每次新增外层循环的值
 *      1.定义返回的List先添加一个空的[[]]这种
 *      2.外循环给定的数组，内层循环返回的List [[]]
 *      3.每次循环的时候取[[]]里面的值把外层当前的nums[i]加进去
 *      4.搞定
 *
 * @author leichunhong
 * @create 2020-06-25
 * @since 1.0.0
 */
public class Enumerate {
    public static List<List<Integer>> enumerate(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        //循环整合数组
        for (Integer n : nums) {
            //转int
            int size = res.size();

            //循环每次返回的值就是添加的值
            for (int i = 0; i < size; i++) {
                //每拿出来一个 把当前元素新增进去
                List<Integer> newAns = new ArrayList<Integer>(res.get(i));
                newAns.add(n);
                //再加到最终list里面
                res.add(newAns);
            }
        }
        return res;
    }


    public static List<List<Integer>> enumerate1(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;


    }


}
