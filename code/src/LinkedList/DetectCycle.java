package LinkedList;

/**
 * 142. 环形链表 II
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fastIndex = head;
        ListNode slowIndex = head;
        while (fastIndex != null && fastIndex.next != null) {
            fastIndex = fastIndex.next.next;
            slowIndex = slowIndex.next;
            if (fastIndex == slowIndex) {
                ListNode index1 = fastIndex;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index2;
            }
        }
        return null;
    }
}
