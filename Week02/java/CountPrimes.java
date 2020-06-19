package Week02.java;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *   204. 计数质数：统计所有小于非负整数 n 的质数的数量。
 *   步骤：1.设置一个数组，数组的value全是true
 *        2.外循环2到i*i循环，因为大余i*i到n和2到i*i一样只是数字颠倒。
 *        3.内循环从i*i开始到n步长为i全部设置为false
 *        4.另一个循环 循环完2到n如果数组值是true时count++
 *
 *
 *        再理解下题意，除过1和本身那么2*i  3*i一直到 （n-1）*i都不是质数
 *        外循环 2到n i++
 *        判断是false 内存循环 2 到i*j<n j++ 设置为false
 *
 *
 * @author leichunhong
 * @create 2020-06-15
 * @since 1.0.0
 */
public class CountPrimes {
    public int countPrimes(int n) {
        //全部更新数组为true
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
    /**
    * @auther  leichunhong
    * @desc
    * @date  2020-06-17 14:18
    * @param  [n] 
    * @return  int
    */
    public static int countPrimes2(int n) {
        boolean[] notPrime=new boolean[n];
        int count=0;
        for(int i=2;i<n;i++){
            if(notPrime[i]==false){
                count++;
                for(int j=2;i*j<n;j++){
                    notPrime[i*j]=true;
                }
            }

        }
        return count;


    }

    public static void main(String[] args) {
        countPrimes2(100);
    }




    }
