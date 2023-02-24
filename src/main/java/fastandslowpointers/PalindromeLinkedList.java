package fastandslowpointers;

import helpers.ListNode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode middle = findLinkedListMiddle(head);
        ListNode node1 = head, node2 = reverseLinkedList(middle);

        while (node2 != null) {
            if (node1.val != node2.val) {
                return false;
            }

            node1 = node1.next;
            node2 = node2.next;
        }

        return true;
    }

    private ListNode findLinkedListMiddle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseLinkedList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode restOfLinkedList = reverseLinkedList(node.next);

        node.next.next = node;
        node.next = null;

        return restOfLinkedList;
    }
}
