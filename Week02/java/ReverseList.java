package Week02.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 206. 反转链表
 * @author leichunhong
 * @create 2020-06-16
 * @since 1.0.0
 */
public class ReverseList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    /**
    * @auther  leichunhong
    * @desc
    * @date  2020-06-16 11:55  
    * @param
    * @return  Week02.java.ReverseList.ListNode
    */
    public ListNode reverseList(ListNode head) {
        //申请 三个变量交换
        ListNode pre=null;
        ListNode cur=head;
        ListNode tem=null;
        //当当前节点不为空时
        while(cur!=null){
            //临时变量是当前节点的下一个value
            tem=cur.next;
            //当前节点指回去
            cur.next=pre;
            //pre和cur节点都前进一位
            //当前节点变成前一个节点
            pre=cur;
            //临时节点就是当前节点
            cur=tem;

        }
        return pre;



    }
    
    
    /**
    * @auther  leichunhong
    * @desc 第二遍
    * @date  2020-06-16 14:11  
    * @param   
    * @return  
    */

    public ListNode reverseList1(ListNode head) {
        ListNode pre=null;
        ListNode cru=head;
        ListNode temp=null;
        while(cru!=null){
            temp=cru.next;
            cru.next=pre;
            pre=cru;
            cru=temp;
        }
        return pre;

    }





    }
