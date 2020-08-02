package Week08.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author leichunhong
 * @create 2020-07-31
 * @since 1.0.0
 */
public class MyAtoi {
    public int myAtoi(String str) {

        int index = 0, sign = 1, total = 0;
        //1
        if (str.length() == 0) return 0;

        //2. Remove Spaces
        while (str.charAt(index) == ' ' && index < str.length())
            index++;

        //3. Handle signs
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //4. Convert number and avoid overflow
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }


    public int myAtoiI(String str) {
        str=str.trim();

        int index = 0, sign = 1, total = 0;
        if (str.length() == 0) {
            return 0;
        }
        //1.处理空字符
        while (str.charAt(index) == ' ' && index < str.length()) {
            index++;
        }
        //2.处理正数和负数正数乘以1 负数乘以-1
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        //
        while (index < str.length()) {
            //检查不是数字
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }

            //检查越界
            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit;
            index++;


        }
        return total * sign;


    }

   /**
   * @auther  leichunhong
   * @desc
   * @date  2020-07-31 15:41  
   * @param
   * @return  int
   */
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
    

}
