/*Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

*/

//Approach 1: Using Stack
class Solution {
    static public String validate(String S){
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == '#'){
                if(stack.empty())
                    continue;
                else
                    stack.pop();
            }
            else{
                stack.push(S.charAt(i));
            }
        }
        
        StringBuffer sb= new StringBuffer();
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    
    public boolean backspaceCompare(String S, String T) {
        return(validate(S).equals(validate(T)));
        
    }
}

//Approach 2: using 2 pointers best approach

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}