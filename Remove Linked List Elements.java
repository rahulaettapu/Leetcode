/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int value) {
        if(head == null)
            return head;
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode curr = head;
        ListNode prev = dum;
        
        while(curr != null){
            if(curr.val == value){
                prev.next = curr.next;
                curr = curr.next;
            }
            else{
            curr = curr.next;
            prev = prev.next;
            }
        }
        return dum.next;
    }
}