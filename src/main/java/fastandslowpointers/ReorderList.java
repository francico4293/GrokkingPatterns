package fastandslowpointers;

import helpers.ListNode;

public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode middle = findLinkedListMiddle(head);
        ListNode node1 = head, node2 = reverseLinkedList(middle);

        while (node2 != null) {
            ListNode nextNode1 = node1.next;
            ListNode nextNode2 = node2.next;

            node1.next = node2;
            node2.next = nextNode1;

            node1 = nextNode1;
            node2 = nextNode2;
        }

        if (node1 != null) {
            node1.next = null;
        }
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
