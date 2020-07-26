package Week04.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *   最大公约数
 * @author leichunhong
 * @create 2020-07-13
 * @since 1.0.0
 */
public class Gcd {
    public static int gcd(int a, int b) {
        if (a == b) {
            return a;

        }
        //ab都是偶数
        if ((a & 1) == 0 && (b & 1) == 0) {
            return gcd(a >> 1, b >> 1) << 1;
            //a是偶数 b是奇数
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return gcd(a >> 1, b);
            //a是奇数 b是偶数
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return gcd(a , b>>1);
        }else{
            int big=a>b?a:b;
            int small=a<b?a:b;
            return gcd(big-small , small);

        }

    }

    public static void main(String[] args) {
        System.out.println(gcd(25, 5));
    }
}
