package Week02.java;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉 N叉树的前序遍历
 *
 * @author leichunhong
 * @create 2020-06-17
 * @since 1.0.0
 */
public class Preorder {

    class Node {
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
    * @date  2020-06-18 16:16
    * @param
    * @return  java.util.List<java.lang.Integer>
    */

    public List<Integer> preorder(Node root) {

        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        stack.add(root);


        while (!stack.isEmpty()) {
            //返回栈顶的元素并弹出
            root = stack.pop();
            list.add(root.val);
            //后续遍历在这翻转一下孩子节点list
            Collections.reverse(root.children);
            for (Node item : root.children) {
                stack.add(item);
            }
        }

        return list;
    }
    /**
    * @auther  leichunhong
    * @desc
    * @date  2020-06-17 09:36
    * @param  [root]
    * @return  java.util.List<java.lang.Integer>
    */
    public List<Integer> preorder1(Node root) {
        Stack<Node> stack=new Stack<>();
        LinkedList<Integer> list=new LinkedList<>();
        if(root==null){
            return list;
        }
        //入栈
        stack.add(root);
        while(!stack.isEmpty()){
            //弹出站顶
            root=stack.pop();
            //list添加root节点
            list.add(root.val);
            //翻转子节点
            Collections.reverse(root.children);
            //循环入栈子节点
            for(Node node:root.children){
                stack.add(node);
            }

        }
        return list;


    }



}
