package Week07.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 〈功能简述〉<br>
 * 〈〉 102. 二叉树的层序遍历
 *
 * @author leichunhong
 * @create 2020-07-23
 * @since 1.0.0
 */
public class LevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    List<List<Integer>> ans = new ArrayList<>();
    /**
    * @auther  leichunhong
    * @desc 复习一遍二叉树层次遍历
    * @date  2020-07-23 18:16
    * @param
    * @return  java.util.List<java.util.List<java.lang.Integer>>
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return ans;

        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = q.poll();
                if (treeNode == null) {
                    continue;
                }
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    q.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    q.offer(treeNode.right);
                }

            }
            if (list != null && list.size() > 0) {
                ans.add(list);

            }

        }
        return ans;



    }
}
