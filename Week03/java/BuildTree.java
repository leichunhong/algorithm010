package Week03.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @author leichunhong
 * @create 2020-06-27
 * @since 1.0.0
 */
public class BuildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }


    /**
     * @param [preStart, inStart, inEnd, preorder, inorder]
     * @return Week03.java.BuildTree.TreeNode
     * @auther leichunhong
     * @desc preStart:前序遍历的起点
     * inStart:中序遍历的起点
     * inEnd：中序遍历的end
     * @date 2020-06-27 12:32
     */
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        //如果前序遍历的起始位置大于前序遍历的长度 或者中序遍历的开始大于结尾 return null

        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        //前序
        TreeNode root = new TreeNode(preorder[preStart]);
        //记录节点index
        int inIndex = 0; // Index of current root in inorder
        //遍历中序找到根节点的位置
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        //左
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        //右
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    public TreeNode helper1(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        //treeNode.val是跟节点
        TreeNode treeNode = new TreeNode(preorder[preStart]);

        int inIndex = 0;
        for (int i = inStart; i <=inEnd; i++) {
            if (inorder[i] == treeNode.val) {
                inIndex = i;
                break;
            }

        }
        //左 的inend是inIndex-1的位置
        treeNode.left=  helper1(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        //右 的instart 是inIndex-1 ，preStart是preStart+（inIndex-insstart+1)
        treeNode.right=  helper1(preStart + (inIndex - inStart + 1), inIndex + 1, inEnd, preorder, inorder);
        return treeNode;


    }


    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int perStart = 0;
        int inStart = 0;
        //没有前序的结尾
        return helper1(perStart, inStart, inorder.length - 1, preorder, inorder);
    }


}
