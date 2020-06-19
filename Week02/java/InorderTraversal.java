package Week02.java;


import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈二叉树的中序遍历〉 先左 再add 再右 中序
 * 步骤：1.定义List<Integer>返回
 * 迭代：Node不为空的时候先左， 再list的add 再右
 *
 * @author leichunhong
 * @create 2020-06-16
 * @since 1.0.0
 */
public class InorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;

    }


    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);

            }

        }

    }
   /**
   * @auther  leichunhong
   * @desc 第二遍
   * @date  2020-06-17 15:59
   * @param
   * @return  java.util.List<java.lang.Integer>
   */
    public List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        addList(root, list);
        return list;
    }

    public void addList(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                addList(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                addList(root.right, list);
            }

        }

    }


}
