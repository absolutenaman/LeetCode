/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void printList(ListNode head) {

        // A loop that runs till head is null
        while (head != null) {

            // Printing data of current node
            System.out.print(head.val);
            if (head.next != null)
                System.out.print("->");

            // Moving to the next node
            head = head.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverseLinkedList(l1);
        ListNode head2 = reverseLinkedList(l2);
        ListNode head = new ListNode();
        ListNode curr = head;
        int carry = 0;
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            curr.next = new ListNode();
            curr = curr.next;
            curr.val = sum;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while (curr1 != null) {
            int sum = curr1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            curr.next = new ListNode();
            curr = curr.next;
            curr.val = sum;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            int sum = curr2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            curr.next = new ListNode();
            curr = curr.next;
            curr.val = sum;
            curr2 = curr2.next;
        }
        if (carry != 0) {
            curr.next = new ListNode();
            curr.val = carry;
        }
        printList(head.next);
        ListNode result = reverseLinkedList(head.next);
        return result;
    }
}