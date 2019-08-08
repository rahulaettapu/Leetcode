
/*Calculate the row count of each column once till you encounter a W. Repeat the same if you see a W. Similarly maintain a column count. */


class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid.length ==0 || grid[0].length ==0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int col_count[] = new int[n];
        int row_count =0;
        int max = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // check for the row count. count it once or after you see a W
                if(j==0 || grid[i][j-1] == 'W'){
                    row_count = 0;
                    for(int k=j;k<n && grid[i][k] !='W';k++){
                        if(grid[i][k] == 'E')
                            row_count++;
                    }
                }
                
                //Similarly do it for column count.
                if(i == 0 || grid[i-1][j] == 'W'){
                    col_count[j] = 0;
                    for(int k=i;k<m && grid[k][j] !='W';k++){
                        if(grid[k][j] == 'E')
                            col_count[j]++;
                    }
                    
                }
                
                if(grid[i][j] == '0'){
                    max = Math.max(max, row_count+col_count[j]);
                }
            }
            
        }
        
        return max;
    }
}