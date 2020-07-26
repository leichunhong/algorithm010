package Week03.java;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 上台阶问题 ：
 * 步骤：递归三个数换  ==1 return 1  fi=1 se=2 for(3;length)  thir=fi+se; fi=se;se=thir  return se;
 *
 * @author leichunhong
 * @create 2020-06-11
 * @since 1.0.0
 */
public class WalkStep {
    /**
     * @param
     * @return
     * @auther leichunhong
     * @desc 动态规划：分解为一些包含最优子结构的子问题，即他的最优解可以从其子问题最优解来构造，可以使动态规则解决
     * @date 2020-06-11 20:21
     */

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;

        }
        int[] db = new int[n + 1];
        //第一步
        db[1] = 1;
        //第二步
        db[2] = 2;
        //三步以上是前两步之和
        for (int i = 3; i <= n; i++) {
            db[i] = db[i - 1] + db[i - 2];

        }
        return db[n];

    }


    /**
     * @param
     * @return
     * @auther leichunhong
     * @desc 斐波拉契数  for 循环 的替换很巧妙
     * @date 2020-06-11 20:29
     */
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;


    }


    /**
     * @param
     * @return
     * @auther leichunhong
     * @desc 走台阶第二遍
     * @date 2020-06-13 20:51
     */
    public int climbStairs2(int n) {
        //1 返回1
        if (n == 1) {
            return 1;

        }
        //定义第一步
        int first = 1;
        //定义第二部
        int second = 2;
        //三步以上每步替换
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;

        }
        return second;

    }

    /**
     * @param [n]
     * @return int
     * @auther leichunhong
     * @desc
     * @date 2020-06-23 13:45
     */
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i < n; i++) {
            int third = first + second;
            first = second;
            second = third;

        }
        return second;

    }

    /**
     * @param
     * @return
     * @auther leichunhong
     * @desc 写傻递归
     * @date 2020-06-23 13:46
     */
    public int climbStairs4(int n) {
        int[] ans = new int[n + 1];
        if (n == 1) {
            return 1;

        }
        //第一步
        ans[1] = 1;
        //第二步
        ans[2] = 2;
        for (int i = 3; i < n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];

        }
        return ans[n];
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        /*int[] newnums = new int[nums1.length+nums2.length];

        int j=0;
        if(nums1!=null&&nums1.length>0){
            for (int i=0;i<nums1.length;i++) {
                newnums[j]=nums1[i];
                j++;
            }
        }


      if(nums2!=null&&nums2.length>0){
          for (int i=0;i<nums2.length;i++) {
              newnums[j]=nums2[i];
              j++;
          }
      }*/


        int[] newnums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, newnums, 0, nums1.length);
        System.arraycopy(nums2, 0, newnums, nums1.length, nums2.length);

        Arrays.sort(newnums);
        if (newnums.length % 2 == 0) {
            int start = newnums.length / 2 - 1;
            int end = newnums.length / 2;
            return (newnums[start] + newnums[end]) / 2.0;

        } else {
            int start = newnums.length / 2;
            return (newnums[start]);
        }


    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome1("ac"));
    }


    public static String longestPalindrome(String s) {
        int maxNew = 0;
        int lo=0;
        int ln=0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String max = s.substring(i, j);
                String maxr = new StringBuilder(max).reverse().toString();
                if (maxr.equals(max)) {
                    if(maxr.length()>maxNew){
                        lo=i;
                        ln=j;
                        maxNew=maxr.length();

                    }
                }

            }
        }
        return s.substring(lo,ln);




    }

    private static int lo, maxLen;
    /**
    * @auther  leichunhong
    * @desc  5. 最长回文子串
    * @date  2020-06-29 09:22
    * @param  [s] 
    * @return  java.lang.String
    */
    public static String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for(int i=0;i<s.length()-1;i++){

            extendPalindrome1(s,i,i);
            extendPalindrome1(s,i,i+1);

        }
        return s.substring(lo,lo+maxLen);


    }

    private static void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    private static void extendPalindrome1(String s, int j, int k) {
        while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
            j--;
            k++;
        }
        if(maxLen<k-j-1){
            lo=j+1;
            maxLen=k-j-1;
        }


    }




    }


