package Week01.leichunhong.test;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * @create 2020-06-07
 * @since 1.0.0
 * des： 验证回文串
 *
 */

public class Main1 {

    /**
    * @auther  leichunhong
    * @desc 二分法和正则
    * @date  2020-06-07 21:46  
    * @param  
    * @return  boolean
    */
    public static boolean isPalindrome(String s) {
        //1.filter out number & char 2.reverse or comprre
        String filterS = filterNumAndCar(s);
        String reverseS = reverseChar(filterS);
        return filterS.equalsIgnoreCase(reverseS);
    }

    private static String reverseChar(String filterS) {
        return new StringBuffer(filterS).reverse().toString();
    }

    private static String filterNumAndCar(String s) {
        String s1=s.replaceAll("[^A-Za-z0-9]", "");
        System.out.println(s1);
        return s1;
    }
    public static void main(String[] args) {


        isPalindrome("A man, a plan, a canal: Panama");
    }

    /**
    * @auther  leichunhong
    * @desc 循环写法
    * @date  2020-06-07 21:46  
    * @param
    * @return  boolean
    */
    public static boolean isPalindrome1(String s) {
        String strS=s.toLowerCase();
        StringBuffer stringBuffer=new StringBuffer();
        for (char c : strS.toCharArray()) {
            if(Character.isLetterOrDigit(c)){
                stringBuffer.append(c);

            }
        }
        return stringBuffer.toString().equals(stringBuffer.reverse().toString());
    }

    /**
    * @auther  leichunhong
    * @desc 简化的双层遍历 水装最对
    * @date  2020-06-10 12:57
    * @param
    * @return
    */
    public static int isPalindrome2(int a[]) {
        int max=0;
        for(int i=0;i<a.length-1;++i){
            for(int j=i+1;j<a.length;++j){
                int array=(j-i)*Math.min(a[i],a[j]);
                max=Math.max(max,array);

            }
        }
        return max;
    }

    /**
    * @auther  leichunhong
    * @desc 单层写法 需要理解往中间走的规律，谁最小谁向中间走，大不了走到一起，总不能让高的往中间走吧
     *有个很不好听的名字  左右夹逼 方法
    * @date  2020-06-10 13:13
    * @param
    * @return  int
    */
    public static int isPalindrome3(int a[]) {
        int max=0;
        for(int i=0,j=a.length-1;i<j;){
            int minArray=a[i]<a[j]?a[i++]:a[j--];
            max=Math.max(max,(j-i+1)*minArray);
        }
        return max;
    }




}
