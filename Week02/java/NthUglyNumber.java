package Week02.java;

/**
 * 〈功能简述〉<br>
 * 〈〉丑数 II
 * 不好理解
 *
 * @author leichunhong
 * @create 2020-07-09
 * @since 1.0.0
 */
public class NthUglyNumber {

    public static int nthUglyNumber(int n) {
        //定义丑数数组
        int[] ugly = new int[n];
        //先定义初始值为1
        ugly[0] = 1;
        //定义 2 3 5 的index 初始值都是0
        int index2 = 0, index3 = 0, index5 = 0;
        //定义质因子
        int factor2 = 2, factor3 = 3, factor5 = 5;

        for (int i = 1; i < n; i++) {
            //找质因子中最小的
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min) {
                factor2 = 2 * ugly[++index2];

            }
            if (factor3 == min) {
                factor3 = 3 * ugly[++index3];

            }
            if (factor5 == min) {
                factor5 = 5 * ugly[++index5];
            }
        }
        return ugly[n - 1];
    }

    /**
     * @param [args]
     * @return void
     * @auther leichunhong
     * @desc 默写一遍 从1 开始循环 index先加 再乘以ans[index]*n
     * @date 2020-07-09 16:34
     */
    public static int nthUglyNumber1(int n) {
        int[] ans = new int[n];
        ans[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ans[i] = min;
            if (factor2 == min) {
                index2++;
                factor2 = 2 * ans[index2];


            }
            if (factor3 == min) {
                index3++;
                factor3 = 3 * ans[index3];


            }
            if (factor5 == min) {
                index5++;
                factor5 = 5 * ans[index5];
            }

        }
        return ans[n - 1];


    }

    public static void main(String[] args) {
        nthUglyNumber(10);
    }
}
