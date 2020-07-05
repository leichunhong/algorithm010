package Week04.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 〈功能简述〉<br>
 * 〈〉 深度优先模板 递归版
 *
 * @author leichunhong
 * @create 2020-06-29
 * @since 1.0.0
 */
public class DFS {


    public class Node {
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
     * @desc 深度优先  树做的
     * @date  2020-06-30 08:40
     * @param
     * @return  void
     */
    void dfs(Node node, Set<Node> visited) {

        //已经存在
        if (visited.contains(node)) {
            return ;

        }
        //添加节点
        visited.add(node);
        //循环添加子节点
        for (Node child : node.children) {
            if(!visited.contains(child)){
                dfs(child,visited);
            }
            
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /**
    * @auther  leichunhong
    * @desc 树的回溯
    * @date  2020-06-29 09:33  
    * @param
    * @return  void
    */
    public static void DFS1(TreeNode head){
        if (head==null)return;
        //check();//满足条件的check();
        if (head.left!=null){
            DFS1(head.left);
        }if (head.right!=null){
            DFS1(head.right);
        }
    }

    /**
    * @auther  leichunhong
    * @desc 广度优先 队列做的
    * @date  2020-06-29 09:34  
    * @param
    * @return  void
    */
    public static void BFS(TreeNode head) {
        if (head == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        //off== add
        //队列删除元素poll
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode m = queue.poll();
            //System.out.print(m.val+" ");
            //dosomething();
            if (m.left != null) {
                queue.offer(m.left);
            }
            if (m.right != null) {
                queue.offer(m.right);
            }
            queue.poll();
        }
    }


}
