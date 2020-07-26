package Week07.java;

import java.util.HashSet;
import java.util.Set;

/**
 * 〈功能简述〉<br>
 * 〈〉127. 单词接龙 双向bs
 * TODO
 *
 * @author leichunhong
 * @create 2020-07-26
 * @since 1.0.0
 */
public class LadderLength {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }
        //开始
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);

        //结束
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        //转set O(1)
        Set<String> wordSet = new HashSet<>(wordList);

        int step = 1;
        //备忘录
        HashSet<String> visited = new HashSet<>();

        //start BFS
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            //交换 ？
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            //????? why
            Set<String> temp = new HashSet<>();
            //循环的beginSet
            for (String word : beginSet) {
                //单词字符
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {

                    for (char c = 'a'; c <= 'z'; c++) {
                        //换单词中的字符为c
                        char old = chs[i];
                        chs[i] = c;
                        //新单词
                        String newWord = String.valueOf(chs);

                        //是结尾单词
                        if (endSet.contains(newWord)) {
                            return step + 1;
                        }
                        //不是 不在备忘录，在wordList里面 add
                        if (!visited.contains(newWord) && wordSet.contains(newWord)) {
                            temp.add(newWord);
                            visited.add(newWord);
                        }
                        //还原
                        chs[i] = old;
                    }
                }
            }
            //????? why
            beginSet = temp;
            step++;
        }


        return 0;
    }
}
