package LinkedList;

import java.util.Stack;

/**
 * 206. 反转链表
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next; // 保存下一个节点

            cur.next = prev; //反转
            // 更新prev、cur位置
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    // 从后向前递归
    public static ListNode reverseList2(ListNode head) {
        // 边缘条件判断
        if(head == null) return null;
        if (head.next == null) return head;

        // 递归调用，翻转第二个节点开始往后的链表
        ListNode last = reverseList2(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        // 此时的 head 节点为尾节点，next 需要指向 NULL
        head.next = null;
        return last;
    }
    public ListNode reverseList3(ListNode head) {
        // 如果链表为空，则返回空
        if (head == null) return null;
        // 如果链表中只有只有一个元素，则直接返回
        if (head.next == null) return head;
        // 创建栈 每一个结点都入栈
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 创建一个虚拟头结点
        ListNode pHead = new ListNode(0);
        cur = pHead;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            cur.next = node;
            cur = cur.next;
        }
        // 最后一个元素的next要赋值为空
        cur.next = null;
        return pHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        reverseList2(head);
    }
}
