package LinkedList;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dumyhead = new ListNode(-1);
        dumyhead.next = head;
        ListNode cur = dumyhead;
        ListNode temp;
        ListNode firstNode;
        ListNode secondNode;
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode; //第一步
            secondNode.next = firstNode; //第二步
            firstNode.next = temp; // 第三步
            cur = firstNode; // cur移动，准备下一轮交换
        }
        return dumyhead.next;
    }
}
