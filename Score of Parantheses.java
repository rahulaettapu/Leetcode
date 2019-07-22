/*Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
*/


//Approach 1: Counting the cores () in the string.The final sum will be a sum of powers of 2,
// as every core (a substring (), with score 1) will have it's score multiplied by 2 for each exterior set of parentheses that contains that core.
class Solution {
    public int scoreOfParentheses(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << bal;
                //System.out.println(ans);
            }
        }

        return ans;
    }
}

//Approach 2: Using Stack. Add level wise sum of the parantheses 
class Solution {
    public int scoreOfParentheses(String S) {
         Stack<Integer> stack = new Stack();
    stack.push(0); 

    for (char c: S.toCharArray()) {
        if (c == '(')
            stack.push(0);
        else {
            int v = stack.pop();
            int w = stack.pop();
            stack.push(w + Math.max(2 * v, 1));
        }
    }

    return stack.pop();
    }
}
