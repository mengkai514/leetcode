package LinkedList;

/**
 * 面试题 02.07. 链表相交
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lengthA = 0;
        while (curA != null) {
            lengthA++;
            curA = curA.next;
        }
        int lengthB = 0;
        while (curB != null) {
            lengthB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if (lengthB > lengthA) {
            int tempLength = lengthA;
            lengthA = lengthB;
            lengthB = tempLength;
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }
        int gap = lengthA - lengthB;
        while (gap-- > 0) {
            curA = curA.next;
        }
        while(curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
