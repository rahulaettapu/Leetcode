/*Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

 Approach 1: Calculate the 2 pointer positions
The idea behind this method is that the correct position of the minimum element in the unsorted subarray helps to determine the required left boundary. 
Similarly, the correct position of the maximum element in the unsorted subarray helps to determine the required right boundary.

Thus, firstly we need to determine when the correctly sorted array goes wrong. 
We keep a track of this by observing rising slope starting from the beginning of the array.
 Whenever the slope falls, we know that the unsorted array has surely started.
 Thus, now we determine the minimum element found till the end of the array numsnums, given by minmin.

Similarly, we scan the array numsnums in the reverse order and when the slope becomes rising instead of falling, we start looking for the maximum element till
 we reach the beginning of the array, given by maxmax.

Then, we traverse over numsnums and determine the correct position of minmin and maxmax by comparing these elements with the other array elements.
 e.g. To determine the correct position of minmin, we know the initial portion of numsnums is already sorted. 
 Thus, we need to find the first element which is just larger than minmin. Similarly, for maxmax's position, we need to find the first element which is just smaller than maxmax searching in numsnums backwards.
*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int l = nums.length;
        boolean flag = false;
        
        for(int i=1;i<l;i++){
            if(nums[i] < nums[i-1])
                flag = true;
            if(flag)
                min = Math.min(nums[i],min);
        }
        flag = false;
        
        for(int j=l-2;j>=0;j--){
            if(nums[j] > nums[j+1])
                flag =true;
            if(flag)
                max = Math.max(max,nums[j]);
        }
        
        int ptr1,ptr2;
        for(ptr1 =0; ptr1 < l;ptr1++){
            if(min < nums[ptr1])
                break;
        }
        for(ptr2 =l-1; ptr2 >=0 ;ptr2--){
            if(max > nums[ptr2])
                break;
        }
         return ptr2 - ptr1 < 0 ? 0 : ptr2 - ptr1 + 1;
        
       
    }
}


/* Approach 2: Use Sorting
But requires extra space*/