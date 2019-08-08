/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        int i=0;
        ListNode curr = head.next;
        ListNode prev = head;
        ListNode prev1 = null;
        while(prev.next !=null && curr !=null){
            //System.out.println(i);
            
            
            prev.next = curr.next;
            curr.next = prev;
            if(i!=0){
                prev1.next = curr;
            }
           
            if(i==0){
                head = curr;
                i++;
            }
            
            
            ListNode temp = curr;
            curr = prev;
            prev= temp;
            
            if(curr.next == null )
                break;
            
            curr = curr.next.next;
            prev1 = prev.next;
            prev = prev.next.next;
            
            
        }
        return head;
    }
}