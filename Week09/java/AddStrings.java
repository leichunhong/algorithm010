package Week09.java;

/**
 * 〈功能简述〉<br>
 * 〈〉415. 字符串相加
 *
 * @author leichunhong
 * @create 2020-08-03
 * @since 1.0.0
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {

        StringBuilder res=new StringBuilder();

        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry=0;
        while(i>=0||j>=0){

            int n1=i>=0?num1.charAt(i)-'0':0;
            int n2=j>=0?num2.charAt(j)-'0':0;
            int temp=n1+n2+carry;
            carry=temp/10;
            res.append(temp%10);
            i--;
            j--;

        }
        if(carry==1){
            res.append(1);

        }
        return res.reverse().toString();


    }


    }
