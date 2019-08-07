// 1 --> 0  -----> -1
// 0 --> 1  -----> 2

class Solution {
    
    public static int check(int count, Boolean b){
        int ans = 0;
        if(b == true){
            if(count < 2 || count > 3)
                return -1;
            else
                ans = 1;
        }
        else{
            if(count == 3)
                ans = 2;
            else
                ans = 0;
        }
        return ans;
    }
    
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int cnt =0;
                Boolean isLive = false;
                if(board[i][j] == 1)
                    isLive = true;
                
                if(j>0){
                    if(board[i][j-1] == 1 || board[i][j-1] == -1)
                        cnt++;
                }
                
                if(j<n-1){
                    if(board[i][j+1] == 1 || board[i][j+1] == -1)
                        cnt++;
                }
                
                if(i>0){
                    if(board[i-1][j] == 1 || board[i-1][j] == -1)
                        cnt++;
                }
                
                if(i<m-1){
                    if(board[i+1][j] == 1 || board[i+1][j] == -1)
                        cnt++;
                }
                
                if(i>0 && j>0){
                    if(board[i-1][j-1] == 1 || board[i-1][j-1] == -1)
                        cnt++;
                }
                
                if(i<m-1 && j<n-1){
                    if(board[i+1][j+1] == 1 || board[i+1][j+1] == -1)
                        cnt++;
                }
                
                if(i<m-1 && j>0){
                    if(board[i+1][j-1] == 1 || board[i+1][j-1] == -1)
                        cnt++;
                }
                
                if(i > 0 && j<n-1){
                    if(board[i-1][j+1] == 1 || board[i-1][j+1] == -1)
                        cnt++;
                }
                
                board[i][j] = check(cnt,isLive);
                
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] > 0)
                    board[i][j] =1;
                else
                    board[i][j] = 0;
            }
        }
        
    }
}