/*Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*/
 // Approach 1: sort and check
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length <= 1)
            return false;
            
         Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) return true;
        }
        
        return false;
        
    }
}

// Approach 2: Using HashMap

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length <= 1)
            return false;
            
        Map<Integer,Integer> m =new HashMap<>();
        m.put(nums[0],1);
        for(int i=1;i<nums.length;i++){
            if(m.containsKey(nums[i]))
                return true;
            else
                m.put(nums[i],1);
        }
        return false;
    }
}