/*Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
*/

/*Approach 1: Using HashSet
Maintain a hashset of size k everytime
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length <= 1)
            return false;
        
        int i=0; 
 
        Set<Integer> set = new HashSet<Integer>();
 
        for(int j=0; j<nums.length; j++){
            if(!set.add(nums[j])){
                return true;
            }            
 
            if(set.size()>=k+1){
                set.remove(nums[i++]);
            }
        }
 
        return false;
        
    }
}