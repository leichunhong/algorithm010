package Week02.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉  144. 二叉树的前序遍历
 *       我理解的就是颠倒个顺序:先add再左再右
 *
 *
 * @author leichunhong
 * @create 2020-06-16
 * @since 1.0.0
 */
public class PreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;

    }
    public void helper(TreeNode root,List<Integer> res){
        if(root!=null){
            res.add(root.val);
            if(root.left!=null){
                helper(root.left,res);
            }
            if(root.right!=null){
                helper(root.right,res);

            }

        }

    }





}
