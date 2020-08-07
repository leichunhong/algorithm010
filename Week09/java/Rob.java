package Week09.java;

import java.util.HashMap;

/**
 * 〈功能简述〉<br>
 * 〈〉337. 打家劫舍 III
 * 记得复习下打家劫舍1
 *
 * @author leichunhong
 * @create 2020-08-05
 * @since 1.0.0
 */
public class Rob {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @param
     * @return int
     * @auther leichunhong
     * @desc 暴力方法
     * 思路：要么是跟节点+跟节点的孙子节点
     * 要么是跟节点的儿子节点
     * 算上面这两谁最大就取谁
     * @date 2020-08-05 09:57
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int money = root.val;
        if (root.left != null) {
            //左孙子节点
            money += rob(root.left.left) + rob(root.left.right);

        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);

        }
        return Math.max(money, rob(root.left) + rob(root.right));
    }

    /**
     * @param
     * @return
     * @auther leichunhong
     * @desc
     * @date 2020-08-05 10:03
     */

    public int robI(TreeNode root) {
        //可以是root value 是最大值的结果
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return robInternal(root, memo);
    }


    public int robInternal(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            //左孙子节点
            money += robInternal(root.left.left, memo) + robInternal(root.left.right, memo);
        }
        if (root.right != null) {
            money += robInternal(root.right.left, memo) + robInternal(root.right.right, memo);
        }
        int result = Math.max(money, robInternal(root.left, memo) + robInternal(root.right, memo));
        memo.put(root, result);
        return result;
    }




}
