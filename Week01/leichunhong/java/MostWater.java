package Week01.leichunhong.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *  装最多的水
 *  步骤：1.定义最大值max
 *       2.循环整个数组 初始值 i=0和j=length-1双端往中间走
 *       3.当a[i]<a[j]?a[i++]:a[j--]
 *       4.return max
 * @author leichunhong
 * @create 2020-06-10
 * @since 1.0.0
 *
 */
public class MostWater {
    /**
    * @auther  leichunhong
     * 第一遍 写错了 手误写成j++了  j是最大的加个毛线呀
    * @desc 一次循环写法 夹逼操作
    * @date  2020-06-10 13:28
    * @param
    * @return
    */
    public static int maxArea(int a[]) {
        int max=0;
        for(int i=0,j=a.length-1;i<j;){
            int moveMinBar=a[i]<a[j]?a[i++]:a[j--];
            max=Math.max(max,(j-i+1)*moveMinBar);

        }
        return max;

    }
    /**
    * @auther  leichunhong
    * @desc 第二遍  最多水
    * @date  2020-06-10 13:38
    * @param
    * @return
    */

    public static int maxArea2(int a[]) {

        int max=0;
        for(int i=0,j=a.length-1;i<j;){
            int minArr=a[i]<a[j]?a[i++]:a[j--];
            max=Math.max(max,(j-i+1)*minArr);

        }
        return max;

    }

    /**
    * @auther  leichunhong
    * @desc 最多的水第三遍
    * @date  2020-06-13 21:33
    * @param
    * @return  int
    */
    public static int maxArea3(int a[]) {

        int max=0;
        //两端往中间找
        for(int i=0,j=a.length-1;i<j;){
            int min=a[i]<a[j]?a[i++]:a[j--];
            max=Math.max(max,(j-i+1)*min);
        }
        return max;

    }






    }
