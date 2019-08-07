/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
*/


class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> m = new HashMap<>();
        Map<String,Character> m1 = new HashMap<>();
        
        String[] s = str.split(" ");
        int l = pattern.length();
        if(s.length != l)
            return false;
        
        for(int i=0;i<l;i++){
            if(!m.containsKey(pattern.charAt(i)) && !m1.containsKey(s[i]) ){
                m.put(pattern.charAt(i),s[i]);
                m1.put(s[i],pattern.charAt(i));
            }
            else if(!m.containsKey(pattern.charAt(i)) && m1.containsKey(s[i]) ||
                   m.containsKey(pattern.charAt(i)) && !m1.containsKey(s[i]) )
                return false;
            
            else {
                if(!(m.get(pattern.charAt(i)).equals(s[i])) ||
                   !(m1.get(s[i]).equals(pattern.charAt(i)))
                  )
                    return false;
            }
        }
        return true;
        
    }
}