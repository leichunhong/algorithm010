package Week08.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *   392. 判断子序列
 *   记住双指针发
 * @author leichunhong
 * @create 2020-07-27
 * @since 1.0.0
 */
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {

        if (s.length() == 0) return true;
        int indexS = 0;
        int indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) {
                    return true;
                }
            }
            indexT++;
        }
        return false;

    }

    public static void main(String[] args) {
        isSubsequence("", "");
    }


}
