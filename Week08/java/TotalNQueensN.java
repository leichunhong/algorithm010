package Week08.java;

/**
 * 〈功能简述〉<br>
 * 〈〉  & 与运算 有0为0 同时为1 则为1
 *      | 或运算 有1为1  同时为0 则为0
 *      ^ 异或运算 相同为0 不同为1
 *      ~ 取反 就说1遍0 ，0遍1
 *      << 左移n 数学理解*2的n次方
 *      >> 右移n 数学理解/2的n次方
 *
 *
 *
 * @author leichunhong
 * @create 2020-07-29
 * @since 1.0.0
 */
public class TotalNQueensN {

    private static int size;
    private static int count;

    public static int totalNQueens(int n) {
        count = 0;
        //1左移n位变成1后面n和0
        //1左移n为-1就会加个减少一位加个2^0+2^1....+2^n-1变成n个1
        //如果n==4初始化就说1 << n 10000
        //(1 << n) - 1  1111
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }

    /**
     * @param [row, ld, rd]
     * @return void
     * @auther leichunhong
     * @desc row:列  ld：横   rd：捺
     * @date 2020-07-29 11:51
     */
    private static void solve(int row, int ld, int rd) {
        //最后一行返回
        if (row == size) {
            count++;
            return;
        }
        //把所有横撇啦或在一起，再取反就是没有被占的格子?????
        int pos = size & (~(row | ld | rd));
        while (pos != 0) {
            System.out.println(Integer.toBinaryString(pos));
            System.out.println(Integer.toBinaryString(-pos));
            System.out.println(Integer.toBinaryString(pos & (-pos)));
            int p = pos & (-pos);
            System.out.println();

            pos -= p;
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    public static void main(String[] args) {

        totalNQueens(4);


    }
}
