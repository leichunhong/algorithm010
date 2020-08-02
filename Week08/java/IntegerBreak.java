package Week08.java;

/**
 * 〈功能简述〉<br>
 * 〈〉343. 整数拆分
 *            1*(n-1)
 *            2*(n-2)
 *            i*(n-i) 因为发现db[n-i]<n-i 不用继续分下去或者取max(b[n-i],n-i)i
 *
 *  dp[i]=(max(i-j,dp[i-j])j,db[i])
 *
 * @author leichunhong
 * @create 2020-07-30
 * @since 1.0.0
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] db = new int[n + 1];
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                db[i] = Math.max(db[i], j * Math.max(i - j, db[i - j]));

            }

        }
        return db[n];
    }

}
