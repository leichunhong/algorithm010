package Week03.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉 77. 组合 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
 *         步骤：1.自己写的时候没判断每个子数组放k个值，所以出来的子数组长度不是k
 *              2.典型的List套List子集的写法
 *              3.外层全局变量add自己List当满足条件时
 *              4.循环n每次子集List加i 然后下探一层递归i需要+1，k用过一次需要-1知道k==0说明子集里面k个数已经填满需要返回
 *              5.回朔的金典套路下探完需要清空这一层加的。  1.list.add(value) 2.递归  3.移除1步骤List上加的value
 *
 * @author leichunhong
 * @create 2020-06-27
 * @since 1.0.0
 */
public class Combine {
    /**
     * @param [n, k]
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @auther leichunhong
     * @desc 和老师讲的那个子集非常像
     * @date 2020-06-27 13:09
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    /**
    * @auther  leichunhong
    * @desc 每次放k个
    * @date  2020-06-29 22:29  
    * @param  [combs, comb, start, n, k] 
    * @return  void
    */
    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n;i++) {
            comb.add(i);
            combine(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }

    /**
    * @auther  leichunhong
    * @desc 全排列自己写思路：
    * @date  2020-06-29 22:30
    * @param  [n, k]
    * @return  java.util.List<java.util.List<java.lang.Integer>>
    */
    public static List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> list=new ArrayList<>();
        combin3(list,new ArrayList<Integer>(),1,n,k);
        return list;
    }

    private static void combin3(List<List<Integer>> list, ArrayList<Integer> integers, int start, int n, int k) {

        if(k==0){
            list.add(new ArrayList<Integer>(integers));
            return;

        }
        for(int i=start;i<=n;i++){
            integers.add(i);
            combin3(list,integers,1+i,n,k-1);
            //递归自己  举例先放1  在这下去 1，2 回来删掉2 放1 3 回来删掉3  放1 4 回来删掉4   1 循环完回来删掉1 加2 好难理解
            integers.remove(integers.size()-1);
        }
    }

    public static void main(String[] args) {
   combine1(4, 2); ;
    }


    /**
        * @auther  leichunhong
        * @desc 另一种解法
        * @date  2020-06-29 22:22
        * @param  [n, k]
        * @return  java.util.List<java.util.List<java.lang.Integer>>
        */
    public static List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        result = combine1(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine1(n - 1, k));
        return result;
    }
}
