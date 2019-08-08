/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// Approach 1: Using Divide and Conquer. merge 2 lists at a time till you get 1 final list.
// Time Complexity is O(nlogk).
/*
Time complexity : O(N\log k)O(Nlogk) where \text{k}k is the number of linked lists.

We can merge two sorted linked list in O(n)O(n) time where nn is the total number of nodes in two lists.
Sum up the merge process and we can get: O\big(\sum_{i=1}^{log_{2}{k}}N \big)= O(N\log k)O(∑ i=1log 2kN)=O(Nlogk)
Space complexity : O(1)O(1)

We can merge two sorted linked lists in O(1)O(1) space.
*/
class Solution {
    
    public ListNode merge(ListNode a, ListNode b){
        if(a==null)
            return b;
        if(b==null)
            return a;
        ListNode ans = null;
        if(a.val <= b.val){
            ans = a;
            ans.next = merge(a.next,b);
        }
        else{
            ans =b;
            ans.next = merge(a,b.next);
        }
        
        return ans;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0)
            return null; 
        
        int l = lists.length-1;
        
        while(l!=0){
            int i = 0;
            int j = l;
            
            while(i<j){
                lists[i] = merge(lists[i],lists[j]);
                i++;
                j--;
                
                if(i>=j)
                    l = j;
            }
        }
        
        return lists[0];
        
    }
}




/*
Approach 2: Using Min Heap. Maintain a priority Queue of size k where k is no of lists. 
Pop out the top element and add the next element of the pooped out list.
Time complexity : O(N\log k)O(Nlogk) where \text{k}k is the number of linked lists.

The comparison cost will be reduced to O(\log k)O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1)O(1) time.
There are NN nodes in the final linked list.
Space complexity :

O(n)O(n) Creating a new linked list costs O(n)O(n) space.
O(k)O(k) The code above present applies in-place method which cost O(1)O(1) space. And the priority queue (often implemented with heaps) costs O(k)O(k) space (it's far less than NN in most situations). 

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0)
            return null; 
        
        int l = lists.length-1;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val-b.val;
            }
        });
        
        for(ListNode ll : lists){
            if(ll !=null)
                pq.offer(ll);
        }
        
        ListNode head = null;
        ListNode curr = null;
        
        while(!pq.isEmpty()){
            ListNode top = pq.peek();
            pq.remove();
            
            if(head == null){
                head = top;
                curr = top;
            }
            else{
                curr.next = top;
                curr = curr.next;
            }
            
            if(top.next !=null)
                pq.offer(top.next);
            
        }
        
        return head;
    }
}