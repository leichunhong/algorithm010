package Week04.java;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉 515. 在每个树行中找最大值
 * 步骤:自己思路 每层的最大值不就是bfs吗，一层层往下找，套个广度优先的模板试试
 * 1.自己写卡了一下 while循环下的取q.poll()这个需要在队列的循环里面写，开始写再外面了。
 * 2.这个错误很低级，队列不为null下一步肯定是循环队列取数据
 * 3.我写了个天大的bug for循环的直接动态获取的队列的长度导致出错！我去！！！！！！！
 *
 * @author leichunhong
 * @create 2020-07-02
 * @since 1.0.0
 */
public class LargestValues {

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
     * @return java.util.List<java.lang.Integer>
     * @auther leichunhong
     * @desc 这个手残的写法把我整了好一会儿！一定记住动态不能实时获取队列长度
     * @date 2020-07-02 16:13
     */
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        //定义队列
        Queue<TreeNode> queue = new LinkedList<>();
        //添加第一个节点
        queue.offer(root);
        //循环队列
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;

            //一定要在循环之前先获取队列的长度！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
            int sz = queue.size();
            //动态扩充队列的长度所以绝对不能for循环获取，需要先获取再循环，因为循环会动态扩大队列的大小！
            for (int i = 0; i < sz; i++) {
                //for(int i=0;i<queue.size();i++){
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);//记录每层的最大值
                if (cur.left != null) {
                    //放下一层左节点
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    //放下一层左节点
                    queue.offer(cur.right);
                }
            }
            ans.add(max);
        }
        return ans;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        root.left = left;
        System.out.println(largestValues(root));
    }



}
