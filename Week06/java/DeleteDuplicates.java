package Week06.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *83. 删除排序链表中的重复元素
 * @author leichunhong
 * @create 2020-07-19
 * @since 1.0.0
 */
public class DeleteDuplicates {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

   /**
   * @auther  leichunhong
   * @desc 时间复杂度：O(n)
   * @date  2020-07-19 18:08  
   * @param
   * @return  Week06.java.DeleteDuplicates.ListNode
   */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                // cur.val 和 cur.next.val 相等则将 cur 的下一个指针指向下一个的下一
                cur.next = cur.next.next;

            } else {
                //如果不相等则 cur 移动到下一个位置继续循环
                cur = cur.next;
            }

        }
        return head;


    }


}
