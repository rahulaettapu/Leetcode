/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
*/



class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        
        
        int l = s.length();
        if(l==0)
            return true;
        
        for(int i = 0; i < l; i++){ 
            if(map1[s.charAt(i) ] == 0 && map2[t.charAt(i)] == 0) {
                map1[s.charAt(i)] = t.charAt(i);
                map2[t.charAt(i)] = s.charAt(i);
            } else {
                if(map1[s.charAt(i)] != t.charAt(i) || 
                  map2[t.charAt(i)] != s.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
            
    }
}