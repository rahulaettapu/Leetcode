
/*Approach 1: Find the row where you can find the target. Then do Binary Search on the row. O(m+logn) */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0)
            return false;
        int n = matrix[0].length;
        
        if(m*n==0)
            return false;
        int row = -1;
        
        for(int i=0;i<m;i++){
            if(matrix[i][n-1] == target)
                return true;
            else if(matrix[i][n-1] > target){
                row = i;
                break;
            }
            else
                continue;
        }
        
        if(row ==-1)
            return false;
        
        int start = 0;
        int end = n-1;
        while(start <= end){
            int mid = start+(end-start)/2;
            //System.out.println(row);
            if(matrix[row][mid] < target)
                start = mid+1;
            else if(matrix[row][mid] > target)
                end = mid -1;
            else
                return true;
        }
        
        return false;
        
        
    }
}


/* Approach 2: Binary Serach on the m*n elements considering them as single row. matrix[mid/n][mid%n] correspond to the element to be searched and decided.(Check out via examples)*/
// O(log mn)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
    if (m == 0) return false;
    int n = matrix[0].length;

    // binary search
    int left = 0, right = m * n - 1;
    int pivotIdx, pivotElement;
    while (left <= right) {
      pivotIdx = (left + right) / 2;
      pivotElement = matrix[pivotIdx / n][pivotIdx % n];
      if (target == pivotElement) return true;
      else {
        if (target < pivotElement) right = pivotIdx - 1;
        else left = pivotIdx + 1;
      }
    }
    return false;
        
    }
}