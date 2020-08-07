package Week09.java;
import java.util.HashMap;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *387. 字符串中的第一个唯一字符
 * @author leichunhong
 * @create 2020-08-05
 * @since 1.0.0
 */
public class FirstUniqChar {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 0);
            }

        }
        for (int i = 0; i < s.length(); i++) {

            if (map.get(s.charAt(i)) == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
        ;

    }

    public static int firstUniqCharI(String s) {

        int[] db = new int[256];
        char[] array = s.toCharArray();
        for (char c : array) {
            db[c]++;
        }

        for (int i = 0; i < s.length(); i++) {

            if (db[s.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }

}
