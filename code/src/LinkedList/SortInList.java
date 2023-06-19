package LinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author MK
 * @date 2023/6/19 - 19:30
 * BM12 单链表的排序
 */
public class SortInList {
    public ListNode sortInList (ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode nHead = dummy;
        ListNode sortNode = head;
        List<Integer> list = new ArrayList<>();
        while (sortNode != null) {
            list.add(sortNode.val);
            sortNode = sortNode.next;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (Integer integer : list) {
            dummy.next = new ListNode(integer);
            dummy = dummy.next;
        }
        return nHead.next;
    }
}
