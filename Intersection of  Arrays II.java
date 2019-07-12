/*Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
*/

//Approach1 : 2-pointers concept 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> l = new ArrayList<>();
        //two pointers
        int i = 0;
        int j = 0;
        
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j])
                i++;
            else if(nums1[i] > nums2[j])
                j++;
            else{
                 l.add(nums1[i]);
                i++;
                j++;
               
            }
        }
        
        int []ans =new int[l.size()];
       for(int k=0;k<l.size();k++)
           ans[k] = l.get(k);
        
        return ans;
        
    }
}

//Approach 2 : Using HashMap . Problem arises when the length of nums1 < nums2
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> m = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        
        if(nums1.length >= nums2.length){
        for(int i =0 ;i<nums1.length;i++){
            if(m.containsKey(nums1[i]))
                m.put(nums1[i],m.get(nums1[i])+1);
            else
                m.put(nums1[i],1);
        }
        
        for(int i=0;i<nums2.length;i++){
            if(m.containsKey(nums2[i]) && m.get(nums2[i])>0){
                l.add(nums2[i]);
                 m.put(nums2[i],m.get(nums2[i])-1);
            }
        }
        }
        
        
        else
        {
             for(int i =0 ;i<nums2.length;i++){
            if(m.containsKey(nums2[i]))
                m.put(nums2[i],m.get(nums2[i])+1);
            else
                m.put(nums2[i],1);
        }
        
        for(int i=0;i<nums1.length;i++){
            if(m.containsKey(nums1[i]) && m.get(nums1[i])>0){
                l.add(nums1[i]);
                m.put(nums1[i],m.get(nums1[i])-1);
            }
        }       
        }
        
        int []ans =new int[l.size()];
       for(int i=0;i<l.size();i++)
           ans[i] = l.get(i);
        
        return ans;
        
    }
}

/*
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
 --   Use 2 pointers
 
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
  -- Using 2 pointers
  
  What if elements of nums2 are stored on disk, and the memory is
limited such that you cannot load all elements into the memory at
once?

		If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.

		 If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.
		 */