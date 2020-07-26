package Week04.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *  102. 二叉树的层序遍历
 *  自己写了一遍 有点问题
 *  步骤：
 *  1.广度优先就是一层一层的来，怎么保证每层不受干扰，就是先把第一层放到队列里面，
 *  2.这一次不是空的时候，循环这一次从队列中依次取出来，比如第一层是3  把3出队列 那第一次循环是3 把3放到list，然后把左9和右20都加到队列
 *  3.循环第二次 队列中只有第二次加的 就是两个数 9和20 依次往下 直到为节点为null
 *  4.以前有点懵这不就是开发中模块下对菜单，菜单下再分菜单，只不过开发中是id和pid关联的。每一层菜单放到队列里使用，使用完出队列。在把下次的放进去
 *   下次的就是left和right 这就是所谓的广度优先 一层一层来
 *
 * @author leichunhong
 * @create 2020-06-30
 * @since 1.0.0
 */
public class LevelOrder {

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static  List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        //判断
        if (root == null) {
            return ans;

        }
        //选择节点
        //广度优先用队列
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);


        while (!q.isEmpty()) {
            //循环 取队列的数组 然后加到队列里面
            int sz = q.size();
            //循环的是每一层的数据 循环左的加左节点，再i++循环右节点
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode tr = q.poll();
                if (tr == null) {
                    continue;
                }
                list.add(tr.val);
                if(tr.left!=null){
                    q.offer(tr.left);
                }
                if(tr.right!=null){
                    q.offer(tr.right);
                }

            }
            if (list != null && list.size() > 0) {
                ans.add(list);
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode left=new TreeNode(9);
        TreeNode right=new TreeNode(20);
        root.right=right;
        root.left=left;
        levelOrder(root);


    }


}
