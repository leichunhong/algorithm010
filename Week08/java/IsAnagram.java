package Week08.java;

/**
 * 〈功能简述〉<br>
 * 〈〉242. 有效的字母异位词
 *
 * @author leichunhong
 * @create 2020-08-02
 * @since 1.0.0
 */
public class IsAnagram {

    /**
    * @auther  leichunhong
    * @desc
    * @date  2020-08-02 12:50
    * @param  [s, t] 
    * @return  boolean
    */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[] db = new int[256];

        for (int i = 0; i < s.length(); i++) {
            db[s.charAt(i)]++;
            db[t.charAt(i)]--;
        }
        for (int i : db) {
            if (i != 0) {
                return false;

            }
        }
        return true;

    }

}
