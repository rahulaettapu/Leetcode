/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.*/


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int num : nums)
            pq.add(num);
        int i=0;
        while(i<k-1){
            pq.poll();
            i++;
        }
        return pq.poll();
    }
}