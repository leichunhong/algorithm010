package Week03.java;

/**
 * 〈功能简述〉<br>
 * 〈〉50. Pow(x, n)
 *
 * @author leichunhong
 * @create 2020-06-25
 * @since 1.0.0
 */
public class MyPow {
    public double myPow(double x, int n) {

        if (n < 0) return 1 / x * myPow(1 / x, -(n + 1));
        if (n == 0) return 1;
        if (n == 2) return x * x;
        if (n % 2 == 0) return myPow(myPow(x, n / 2), 2);
        else return x * myPow(myPow(x, n / 2), 2);


    }
    /**
    * @auther  leichunhong
    * @desc  n<0  x=1/x *递归（1/x,-(n+1)）   n=-n  返回如果是偶数：递归（x*x,n/2） 奇数：（x*x,/n/2）*x
    * @date  2020-06-25 10:46
    * @param
    * @return  double
    */
    public double myPow2(double x, int n) {

        if(n == 0)
            return 1;
        if(n<0){
            return 1/x * myPow2(1/x, -(n + 1));
        }
        return (n%2 == 0) ? myPow2(x*x, n/2) : x*myPow2(x*x, n/2);
    }


}
