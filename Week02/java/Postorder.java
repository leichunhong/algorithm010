package Week02.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉590. N叉树的后序遍历
 *
 * @author leichunhong
 * @create 2020-06-16
 * @since 1.0.0
 */
public class Postorder {

  public   class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    /**
    * @auther  leichunhong
    * @desc
    * @date  2020-06-16 20:44  
    * @param
    * @return  java.util.List<java.lang.Integer>
    */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);


        while (!stack.isEmpty()) {
            //返回栈顶的元素并弹出
            root = stack.pop();

            list.add(root.val);
            if (root.children != null && root.children.size() > 0) {
                for (Node child : root.children) {
                    stack.add(child);
                }
            }

        }
        Collections.reverse(list);
        return list;

    }


}
