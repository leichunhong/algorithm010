package Week01.leichunhong.java;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *  双端队列改写！
 * @author leichunhong
 * @create 2020-06-13
 * @since 1.0.0
 */
public class DequeRewrite {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        //采用抛异常的方式做
        //addFist
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println("初始队列：" + deque);
        //获取第一个元素
        String str = deque.getFirst();
        System.out.println("检查第一个元素：" + str);
        System.out.println("检查完第一个元素后队列：" + deque);
        //addLast
        deque.addLast("d");
        deque.addLast("e");
        deque.addLast("f");
        System.out.println("向队尾加元素结果：" + deque);


        //去掉第一个元素
        deque.removeFirst();
        System.out.println("去掉第一个元素结果：" + deque);

        //去掉最后的元素
        deque.removeLast();
        System.out.println("去掉最后一个元素结果：" + deque);

        //全去掉
        while(deque!=null&&deque.size()>0){
            deque.removeFirst();
        }
        System.out.println("最后队列：" + deque);

    }
}
