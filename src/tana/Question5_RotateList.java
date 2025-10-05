package tana;

public class Question5_RotateList {

    static class ListNode {
        String val;
        ListNode next;

        ListNode(String val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Rotates a linked list to the right by n positions
     * @param head Head of the linked list
     * @param n Number of positions to rotate right
     * @return New head of the rotated list
     */
    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head;
        }

        // Find length and make it circular
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head;

        // Find the new tail (length - n % length - 1 steps from head)
        n = n % length; // Handle cases where n > length
        int stepsToNewTail = length - n;

        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Helper method to create a list from array
    public static ListNode createList(String[] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    // Helper method to print list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println("->null");
    }

    // Test method
    public static void main(String[] args) {
        // Test case 1: Example from problem
        String[] values1 = {"ID_A01", "ID_A02", "ID_A03", "ID_A04", "ID_A05", "ID_A06"};
        ListNode head1 = createList(values1);
        System.out.println("Original list:");
        printList(head1);

        ListNode rotated1 = rotateRight(head1, 2);
        System.out.println("Rotated by 2:");
        printList(rotated1);

        // Test case 2: Rotate by 0
        String[] values2 = {"A", "B", "C"};
        ListNode head2 = createList(values2);
        ListNode rotated2 = rotateRight(head2, 0);
        System.out.println("\nRotated by 0:");
        printList(rotated2);

        // Test case 3: Rotate by length (should return original)
        String[] values3 = {"X", "Y"};
        ListNode head3 = createList(values3);
        ListNode rotated3 = rotateRight(head3, 2);
        System.out.println("Rotated by length:");
        printList(rotated3);

        // Test case 4: Single node
        String[] values4 = {"SINGLE"};
        ListNode head4 = createList(values4);
        ListNode rotated4 = rotateRight(head4, 1);
        System.out.println("Single node rotated:");
        printList(rotated4);
    }
}
