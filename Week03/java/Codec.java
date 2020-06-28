package Week03.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 〈功能简述〉<br>
 * 〈〉297. 二叉树的序列化与反序列化
 * 看不懂
 *
 * @author leichunhong
 * @create 2020-06-24
 * @since 1.0.0
 */
public class Codec {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    /**
     * @param
     * @return int   121. 买卖股票的最佳时机
     * @auther leichunhong
     * @desc
     * @date 2020-06-24 19:01
     */
    public int maxProfit(int prices[]) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;

            }
        }
        return max;


    }

    /**
     * @param [x]
     * @return int
     * @auther leichunhong
     * @desc 7. 整数反转 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * @date 2020-06-24 22:48
     */
    public static int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    /**
     * @param [x]
     * @return int
     * @auther leichunhong
     * @desc 思路：1.当x不等于0的实惠while    最后一位 tail=x%10;位数=result*10 +tail
     * 2.当(位数-tail)/10!=result 则移除
     * 3.让result=位数
     * 4.x=x/10
     * @date 2020-06-24 22:51
     */
    public static int reverse1(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;


        }
        return result;

    }

    /**
    * @auther  leichunhong
    * @desc 9. 回文数
    * @date  2020-06-24 23:09. 回文数5
    * @param  [x] 
    * @return  boolean
    */
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        String newStr = sb.reverse().toString();

        if (str.equals(newStr)) {
            return true;

        }
        return false;
    }

    /**
    * @auther  leichunhong
    * @desc x 每次对10 取模运算， 取出后半段数字进行翻转。
     *
     * 这里需要注意的一个点就是由于回文数的位数可奇可偶，所以当它的长度是偶数时，它对折过来应该是相等的；当它的长度是奇数时，那么它对折过来后，有一个的长度需要去掉一位数（除以 10 并取整）。
    * @param  [x] 
    * @return  boolean
    */
    public static boolean isPalindrome1(int x) {

        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }

    public  void get(int le){
        if(le>0){
            return;
        }
        //yewu
        //
        get(le+1);


    }





    public static void main(String[] args) {
        isPalindrome1(1221);
    }


}
