package Week04.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * @create 2020-07-08
 * @since 1.0.0
 */
public class DivingBoard {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] lengths = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            lengths[i] = shorter * (k - i) + longer * i;
        }
        return lengths;
    }

}
