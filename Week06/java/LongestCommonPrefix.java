package Week06.java;

import java.util.HashMap;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * @create 2020-07-19
 * @since 1.0.0
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;

    }

    public String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0)    return "";

        String pre = strs[0];
        int i=1;
        while(i<strs.length){
            while(strs[i].indexOf(pre)!=0){
                pre=pre.substring(0,pre.length()-1);
            }
          i++;


        }
        return pre;



    }

    }
