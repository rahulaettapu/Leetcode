/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9
*/

/*
    dp[n] indicates that the perfect squares count of the given n, and we have:
     dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0
    
    dp[0] = 0 
    dp[1] = 1
    dp[2] = dp[1]+1 = 2
    dp[3] = dp[2]+1 = 3
    dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } 
          = Min{ dp[3]+1, dp[0]+1 } 
          = 1				
                            .
                            .
                            .
    dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
           = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
           = 2
                          
   
*/

class Solution {
    public int numSquares(int n) {
        int []dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2;i<=n;i++){
            int j =1;
            int min = Integer.MAX_VALUE;
            while(i - j*j >=0){
                min = Math.min(min, dp[i-j*j]+1);
                j++;
            }
            dp[i] = min;
        }
        
        return dp[n];
    }
}