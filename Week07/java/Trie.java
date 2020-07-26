package Week07.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * @create 2020-07-20
 * @since 1.0.0
 */
public class Trie {

    class TrieNode {
        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }

        TrieNode(char c) {
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }

    public class trie {

        private TrieNode root;

        public trie() {
            root = new TrieNode();
            root.val = ' ';
        }


        /**
         * @param []
         * @return void
         * @auther leichunhong
         * @desc 插入
         * @date 2020-07-20 22:01
         */
        public void insert(String word) {

            TrieNode ws = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) {
                    ws.children[c - 'a'] = new TrieNode(c);

                }
                ws = ws.children[c - 'a'];

            }
            ws.isWord = true;

        }

        /**
         * @param
         * @return
         * @auther leichunhong
         * @desc 查询
         * @date 2020-07-20 22:06
         */
        public boolean search(String word) {
            TrieNode ws = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) {
                    return false;

                }
                ws = ws.children[c - 'a'];


            }
            return ws.isWord;

        }

        public boolean startWith(String prefix) {

            TrieNode ws = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (ws.children[c - 'a'] == null) {
                    return false;

                }
                ws = ws.children[c - 'a'];


            }
            return true;


        }


    }


}
