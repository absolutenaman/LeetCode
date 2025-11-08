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
 // Nice question to be honest
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftNode=new ListNode();
        ListNode currLeftNode=leftNode;
        ListNode rightNode=new ListNode();
        ListNode currRightNode=rightNode;
        ListNode curr=head;
        while(curr!=null){
            if(curr.val < x) {
                currLeftNode.next=curr;
                currLeftNode=curr;
            } else {
                currRightNode.next=curr;
                currRightNode=curr;
            }
            curr=curr.next;
        }
                currRightNode.next=null;
        currLeftNode.next=rightNode.next;
        return leftNode.next;
    }
}
