package Week03.java;

import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉20. 有效的括号
 *   步骤：现在发现栈操作很牛叉
 *       1.很简单的入栈，出栈就解决这问题
 *       2.如果是左括号直接压进栈，一直是左就一直压。
 *       3.如果碰见右括号，让栈顶出栈如果能匹配到就出栈，一旦匹配不上肯定出错 返回false
 *       4.依次类推
 *
 * @author leichunhong
 * @create 2020-06-23
 * @since 1.0.0
 */
public class Valid {
    /**
    * @auther  leichunhong
    * @desc 这个代码写的巧妙
     *    1.发现左边的括号，放右边的括号
     *    2.如果不是左边的括号，判断栈是空的或者栈顶出栈的值不等余当前的值 就返回false
     *    3.牛
     *
     *
    * @date  2020-06-23 15:33
    * @param  [s] 进栈：push
     *            出栈：pop
    * @return  boolean
    */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
    /**
    * @auther  leichunhong
    * @desc 
    * @date  2020-06-23 15:57  
    * @param  [s] 
    * @return  boolean
    */
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(stack.isEmpty()||stack.pop()!=c){
                return false;
            }

        }
        return stack.isEmpty();

    }

    public boolean isValid3(String s) {
        Stack<Character> stack=new Stack<>();
        for (char c : s.toCharArray()) {
            if(c=='('){
                stack.push(')');
            }else if(c=='{'){
                stack.push('}');

            }else if(c=='['){
                stack.push(']');
            }else if(stack.isEmpty()||stack.pop()!=c){
                return false;

            }


        }
        return stack.isEmpty();


    }



        public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<Character>();
        // Iterate through string until empty
        for(int i = 0; i<s.length(); i++) {
            // Push any open parentheses onto stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
                // Check stack for corresponding closing parentheses, false if not valid
            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        // return true if no open parentheses left in stack
        return stack.empty();
    }
}
