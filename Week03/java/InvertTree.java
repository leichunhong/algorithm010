package Week03.java;

/**
 * 〈功能简述〉<br>
 * 〈〉 226. 翻转二叉树
 *
 * @author leichunhong
 * @create 2020-06-23
 * @since 1.0.0
 */
public class InvertTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @param [root]
     * @return Week03.java.InvertTree.TreeNode
     * @auther leichunhong
     * @desc
     * @date 2020-06-23 21:06
     */
    public TreeNode invertTree(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if (root == null) {
            return null;
        }


        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        //递归交换当前节点的 左子树
        invertTree(root.left);
        //递归交换当前节点的 右子树
        invertTree(root.right);
        //函数返回时就表示当前这个节点，以及它的左右子树
        //都已经交换完了
        return root;
    }
    /**
    * @auther  leichunhong
    * @desc 步骤：1.左右子树交换
     *           2.递归左子树
     *           3.递归右子树
    * @date  2020-06-23 21:21
    * @param
    * @return  Week03.java.InvertTree.TreeNode
    */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;

        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;

    }

}


