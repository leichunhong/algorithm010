package Week03.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 104. 二叉树的最大深度
 * 步骤：我知道找左子树和右子树，哪个最大就是哪个 但是我不会这样写呀
 * 二叉树为空时 是0  二叉树深度为：Math.max(递归(left.root),递归(rifht.root))+1
 *
 * @author leichunhong
 * @create 2020-06-24
 * @since 1.0.0
 */
public class MaxDepth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }

    }

    /**
     * @param
     * @return int
     * @auther leichunhong
     * @desc 五体投地
     * @date 2020-06-24 17:29
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
    * @auther  leichunhong
    * @desc  最小是：如果左节点为null是右节点到跟的深度
     *              如果右节点为null是左节点到跟的深度
    * @date  2020-06-24 17:43
    * @param  [root]
    * @return  int
    */
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



    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //队列里面放树
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int depth=1;
        while(!q.isEmpty()){
            int sz=q.size();

            for(int i=0;i<sz;i++){
                TreeNode cur=q.poll();
                if(cur.left==null&&cur.right==null){
                    return depth;
                }
                if(cur.left!=null){
                    q.offer(cur.left);

                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }

            }
            depth++;

        }
        return depth;

    }






    }
