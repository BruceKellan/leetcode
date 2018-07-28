package top.brucekellan.leetcode;

import org.junit.Test;

public class SwapNodesInPairsTest {

    @Test
    public void swapPairs() {
        SwapNodesInPairs.ListNode first = new SwapNodesInPairs.ListNode(1);
        first.next = new SwapNodesInPairs.ListNode(2);
        first.next.next = new SwapNodesInPairs.ListNode(3);
        first.next.next.next = new SwapNodesInPairs.ListNode(4);
        SwapNodesInPairs.ListNode result = new SwapNodesInPairs().swapPairs(first);
        System.out.println(print(result));
    }

    public String print(SwapNodesInPairs.ListNode listNode) {
        StringBuilder stringBuilder = new StringBuilder();
        while (listNode != null) {
            stringBuilder.append(listNode.val).append("->");
            listNode = listNode.next;
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        return stringBuilder.toString();
    }


}