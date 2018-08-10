package top.brucekellan.leetcode;

import org.junit.Test;

public class ReverseNodesInKGroupTest {

    @Test
    public void test() {
        ReverseNodesInKGroup.ListNode node1 = generate(new int[]{1, 2, 3, 4, 5});
        printNode(new ReverseNodesInKGroup().reverseKGroup(node1, 2));
        ReverseNodesInKGroup.ListNode node2 = generate(new int[]{1, 2, 3, 4, 5});
        printNode(new ReverseNodesInKGroup().reverseKGroup(node2, 3));
        ReverseNodesInKGroup.ListNode node3 = generate(new int[]{1, 2, 3, 4, 5, 6});
        printNode(new ReverseNodesInKGroup().reverseKGroup(node3, 2));
    }

    private ReverseNodesInKGroup.ListNode generate(int[] nums) {
        ReverseNodesInKGroup.ListNode node = new ReverseNodesInKGroup.ListNode(nums[0]);
        ReverseNodesInKGroup.ListNode head = node;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ReverseNodesInKGroup.ListNode(nums[i]);
            node = node.next;
        }
        return head;
    }

    private void printNode(ReverseNodesInKGroup.ListNode head) {
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }

}