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
    public ListNode getMiddleNode(ListNode head){
        ListNode curr=head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
       public void printList(ListNode head) {

        // A loop that runs till head is null
        while (head != null) {

            // Printing data of current node
            System.out.print(head.val);
            if(head.next!=null)
            System.out.print("->");

            // Moving to the next node
            head = head.next;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=curr;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode curr=head;
        ListNode middleNode=getMiddleNode(head);
        ListNode reversedMiddleListHead=reverse(middleNode);
        printList(reversedMiddleListHead);
        while(curr!=null && reversedMiddleListHead!=null){
            if (curr.val!=reversedMiddleListHead.val) {
                return false;
            }
            curr=curr.next;
            reversedMiddleListHead=reversedMiddleListHead.next;
        }
                return true;

    }
}