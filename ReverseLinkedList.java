/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/* Approach 1:Iterative */
 
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev= null;
        
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
        
        
        
    }
}

/* Approach 2 : Recursive */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
        
        
        
    }
}