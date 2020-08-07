package Week09.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉 不能这样写
 *
 * @author leichunhong
 * @create 2020-08-06
 * @since 1.0.0
 */
public class PalindromePairs {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        if (words.length == 0) {
            return ans;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j){
                    continue;
                }
                StringBuilder res = new StringBuilder();
                res.append(words[i] + words[j]);

                if (res.toString().equals(res.reverse().toString())) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }

            }

        }
        return ans;

    }
}
