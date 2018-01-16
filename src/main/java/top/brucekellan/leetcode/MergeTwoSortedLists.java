package top.brucekellan.leetcode;

import java.util.List;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * @author brucekellan
 * @create 2018-01-17
 */
public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while(l1 != null && l2 != null) {
            ListNode node = null;
            if(l1.val < l2.val) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node = new ListNode(l2.val);
                l2 = l2.next;
            }
            tmp.next = node;
            tmp = tmp.next;
        }

        while(l1 != null) {
            ListNode node = new ListNode(l1.val);
            l1 = l1.next;
            tmp.next = node;
            tmp = tmp.next;
        }

        while(l2 != null) {
            ListNode node = new ListNode(l2.val);
            l2 = l2.next;
            tmp.next = node;
            tmp = tmp.next;
        }

        return res.next;
    }

}
