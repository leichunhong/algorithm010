package Week06.java;

/**
 * 〈功能简述〉<br>
 * 〈〉 1143. 最长公共子序列
 *
 * @author leichunhong
 * @create 2020-07-14
 * @since 1.0.0
 */
public class LongestCommonSubsequence {
    /**
     * @param [text1, text2]
     * @return int
     * @auther leichunhong
     * @desc 听完课来自己写一遍
     * 先记住这个递推方程： 最后两位不相等：db[i][j]=max(db[i][j-1],db[i-1][j])
     *                   最后两位相等：  db[i][j]=db[i-1][j-1]+1
     *       自己不可能推导出来的！
     *       时间复杂度O(n^2)
     *       空间复杂度O(1)
     * @date 2020-07-14 23:51
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int db[][] = new int[m + 1][n + 1];
        //从1开始
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    db[i][j] = db[i - 1][j - 1] + 1;

                } else {
                    db[i][j] = Math.max(db[i][j - 1], db[i - 1][j]);
                }

            }

        }
        return db[m][n];
    }
}
