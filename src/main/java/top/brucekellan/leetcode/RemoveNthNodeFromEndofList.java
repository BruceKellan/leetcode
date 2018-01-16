package top.brucekellan.leetcode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * @author brucekellan
 * @create 2018-01-16
 */
public class RemoveNthNodeFromEndofList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode afterPreN = head;
        while (n-- != 0) {
            afterPreN = afterPreN.next;
        }
        if (afterPreN != null) {
            while (afterPreN.next != null) {
                pre = pre.next;
                afterPreN = afterPreN.next;
            }
            pre.next = pre.next.next;
        } else {
            head = head.next;
        }
        return head;
    }

}
