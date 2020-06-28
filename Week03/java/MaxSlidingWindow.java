package Week03.java;

import java.util.LinkedList;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * 239. 滑动窗口最大值
 *
 * 步骤：这个两个滑块的我没看懂题解
 *
 * @author leichunhong
 * @create 2020-06-22
 * @since 1.0.0
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;

        }

        //左滑块
        int[] left = new int[n];
        left[0] = nums[0];
        //右滑块
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 0; i < n; i++) {
            //from left to rignt
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i] - 1, nums[i]);
            }
            //from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) {
                right[i] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }

        }
        int[] outPut = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            outPut[i] = Math.max(left[i - k + 1], right[i]);
        }
        return outPut;
    }

    /**
    * @auther  leichunhong
    * @desc 多看几遍
    *输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     *
     * 解释过程中队列中都是具体的值，方便理解，具体见代码。
     * 初始状态：L=R=0,队列:{}
     * i=0,nums[0]=1。队列为空,直接加入。队列：{1}
     * i=1,nums[1]=3。队尾值为1，3>1，弹出队尾值，加入3。队列：{3}
     * i=2,nums[2]=-1。队尾值为3，-1<3，直接加入。队列：{3,-1}。此时窗口已经形成，L=0,R=2，result=[3]
     * i=3,nums[3]=-3。队尾值为-1，-3<-1，直接加入。队列：{3,-1,-3}。队首3对应的下标为1，L=1,R=3，有效。result=[3,3]
     * i=4,nums[4]=5。队尾值为-3，5>-3，依次弹出后加入。队列：{5}。此时L=2,R=4，有效。result=[3,3,5]
     * i=5,nums[5]=3。队尾值为5，3<5，直接加入。队列：{5,3}。此时L=3,R=5，有效。result=[3,3,5,5]
     * i=6,nums[6]=6。队尾值为3，6>3，依次弹出后加入。队列：{6}。此时L=4,R=6，有效。result=[3,3,5,5,6]
     * i=7,nums[7]=7。队尾值为6，7>6，弹出队尾值后加入。队列：{7}。此时L=5,R=7，有效。result=[3,3,5,5,6,7]
     *
    * @date  2020-06-22 21:04  
    * @param  [nums, k] 
    * @return  int[]
    */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }




}
