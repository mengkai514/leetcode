package LinkedList;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author MK
 * @date 2023/6/13 - 18:59
 * BM5 合并k个已排序的链表
 */
public class MergeKLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null) return null;
        ListNode p = new ListNode(-1);
        ListNode dummy = p;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), (a, b) -> (a.val - b.val));
        for (ListNode head : lists) {
            if (head != null){
                queue.add(head);
            }
        }
        while (!queue.isEmpty()) {
            ListNode tail = queue.poll();
            p.next = tail;
            if (tail.next != null) {
                queue.add(tail.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
