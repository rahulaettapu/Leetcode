/*Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
*/



/* Approach 1: Using Priority Queue
You can solve this problem in O(k log n) time by merging the rows incrementally, augmented with a heap to efficiently find the minimum element.

Basically, you put the elements of the first column into a heap and track the row they came from. At each step, you remove the minimum element from the heap and push the next element from the row it came from (if you reach the end of the row, then you don't push anything). Both removing the minimum and adding a new element cost O(log n). At the jth step, you remove the jth smallest element, so after k steps you are done for a total cost of O(k log n) operations (where n is the number of rows in the matrix).
*/




class Solution {
    class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int i = 0; i < n; i++)
            pq.add(new Tuple(i, 0, matrix[i][0]));
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.y == n-1) 
                continue;
            pq.add(new Tuple(t.x, t.y+1, matrix[t.x][t.y+1]));
        }
        return pq.poll().val;
    }
}