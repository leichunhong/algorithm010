package Week08.java;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *2. 两数相加
 * @author leichunhong
 * @create 2020-07-29
 * @since 1.0.0
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }

    /**
     * @param [l1, l2]
     * @return Week08.java.AddTwoNumbers.ListNode
     * @auther leichunhong
     * @desc
     * @date 2020-07-29 18:08
     */
    public ListNode addTwoNumbersI(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {

            cur.next = new ListNode(0);

            cur = cur.next;

            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            cur.val = carry % 10;
            carry = carry / 10;

        }
        return dummy.next;

    }

    /**
     * @param [l1, l2]
     * @return Week08.java.AddTwoNumbers.ListNode
     * @auther leichunhong
     * @desc 比较好理解
     * @date 2020-07-29 18:32
     */
    public ListNode addTwoNumbersIII(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
    /**
    * @auther  leichunhong
    * @desc
    * @date  2020-07-29 20:44  
    * @param  [l1, l2] 
    * @return  Week08.java.AddTwoNumbers.ListNode
    */
    public ListNode addTwoNumbersIIII(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);

        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {

            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            //x+y+进位
            int sum = x + y + carry;
            //更新进位
            carry = sum / 10;
            //把当前值加到ListNode
            sum = sum % 10;

            cur.next = new ListNode(sum);

            //下一位
            cur=cur.next;
            if(l1!=null){
                l1=l1.next;

            }
            if(l2!=null){
                l2=l2.next;

            }

        }
        //最后超位
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        return pre.next;

    }


}
