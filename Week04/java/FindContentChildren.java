package Week04.java;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉455. 分发饼干
 *     步骤：1.必须排序 两个数组都排序
 *          2.定义i为返回的值i=0,j=0为递增找符合的孩子
 *          3.while(i<胃口的长度&&j<孩子的长度)
 *             if(胃口的值[i]<=孩子的值s[j])
 *                 i++
 *             j++
 *          return i;
 *
 *
 * @author leichunhong
 * @create 2020-07-04
 * @since 1.0.0
 */
public class FindContentChildren {
    public static int findContentChildren(int[] g, int[] s) {


        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j=0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;


    }

    public static void main(String[] args) {
        int[] g = new int[]{1, 1, 2, 3};
        int[] s = new int[]{1, 1};
        System.out.println(findContentChildren(g, s));


    }





}




