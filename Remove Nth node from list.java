class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
   
        int count =0;
    // Move first to the end, maintaining the gap
    while (first != null) {
        if(count<=n)
            first = first.next;
        
        else{
        first = first.next;
        second = second.next;
        }
        count++;
    }
    second.next = second.next.next;
    return dummy.next;
    }
}