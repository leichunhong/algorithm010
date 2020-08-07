package Week09.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * @create 2020-08-04
 * @since 1.0.0
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] db = new int[n1 + 1][n2 + 1];
        //第一行
        for (int j = 1; j < n2; j++) {
            db[0][j] = db[0][j - 1] + 1;
        }

        for (int i = 1; i < n1; i++) {
            db[i][0] = db[i - 1][0] + 1;
        }
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (word1.charAt(i - 1) == word1.charAt(j - 1)) {
                    db[i][j] = db[i - 1][j - 1];
                } else {
                    db[i][j] = Math.min(Math.min(db[i - 1][j - 1], db[i][j - 1]), db[i - 1][j]) + 1;

                }
            }
        }
        return db[n1][n2];


    }
}



