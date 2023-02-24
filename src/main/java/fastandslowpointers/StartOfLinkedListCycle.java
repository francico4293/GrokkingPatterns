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

    private int findCycleLength(ListNode startingNode) {
        int length = 1;
        ListNode currNode = startingNode.next;

        while (!startingNode.equals(currNode)) {
            currNode = currNode.next;
            length++;
        }

        return length;
    }

    private ListNode findCycleStart(ListNode head, int cycleLength) {
        ListNode first = head, second = head;

        while (cycleLength > 0) {
            second = second.next;
            cycleLength--;
        }

        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return first;
    }
}
