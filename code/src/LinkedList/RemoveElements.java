package LinkedList;

/**
 * 203. 移除链表元素
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        //删除值相同的头结点后，可能新的头结点也值相等，用循环解决
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null)
            return null;

        //原链表head是储存在堆内存中，prev = head，只是将prev和head具有同一个引用地址，后续对prev的操作，
        // 即也是对这个引用地址中数据的操作，故原head数据也会改变
        ListNode prev = head;
        //确保当前结点后还有结点
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return head;
    }
}
