package Week06.java;

/**
 * 〈功能简述〉<br>
 * 〈〉96. 不同的二叉搜索树
 * 注意是二叉搜索树 左节点小于根节点，右节点大于跟节点，每个节点都是
 * 我自己分析出的是：比i小的数是左节点，比i大的是右节点
 * 没有想到数量是f(1)+f(2)+...f(n)的递归  f(i)=G(i−1)∗G(n−i) 这个是为啥
 *
 * @author leichunhong
 * @create 2020-07-15
 * @since 1.0.0
 */
public class NumTrees {

    public int numTrees(int n) {
        int[] db = new int[n + 1];
        db[0] = 1;
        db[1] = 1;
        //循环整个数组
        for (int i = 2; i <= n; i++) {
            //循环前i个值
            for (int j = 1; j <= i; j++) {
                //db[j - 1] 前一位
                //db[i - j] 最后一位减当前位
                db[i] += db[j - 1] * db[i - j];
            }

        }
        return db[n];

    }

}
