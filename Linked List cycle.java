/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        
        int flag = 0;
        do{
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == null || fast.next == null){
                flag=1;
                break;
            }
            
        }while(fast!=slow);
        
        if(flag ==1)
            return false;
        return true;
        
    }
}