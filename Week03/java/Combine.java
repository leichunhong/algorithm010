package Week03.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉 77. 组合
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


    public List<List<Integer>> combine1(int n, int k) {
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
