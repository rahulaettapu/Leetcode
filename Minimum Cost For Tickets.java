/*In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:

a 1-day pass is sold for costs[0] dollars;
a 7-day pass is sold for costs[1] dollars;
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.


Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.

*/

/* Approach taken up from https://leetcode.com/problems/minimum-cost-for-tickets/discuss/227130/Java-DP-Solution-with-detailed-comment-and-explanation

*/






class Solution {
    public int mincostTickets(int[] days, int[] costs) {
    // length up to the last travel + 1 day is good enough (no need for 365)
    int lastDay = days[days.length - 1]; 
    // dp[i] means up to i-th day the minimum cost of the tickets
    int[] dp = new int[lastDay + 1]; 
    boolean[] isTravelDays = new boolean[lastDay + 1];
    // mark the travel days
    for(int day : days) isTravelDays[day] = true;
    
    for(int i = 1; i <= lastDay; i++) {
        if(!isTravelDays[i]) { // no need to buy ticket if it is not a travel day
            dp[i] = dp[i - 1];
            continue;
        }
        // select which type of ticket to buy
        dp[i] = costs[0] + dp[i - 1]; // 1-day
        dp[i] = Math.min(costs[1] + dp[Math.max(i - 7, 0)], dp[i]); // 7-day
        dp[i] = Math.min(costs[2] + dp[Math.max(i - 30, 0)], dp[i]); // 30-day
    }
    return dp[lastDay];
}
}