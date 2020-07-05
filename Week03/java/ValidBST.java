package Week03.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 98. 验证二叉搜索树
 *
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

    static ArrayList<Integer> ans1 = new ArrayList<>();


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @param
     * @return boolean
     * @auther leichunhong
     * @desc 自己的暴力写法
     * @date 2020-06-23 21:39
     */
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        vbs(root, ans);

        for (int i = 0; i < ans.size() - 1; i++) {
            if (ans.get(i) >= ans.get(i + 1)) {
                return false;
            }

        }
        return true;


    }

    private static void vbs(TreeNode root, ArrayList<Integer> ans) {
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


    private static void vbs1(TreeNode root) {
        if (root != null) {
            ans1.add(root.val);
            if (root.left != null) {
                vbs1(root.left);

            }
            System.out.println("前序：" + ans1.toString());
            if (root.right != null) {
                vbs1(root.right);

            }

        }


    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);


        TreeNode left1 = new TreeNode(6);
        TreeNode right2 = new TreeNode(7);


        TreeNode left3 = new TreeNode(4);
        TreeNode right4 = new TreeNode(5);


        TreeNode left5 = new TreeNode(8);
        TreeNode right6 = new TreeNode(9);


        TreeNode left7 = new TreeNode(11);
        TreeNode right8 = new TreeNode(10);


        root.right = right;
        root.left = left;
        right.left = left1;
        right.right = right2;
        left.left = left3;
        left.right = right4;

        left3.left = left5;

        left3.right = right6;


        right2.left = left7;
        right2.right = right8;


        vbs1(root);


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
        Map<Integer, Integer> map = new HashMap();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            map.put(nums[i], nums[i]);

            nums[j] = nums[i];
            j++;
        }
        return j;
    }


}
