package Week03.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *    98. 验证二叉搜索树
 * @author leichunhong
 * @create 2020-06-23
 * @since 1.0.0
 */
public class ValidBST {
    /**
     * @param [root]
     * @auther leichunhong
     * @desc 中序遍历
     * @date 2020-06-23 21:25
     * @return boolean
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /**
    * @auther  leichunhong
    * @desc 自己的暴力写法
    * @date  2020-06-23 21:39
    * @param  [root]
    * @return  boolean
    */
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        vbs(root, ans);

        for (int i = 0; i < ans.size()-1; i++) {
            if (ans.get(i) >= ans.get(i + 1)) {
                return false;
            }

        }
        return true;


    }

    private void vbs(TreeNode root, ArrayList<Integer> ans) {
        if (root != null) {
            if (root.left != null) {
                vbs(root.left, ans);

            }
            ans.add(root.val);
            if (root.right != null) {
                vbs(root.right, ans);

            }

        }

    }


    long pre = Long.MIN_VALUE;
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

    public static int removeDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        int j=0;
        for(int i=0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            map.put(nums[i],nums[i]);

            nums[j]=nums[i];
            j++;
        }
       return j;
    }




}
