/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
*/
//Approach 1: Create a Character Array Count and check for first occurence

class Solution {
    public int firstUniqChar(String s) {
       int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}


//Approach 2: Iterate the HashMap not efficient
class Solution {
    public int firstUniqChar(String s) {
        if(s.length()==0)
            return -1;
        Map<Character,Integer> m = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            if(m.containsKey(s.charAt(i)))
                m.put(s.charAt(i),-1);
            else
                m.put(s.charAt(i),i);
        }
        
        int min = Integer.MAX_VALUE;
        Iterator it = m.entrySet().iterator(); // iterator to traverse
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            if((Integer)pair.getValue() != -1 && (Integer)pair.getValue() < min)
                min = (Integer)pair.getValue();
        }
        
        if(min == Integer.MAX_VALUE)
            return -1;
        return min;
        
        
    }
}