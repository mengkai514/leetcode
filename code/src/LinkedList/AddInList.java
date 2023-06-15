package LinkedList;

/**
 * @author MK
 * @date 2023/6/15 - 20:28
 * BM11 链表相加(二)
 */
public class AddInList {
    public ListNode addInList (ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode head = new ListNode(-1);
        ListNode nHead = head;
        int temp = 0;
        while(head1 != null || head2 != null) {
            int val = temp;
            if (head1 != null) {
                val += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                val += head2.val;
                head2 = head2.next;
            }
            temp = val / 10;
            nHead.next = new ListNode(val % 10);
            nHead = nHead.next;
        }
        if (temp > 0) {
            nHead.next = new ListNode(temp);
        }
        return reverse(head.next);
    }

    public ListNode reverse(ListNode head) {
        if(head == null)
            return null;
        ListNode cur = head;
        ListNode node = null;
        while(cur != null){
            ListNode tail = cur.next;
            cur.next = node;
            node = cur;
            cur = tail;
        }
        return node;
    }
}
