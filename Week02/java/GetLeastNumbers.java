package Week02.java;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 最小的k个数
 *
 * 步骤：1.暴力就是sort 取前k个
 *      2.用小顶堆实现 PriorityQueue实现全部放进去，取前k个poll
 *
 *
 * @author leichunhong
 * @create 2020-06-18
 * @since 1.0.0
 */
public class GetLeastNumbers {
    /**
     * @param
     * @return int[]
     * @auther leichunhong
     * @desc 自己的暴力就是排序 再 取前k个
     * @date 2020-06-18 10:16
     */
    public static int[] getLeastNumbers(int[] arr, int k) {

        int[] arrs = new int[k];

        if (arr.length < k) {
            return arrs;
        }
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            arrs[i] = arr[i];
        }
        return arrs;

    }


    //    保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
    // 1. 若目前堆的大小小于K，将当前数字放入堆中。
    // 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
    // 3. 反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            // 默认是小根堆，实现大根堆需要重写一下比较器。
            Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
            for (int num : arr) {
                if (pq.size() < k) {
                    pq.offer(num);
                } else if (num < pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            }

            // 返回堆中的元素
            int[] res = new int[pq.size()];
            int idx = 0;
            for (int num : pq) {
                res[idx++] = num;
            }
            return res;
        }
    }

    /**
     * @param [args]
     * @return void
     * @auther leichunhong
     * @desc 看老师的写法
     * @date 2020-06-21 12:56
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        //默认小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : arr) {
            heap.add(i);
        }

        int[] ans=new int[k];
        //意思是取前k个值
        for(int i=0;i<k;i++){
            ans[i]=heap.poll();

        }
        return ans;


    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1};
        getLeastNumbers(arr, 2);

    }


}
