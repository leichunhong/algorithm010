package Week02.java;

import Week04.java.MinDepth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈功能简述〉<br>
 * 〈〉112. 路径总和
 *         给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * @author leichunhong
 * @create 2020-07-09
 * @since 1.0.0
 */
public class HasPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /**
    * @auther  leichunhong
    * @desc 注意审题：1.是到达叶子节点 必须到叶子节点，
     *               2.就是一层一层下去 开始的sum减去root再减去第一次的左节点再减去第二层的左节点
     *               3.右节点也一样，当每一层减去一个节点，到达叶子节点的时候刚好存在一直减下来的值减去这个叶子节点的value==叶子节点就是true
    * @date  2020-07-10 00:16
    * @param
    * @return  boolean
    */
    public static boolean hasPathSum(TreeNode root, int sum) {
        //null
        if (root == null) {
            return false;
        }
        //到达叶子节点
        if (root.left == null && root.right == null) {
            return sum == root.val;

        }
        //左右子树分别依次减该节点的value
        // 拿 左子树例子：
        //递归一层： 22-5=17
        //递归二层： 17-4=13
        //递归三层： 13-11=2
        //到达叶子节点2：sum=13-11=2   root.val=2 故 sum==root.val return true
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }


    public static boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        TreeNode left1= new TreeNode(4);
        TreeNode right1 = new TreeNode(5);

        right.left=left1;
        right.right=right1;
        root.right = right;
        root.left = left;
        System.out.println(hasPathSum(root, 4));
    }


}
