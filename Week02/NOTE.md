学习笔记
# 小的总结

1. 解题思路问题，很重要，不能一味的背题没有效果，首先要弄得题，再采取怎样的解法。
   比如是用ArrayList还是LinkedList还是hashmap 还是选stack
2. 了解每个题型的解题步骤这个很重要，知道步骤基本就能解出来。
3. 多写争取多理解。

#  堆，二叉堆 大顶堆，小顶堆
1. 如果是一维数组看的话就是 最大或者最小就是a[0]
2. index 为i的左孩子是2i+1
3. index 为i的右孩子是2i+2
4. index 为i的父节点是floor((i-1)/2)
5. 插入一个节点都先插入堆的尾部，依次向上调整堆的结构到正确的位置。
6. 交换的规则while 该节点大于父亲节点 交换  源码是记住最终换的位置再插入，每次只是把父亲节点拉下来，记住自己节点的index。循环完再插入，思想。
7. 工业级别的堆直接用优先队列 priority_queue

# 需要熟悉hashMap的源码
1. 总结本周加班比较多，视频只看了一遍，做完题需要自己回忆写下步骤，我觉得下次写会好很多，按照步骤有思路怎么实现就很简单。
2. 不能盲目的写不总结，下次看到题还是不会。
3. 下周放假记得过遍数题。


# 纠正一个写法 
1. 自己写Array老想着add 数组只能nums[i]=value 赋值
2. 再确认做题步骤，五分钟没思路 看经典题解
3. 看完题解读懂解题步骤，除非看不懂才能照着写，看得懂自己先写下思路就是做题步骤。
4. 然后自己打开intelliJ 按自己的步骤默写不能看题解。
## 动态规划
    
    int fib(int N) {
        if (N < 1) return 0;
        // 备忘录全初始化为 0
        vector<int> memo(N + 1, 0);
        // 进行带备忘录的递归
        return helper(memo, N);
    }
    
    int helper(vector<int>& memo, int n) {
        // base case 
        if (n == 1 || n == 2) return 1;
        // 已经计算过
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }
