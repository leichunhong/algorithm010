package Week06.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 647. 回文子串
 * 这个题需要掌握db的方法
 *
 * @author leichunhong
 * @create 2020-07-17
 * @since 1.0.0
 */
public class CountSubstrings {

    /**
     * @param 
     * @return int
     * @auther leichunhong
     * @desc 步骤:1.中心扩展法，循环整个字符串，从i开始 i--的值和i++的值比较，相等就count++
     *           2.因为有偶数和奇数 start开始是i end分别是i和i+1
     *           时间复杂度O(n^2)  两个循环嵌套
     *           空间复杂度O(1)
     * @date 2020-07-17 16:04
     */
    public static int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            //以当前点i位置，向两边扩展,以i i+1位置向两边扩展
            //偶数
            result += countLoop(s, i, i);
            //奇数跳过一个比较
            result += countLoop(s, i, i + 1);

        }
        return result;


    }

    private static int countLoop(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            count++;

        }
        return count;
    }

    /**
     * @auther leichunhong
     * @desc 更好理解的代码
     * @date 2020-07-17 16:11
     * @param
     * @return
     */
    int count = 0;

    public int countSubstrings1(String s) {
        for (int i = 0; i < s.length(); i++) {
            //以当前点i位置，向两边扩展,以i i+1位置向两边扩展
            //偶数
            countLoop1(s, i, i);
            //奇数跳过一个比较
            countLoop1(s, i, i + 1);
        }
        return count;
    }

    private void countLoop1(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            count++;
        }
    }

    /**
    * @auther  leichunhong
    * @desc   不理解，需要接下来理解的
    * @date  2020-07-19 17:03
    * @param  [s]
    * @return  int
    */
    //TODO 不理解，需要接下来理解的
    public int countSubstrings3(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    ++res;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

        System.out.println(countSubstrings("abc"));
    }

}
