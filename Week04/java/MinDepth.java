package Week04.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 111. 二叉树的最小深度
 *     1.广度优先策略
 *     2.用队列里面泛型是TreeNode 队列里面每次只存一层的二叉树的值。第一次进来放进队列。
 *     3.while循环队列当队列不为空的时候，队列元素出队列，循环出队列的值，依次放到List（这道题是深度++）
 *     4.因为是最小深度，当发现一层的的left和right是null就返回深度值
 *
 *
 * @author leichunhong
 * @create 2020-06-30
 * @since 1.0.0
 */
public class MinDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }


    public static int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //队列里面放树
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;


        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    q.offer(cur.left);

                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }

            }
            depth++;

        }
        return depth;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        root.left = left;
        minDepth1(root);


    }


}
