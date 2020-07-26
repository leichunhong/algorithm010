package Week01.leichunhong.test;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *   小于n的全部质数
 * @author leichunhong
 * @create 2020-06-15
 * @since 1.0.0
 */
public class CountPrimes {
    public int countPrimes(int n) {

        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        //循环到i*i
        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                //如果是true i*i之后全搞成false
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }

        }
        //循环完看是true的个数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }

        }
        return count;


    }

    /**
     * @param
     * @return
     * @auther leichunhong
     * @desc 第二遍
     * @date 2020-06-15 13:25
     */
    public int countPrimes1(int n) {
        //数组放boolean类型默认全是true
        boolean[] isPa = new boolean[n];
        Arrays.fill(isPa, true);
        //第一遍循环从2开始到i*i<n
        //当发现数组中i的值是true是，从i*i到后面 每次加i都设置成false
        for (int i = 2; i * i < n; i++) {
            if (isPa[i]) {
                for (int j = i * i; j < n; j += i) {

                    isPa[j] = false;
                }


            }

        }
        //再循环一遍，把true的找出来统计
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPa[i]) {
                count++;
            }

        }
        return count;

    }


}
