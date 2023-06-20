package LinkedList;

/**
 * @author MK
 * @date 2023/6/20 - 19:17
 * BM14 链表的奇偶重排
 */
public class OddEvenList {
    public ListNode oddEvenList (ListNode head) {
        if (head == null) return null;
        ListNode odd = head;  //奇数
        ListNode even = head.next;  //偶数
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
