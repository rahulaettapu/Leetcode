/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    */



class Solution {
    public int titleToNumber(String s) {
         int ans = 0;
        char[] c = s.toCharArray();
        for (int i=0; i<s.length(); i++) {
            ans += (int)Math.pow(26, s.length()-1-i) * (c[i] - 'A' + 1);
        }
        return ans;
    }
}