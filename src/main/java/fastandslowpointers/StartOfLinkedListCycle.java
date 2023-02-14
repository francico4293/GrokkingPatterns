package fastandslowpointers;

import helpers.ListNode;

public class StartOfLinkedListCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                int cycleLength = findCycleLength(slow);
                return findCycleStart(head, cycleLength);
            }
        }

        return null;
    }

    private int findCycleLength(ListNode node) {
        int length = 0;
        ListNode currNode = node;

        do {
            currNode = currNode.next;
            length++;
        } while (!node.equals(currNode));

        return length;
    }

    private ListNode findCycleStart(ListNode head, int cycleLength) {
        ListNode node1 = head, node2 = head;

        while (cycleLength > 0) {
            node2 = node2.next;
            cycleLength--;
        }

        while (!node1.equals(node2)) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }
}
