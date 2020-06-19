package Week02.java;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *  242. 有效的字母异位词
 *
 *  步骤：1.长度不相等返回false
 *       2.定义数组大小256（26字符.charAt)是255
 *       3.循环两个字符一个++ 一个--
 *       4.循环判断当！=0 返回false
 *       5.最后返回true
 *
 * @author leichunhong
 * @create 2020-06-15
 * @since 1.0.0
 */
public class IsAnagram {
    /**
     * @param [s, t]
     * @return boolean
     * @auther leichunhong
     * @desc 转成数组排序
     * @date 2020-06-15 21:09
     */
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }

    /**
     * @param
     * @return
     * @auther leichunhong
     * @desc 自己暴力写出来了个垃圾
     * @date 2020-06-15 21:09
     */
    public static boolean isAnagram1(String s, String t) {
        //理由hashmap 之前想 相同的字符内容加1  完了比较 hashmap怎么相等  老师让减去 最后判断是0
        if (s.length() != t.length()) {
            return false;

        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.get(ch) != null) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }


        }
        for (char ch1 : t.toCharArray()) {
            if (map.get(ch1) != null) {
                map.put(ch1, map.get(ch1) - 1);
            }

        }
        for (char ch2 : map.keySet()) {
            if (map.get(ch2) != 0) {
                return false;
            }

        }
        return true;

    }

    /**
     * @param [s, t]
     * @return boolean
     * @auther leichunhong
     * @desc 优化！
     * @date 2020-06-15 21:27
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;

        }
        int[] counter = new int[256];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)]++;
            counter[t.charAt(i)]--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }

        }
        return true;


    }


    public static void main(String[] args) {
        System.out.println(isAnagram1("anagram", "nagaram"));
    }


}
