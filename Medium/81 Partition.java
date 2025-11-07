  public class ListNode {
     int val;
     ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode curr = head;
        ListNode newHead = new ListNode();
        ListNode newCurr = newHead;
        while (curr != null) {
            if (curr.val < x) {
                newCurr.val = curr.val;
                newCurr.next = new ListNode();
            }
            curr = curr.next;
        }
        return newHead;
    }
}