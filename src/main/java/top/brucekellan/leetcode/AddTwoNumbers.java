package top.brucekellan.leetcode;


import com.google.common.collect.Lists;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(listNodeToString(addTwoNumbers(l1, l2)));
    }

    private static List<Integer> listNodeToString(ListNode listNode) {
        List<Integer> integers = Lists.newArrayList();
        while(listNode != null) {
            integers.add(listNode.val);
            listNode = listNode.next;
        }
        return integers;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;
        ListNode current = new ListNode(0);
        ListNode res = current;
        int bit = 0;
        while(l1 != null || l2 != null ||  bit != 0) {
            if(l1 == null) {
                l1 = new ListNode(0);
            }
            if(l2 == null) {
                l2 = new ListNode(0);
            }
            current.val = (l1.val + l2.val + bit) % 10;
            bit = (l1.val + l2.val + bit) / 10;
            l1 = l1.next;
            l2 = l2.next;
            if(l1 != null || l2 != null ||  bit != 0) {
                current.next = new ListNode(0);
            }
            current = current.next;
        }
        return res;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
