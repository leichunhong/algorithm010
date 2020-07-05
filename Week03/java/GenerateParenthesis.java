package Week03.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉 22. 括号生成
 * 步骤：写模板套
 *     1.定义返回数组
 *     2.判断==0的时候返回0
 *     3.写函数（String S,int left,int right,n）
 *     4.当left==right==n 数组add
 *     5.当left<n 调用自己s+（  left+1
 *     6.当right<left 调用自己 s+） right+1
 *
 * @author leichunhong
 * @create 2020-06-23
 * @since 1.0.0
 */
public class GenerateParenthesis {
    static private ArrayList<String> ans;

    public static List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        int left = 0;
        int right = 0;
        dns("", left, right, n);
        return ans;
    }
   public static int i=0;
    private static  void dns(String s, int left, int right, int n) {

        if (left == n && right == n) {
            ans.add(s);
            return;
        }
        if (left < n) {
            dns(s+"(", left + 1, right, n);
        }
        if (right < left) {
            dns(s+")", left, right + 1, n);
        }


    }

    public static void main(String[] args) {
      generateParenthesis(10);
    }


}
