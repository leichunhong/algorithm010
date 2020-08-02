package Week08.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * @create 2020-07-27
 * @since 1.0.0
 */
public class ReverseBits {
    public static int reverseBits(int n) {


        if (n == 0) return 0;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) {
                result++;
            }
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
        ;

    }
    /**
    * @auther  leichunhong
    * @desc 相当于 ans=ans*10+n%2
     *            n=n/2
    * @date  2020-07-28 00:39  
    * @param  [n] 
    * @return  int
    */
    public static int reverseBitsI(int n) {


        if (n == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result=(result<<1)|(n&1);
            n=n>>1;

        }
        return result;
    }


}
