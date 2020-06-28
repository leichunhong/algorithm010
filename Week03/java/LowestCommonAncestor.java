package Week03.java;

/**
 * 〈功能简述〉<br>
 * 〈〉236. 二叉树的最近公共祖先
 *
 * @author leichunhong
 * @create 2020-06-26
 * @since 1.0.0
 */
public class LowestCommonAncestor {

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  } 
     /**
     * @auther  leichunhong
     * @desc 这玩意我的背下来 我递归做不到归去来兮  下去就回不来了 不知道回到哪一层！
     * @date  2020-06-26 16:13  
     * @param  [root, p, q] 
     * @return  Week03.java.LowestCommonAncestor.TreeNode
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          //判断root和p和q有一个为空返回root
        //这就是终止条件
        if(root==null||root==p||root==q){
            return root;
        }
        //就是做业务
        //左递归
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        //右递归
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left==null){
            return right;
        }
        if(right==null){
            return left;

        }
        return root;


    }




    }
