package top.brucekellan.leetcode;

/**
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @author brucekellan
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode next = swapPairs(head.next.next);
        head.next.next = head;
        head.next = next;
        return newHead;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
