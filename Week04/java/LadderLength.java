package Week04.java;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉127. 单词接龙
 *
 * @author leichunhong
 * @create 2020-07-05
 * @since 1.0.0
 */
public class LadderLength {
    /**
     * @param [beginWord, endWord, wordList]
     * @return int
     * @auther leichunhong
     * @desc 先写个广度优先的模板  这个题不是很好写
     *       步骤：1.大方向 bfs   先套模板   模板套到循环取队列中的单词 下面需要 再循环单词的每个char  然后再循环26个字母依次换掉
     *             单词的char 然后就是新的单词，再判断这个单词在不在字典中，再判断是不是最终单词是直接返回，再判断访问没访问过，没访问过直接放到访问集合和队列
     *            2.这次注释写在代码里面。
     *            双向的bfs下来研究
     *
     * @date 2020-07-05 15:14
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //转换单词放到set中 在 wordList中判断的话不是o(1)的时间复杂度 题目会超时
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        //bfs的模板队列  然后队列add第一个单词
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        //其实和队列一样 只不过是个set集合来开始放第一个单词证明已经访问过了
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        //定义步数 第一个单词就已经有第一步 故step=1
        int step = 1;
        //标准的bfs的while循环
        while (!queue.isEmpty()) {
            //写死循环完取队列的长度记下来 因为在这个循环中会往队列中放单词 队列长度会变 为了保证只循环这一层的队列先取出来大小
            int size = queue.size();
            //标准的bfs循环队列元素
            for (int i = 0; i < size; i++) {

                //以下是核心逻辑  和业务相关  取队列的单词

                String word = queue.poll();
                //字符串转字符数组 把单词转字符数组我们要操作字符
                char[] chars = word.toCharArray();
                //循环字符数组
                for (int j = 0; j < word.length(); j++) {
                    char charStr = chars[j];
                    //循环26个字符一次替换j的位置上的单词
                    for (char k = 'a'; k <= 'z'; k++) {
                        //排除自己字符
                        if (k == charStr) {
                            continue;
                        }
                        //替换循环的字符 已经替换完成 新的单词就出来了
                        chars[j] = k;
                        //新拼装的单词 新单词
                        String newWord = String.valueOf(chars);
                        //在字典中
                        if (wordSet.contains(newWord)) {
                            //新单词是结尾单词 步数+1
                            if (newWord.equals(endWord)) {
                                return step + 1;

                            }
                            //没有访问过
                            if (!visited.contains(newWord)) {
                                queue.offer(newWord);
                                visited.add(newWord);

                            }

                        }

                    }
                    //还到最初的字符
                    chars[j] = charStr;

                }


            }
            step++;
        }
        return 0;

    }
}
