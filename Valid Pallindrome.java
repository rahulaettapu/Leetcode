/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true*/

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","");
        s = s.toLowerCase();
        //System.out.println(s);
        int n = s.length();
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(n-i-1))
                return false;
        }
        
        return true;
    }
}