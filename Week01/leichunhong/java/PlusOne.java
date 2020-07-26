package Week01.leichunhong.java;

/**
 * 〈功能简述〉<br>
 * 〈〉66. 加一
 *
 * @author leichunhong
 * @create 2020-07-07
 * @since 1.0.0
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[length + 1];

        digits[0] = 1;
        return digits;


    }
}
