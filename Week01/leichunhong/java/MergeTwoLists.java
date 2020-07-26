package Week01.leichunhong.java;

import Week01.leichunhong.dto.ListNode;

/**
 * 〈功能简述〉<br>
 * 〈〉21. 合并两个有序链表
 * 合并有序链表
 * 步骤：1 两个队列有一个为空就为空
 *      2.当l1的val<l2的val
 *      3.l1.next=递归自己(l1.next,l2) return l1
 *      4.else情况l2.next=递归自己(l1,l2.next) return l2
 *
 *
 * @author leichunhong
 * @create 2020-06-14
 * @since 1.0.0
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //默认l1 的val 比较小 如果小于l2 的对应的val 那l1的next=l1的next 另一个l2不会移动 当满足条件再去l2移动
        //反之一样 不是很好理解
        // 1 2 3 4 11 12
        // 5 6 7 8 13 14
        //先走1234 都小于5 当11时大于5走到l2去
        //5  6 7 8
        //11 12
        //变成1 2 3 4 5 6 7 8都小于11 当变成13时 13大于11换
        //11 12
        //13 14
        //1 2 3 4 5 6 7 8 11 12  l1完了，再接着返回l2
        //1 2 3 4 5 6 7 8 11 12 13 14完成。

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next =mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next =mergeTwoLists(l1,l2.next);
            return l2;
        }

    }
    /**
    * @auther  leichunhong
    * @desc 第二遍
    * @date  2020-06-14 18:34
    * @param  [l1, l2] 
    * @return  Week01.leichunhong.dto.ListNode
    */
    public ListNode mergeTwoLists1List1(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;

        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next=mergeTwoLists1List1(l1.next,l2);
            return l1;

        }else{
            l2.next=mergeTwoLists1List1(l1,l2.next);
            return l2;
        }

    }
    /**
    * @auther  leichunhong
    * @desc 第五周复习  多少个日日夜夜孤独的我再黑夜中默默敲着代码，写着属于自己的宁静
    * @date  2020-07-07 22:34
    * @param  [l1, l2]
    * @return  Week01.leichunhong.dto.ListNode
    */
    public ListNode mergeTwoLists1List2(ListNode l1, ListNode l2) {

        if(l1==null){
            return l2;

        }
        if(l2==null){
            return l1;

        }
        if(l1.val<l2.val){
            l1.next=mergeTwoLists1List2(l1.next,l2);
            return l1;

        }else{
            l2.next=mergeTwoLists1List2(l1,l2.next);
            return l2;
        }
    }






    }
