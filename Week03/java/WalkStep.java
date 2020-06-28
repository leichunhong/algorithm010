package Week03.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 上台阶问题 ：
 * 步骤：递归三个数换  ==1 return 1  fi=1 se=2 for(3;length)  thir=fi+se; fi=se;se=thir  return se;
 *
 *
 * @author leichunhong
 * @create 2020-06-11
 * @since 1.0.0
 */
public class WalkStep {
    /**
     * @param
     * @return
     * @auther leichunhong
     * @desc 动态规划：分解为一些包含最优子结构的子问题，即他的最优解可以从其子问题最优解来构造，可以使动态规则解决
     * @date 2020-06-11 20:21
     */

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;

        }
        int[] db = new int[n + 1];
        //第一步
        db[1] = 1;
        //第二步
        db[2] = 2;
        //三步以上是前两步之和
        for (int i = 3; i <= n; i++) {
            db[i] = db[i - 1] + db[i - 2];

        }
        return db[n];

    }


    /**
     * @param
     * @return
     * @auther leichunhong
     * @desc 斐波拉契数  for 循环 的替换很巧妙
     * @date 2020-06-11 20:29
     */
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;


    }
    
    
    /**
    * @auther  leichunhong
    * @desc 走台阶第二遍
    * @date  2020-06-13 20:51  
    * @param   
    * @return  
    */
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
   /**
   * @auther  leichunhong
   * @desc
   * @date  2020-06-23 13:45
   * @param  [n]
   * @return  int
   */
    public int climbStairs3(int n) {
        if(n==1){
            return 1;
        }
        int first=1;
        int second=2;
        for(int i=3;i<n;i++){
            int third=first+second;
            first=second;
            second=third;

        }
        return second;

    }
    /**
    * @auther  leichunhong
    * @desc 写傻递归
    * @date  2020-06-23 13:46
    * @param
    * @return
    */
    public int climbStairs4(int n) {
        int[] ans = new int[n+1];
        if(n==1){
            return 1;

        }
        //第一步
        ans[1] = 1;
        //第二步
        ans[2] = 2;
        for(int i=3;i<n;i++){
            ans[i]=ans[i-1]+ans[i-2];

        }
        return ans[n];
    }





    }

