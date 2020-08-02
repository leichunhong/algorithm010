package Week08.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * 意思就是n和n-1 & 运算 每次运算最低位一定是0 因为n和n-1的最低位一定不相同不都是1 所有n&（n-1）结果为0
 * 那么一直这样转转到最后 是0的时候做n&（n-1）测次数 就是多少个1
 * 1&1=1 其他都是0
 * @create 2020-07-27
 * @since 1.0.0
 */
public class HammingWeight {
    /**
     * @param [n]
     * @return int
     * @auther leichunhong
     * @desc
     * @date 2020-07-27 13:02
     */
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1);
        }
        return sum;

    }

    /**
    * @auther  leichunhong
    * @desc 每一位每一位的判断
    * @date  2020-07-27 13:06  
    * @param  [n] 
    * @return  int
    */
    public int hammingWeightI(int n) {
        int sum = 0;
        int mark = 1;

        for (int i = 0; i < 32; i++) {
            //说明n是1  1&1=1
            if ((n & mark)!=0) {
                sum++;
            }
            //1的位数想左移 数字变大
            mark = mark<<1;
        }
        return sum;

    }

}
