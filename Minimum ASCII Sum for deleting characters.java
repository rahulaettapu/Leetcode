/*Approach 
When one of the input strings is empty, the answer is the ASCII-sum of the other string. We can calculate this cumulatively using code like dp[i][s2.length()] = dp[i+1][s2.length()] + s1.codePointAt(i).
*/


class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];
		dp[0][0] = 0;
		
		for(int i = 1; i <= m; i++){
			dp[i][0] = dp[i-1][0] + (int)s1.charAt(i-1);
		}
		for(int j = 1; j <= n; j++){
			dp[0][j] = dp[0][j-1] + (int)s2.charAt(j-1);
		}
		
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = Math.min(dp[i][j-1] + (int)s2.charAt(j-1), dp[i-1][j] + (int)s1.charAt(i-1));
			}
		}
		return dp[m][n];
    }
}