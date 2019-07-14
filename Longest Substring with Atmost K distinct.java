/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
*/

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length()==0 || k==0)
            return 0;
        int l = 0;
        int r =0;
        Map<Character,Integer> m = new HashMap<>();
        
        int max =1;
        
        while(r<s.length()){
            m.put(s.charAt(r),r++);
            if(m.size()==k+1){
                int idx = Collections.min(m.values());
                m.remove(s.charAt(idx));
                l = idx+1;
            }
            max = Math.max(max,r-l);
        }
        return max;
    }
}