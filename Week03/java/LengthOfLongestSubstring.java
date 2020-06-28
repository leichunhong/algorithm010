package Week03.java;

import java.util.HashMap;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *3. 无重复字符的最长子串
 * @author leichunhong
 * @create 2020-06-24
 * @since 1.0.0
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;
        int j=0;
        for (int i=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;

    }

    public static void main(String[] args) {
        int max=Math.max(2,3);
        System.out.println(max);
        System.out.println(lengthOfLongestSubstring("abcabcbb"));


    }

}
