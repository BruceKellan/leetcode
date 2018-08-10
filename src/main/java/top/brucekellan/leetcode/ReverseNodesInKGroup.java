package top.brucekellan.leetcode;

import java.util.Stack;

/**
 * 25. Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 * @Author: 37
 * @Date: Created at 19:34 2018/8/10
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode res = resolve(stack, head, 1, length, k);
        return res;
    }

    public ListNode resolve(Stack<ListNode> stack, ListNode head, int time, int length, int k) {
        if (time * k <= length) {
            ListNode lastNode = null;
            for (int i = 0; i < k; i++) {
                stack.push(head);
                head = head.next;
                if (i == k - 1) {
                    lastNode = head;
                }
            }
            ListNode firstNode = stack.pop();
            ListNode node = firstNode;
            for (int i = 1; i < k; i++) {
                node.next = stack.pop();
                node = node.next;
            }
            node.next = lastNode;
            ListNode nextNode = resolve(stack, node.next, ++time, length, k);
            node.next = nextNode;
            return firstNode;
        } else {
            return head;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
