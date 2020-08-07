package Week09.java;


import java.util.LinkedList;
import java.util.Queue;

/**  100. 相同的树
 * 〈功能简述〉<br>
 * 〈〉状态极差
 *
 * @author leichunhong
 * @create 2020-08-07
 * @since 1.0.0
 */
public class IsSameTree {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;

        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }


    public boolean isSameTreeI(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode a = queue.poll();
            TreeNode b = queue.poll();
            if (a == null && b == null) {
                continue;
            }
            if (a == null || b == null) {
                return false;

            }
            if (p.val != q.val) {
                return false;
            } else {
                queue.offer(a.left);
                queue.offer(b.left);
                queue.offer(b.right);
                queue.offer(b.right);

            }
        }
        return true;
    }


}
