# 学习笔记
# 树
1. 每个节点都访问一次，并且仅访问一次。
2. 深度优先，广度优先

# 深度优先
1. 自己理解深度 就是选一条道走到黑，走到最深处，走到底，走完之后回来继续走下一个没走的道。
2. 广度优先讲究的就是广，不管你下去有几个道，一排排往下走，有点像水流 从大河到到各种小河再到小溪。扩散形式搜索。
# 乱写
1. ArrayList
2. Stack栈
3. Queue
4. Deque（双向队列）
5. 递归
6. 哈希
7. TreeNode（二叉树）
8. 堆
9. PriorityQueue（优先队列默认小顶堆）
10.数组里面别忘记交换
11.dp[][][] n维数组就n个[]解决别for循环套否循环赋值了

## 回朔算法模板
    result = []
    def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return

    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
        
        
        
        
    result=[]
    def backTrack(路径,选择列表):
       if(满足条件)
          result.add(路径)
          return
    for(选择 in ：选择列表)
        做选择
        backTrack(路径，选择列表)
        撤销选择
## dfs 模板
    visited = set() 
    def dfs(node, visited):
        if node in visited: # terminator
        	# already visited 
        	return 
    	visited.add(node) 
    	# process current node here. 
    	...
    	for next_node in node.children(): 
    		if next_node not in visited: 
    			dfs(next_node, visited)
    			
    //非递归写法	
    def DFS(self, tree): 
    	if tree.root is None: 
    		return [] 
    	visited, stack = [], [tree.root]
    	while stack: 
    		node = stack.pop() 
    		visited.add(node)
    		process (node) 
    		nodes = generate_related_nodes(node) 
    		stack.push(nodes) 
    	# other processing work 
    	...
## bfs模板
    #python
    
    def BFS(graph, start, end):
        visited = set()
    	queue = [] 
    	queue.append([start]) 
    	while queue: 
    		node = queue.pop() 
    		visited.add(node)
    		process(node) 
    		nodes = generate_related_nodes(node) 
    		queue.push(nodes)
    	# other processing work 
    	...  	
    	
## 动态规划模板
    
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
## 动态规划上台阶的例子
    public int climbStairs2(int n) {
            //1 返回1
           if(n==1){
               return 1;
    
           }
           //定义第一步
           int first=1;
           //定义第二部
           int second=2;
           //三步以上每步替换
           for(int i=3;i<=n;i++){
               int third=first+second;
               first=second;
               second=third;
    
           }
           return second;
    
        }
## bs
    // 计算从起点 start 到终点 target 的最近距离
    int BFS(Node start, Node target) {
        Queue<Node> q; // 核心数据结构
        Set<Node> visited; // 避免走回头路
    
        q.offer(start); // 将起点加入队列
        visited.add(start);
        int step = 0; // 记录扩散的步数
    
        while (q not empty) {
            int sz = q.size();
            /* 循环这一层的多有节点 */
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                /* 划重点：这里判断是否到达终点 */
                if (cur is target)
                    return step;
                /* 将 cur 的相邻节点加入队列：如果是树我觉得是其left和right */
                for (Node x : cur.adj())
                    if (x not in visited) {
                        q.offer(x);
                        visited.add(x);
                    }
            }
            /* 划重点：更新步数在这里 */
            step++;
        }
    }
# 陆地问题 的思路很清奇 
1. 循环+dfs 循环遇见1标记陆地，并把所有和这个1相邻的1全部递归夷为平地

# 广度优先的傻叉理解 【3 9 20】
1. 广度优先就是一层一层的来，怎么保证每层不受干扰，就是先把第一层放到队列里面
2. 这一层不是空的时候，循环第一次从队列中依次取出来，比如第一层是3  把3出队列 那第一次循环是3 把3放到list，然后把左9和右20都加到队列
3. 循环第二次 队列中只有第二次加的 就是两个数 9和20  循环放到list，依次往下 直到节点为null
4. 以前有点懵这不就是开发中模块--->菜单，菜单--->二级菜单，只不过开发中是id和pid关联的。每一层菜单放到队列里使用，使用完出队列。在把下次的放进去
5. 二叉树下次的就是left和right 这就是所谓的广度优先 一层一层来
6. 我觉得list也能做广度 数组也可以，就是一层放进来-->用完--清空容器（数组，List，队列）-->再放下一组

## 二分查找伪代码
    //常规
    int  binSerch(int[] nums,int target){
    
    int left=0;
    int right=nums.length-1;
    while(left<=right){
        int mid=left+(right-left)/2; 
       
       if(nums[mid]=target){
         return mid;
       }else if(nums[mid]<target){
         left=mid+1;
       }else if(nums[mid]>target){
        right=mid-1;
       }
    }
    return -1;
    
    }
    
    
    
        //左边
        int  binSerch(int[] nums,int target){
        
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2; 
           
           if(nums[mid]=target){
             // 别返回，锁定左侧边界
             right = mid - 1;
           }else if(nums[mid]<target){
             left=mid+1;
           }else if(nums[mid]>target){
            right=mid-1;
           }
        }
        if(){
        }
        return -1;
        
        }
        
    
# 嘟嘟助教的规律
1. 先找前序遍历的第一个肯定是跟节点
2. 在中序节点去找前序遍历确定的跟节点，左右一分
3. 先左边 左边的第一个就是左子树的跟节点
4. 再去中序找这个跟节点的左右。依次递归
5. 中序遍历 右边的时候只要树不是null必须先放左 -root -（right）有子树不能放 再左 root --right（有还不能放） 直到树的节点是null

# 股票信息   [i]:天数 [k]：可以进行多少次交易 [0]：无持有 [1]:持有股票
1. dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
   解释：我今天没有股票max(昨天没有持有+昨天持有+今天卖了)
   max   (i-1):昨天 [k]:k次交易 [0] 昨天可以进行k次交易但是没有持有股票
         (i-1):昨天 [k]:k次交易 [1] 持有股票   +prices[i] ：昨天持有k次交易的股票，但是今天卖了+prices[i]收入，所以也没有持有股票
   
   dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
   解释：我今天持有股票max(昨天持有，昨天没有持有但是今天买了)
        dp[i-1][k][1]：昨天持有k次交易的股票，
        dp[i-1][k-1][0] - prices[i]：昨天没有持有股票，但是今天买了股票

   

       