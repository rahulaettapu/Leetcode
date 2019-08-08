class Vector2D {
  //  List<Integer> list;
    int [][] vec;
    int row;
    int col;
    
    public Vector2D(int[][] v) {
        vec = v;
        row =0;
        col =0;
        
    }
    
    public int next() {
        int val = vec[row][col];
        col++;
        if(col >= vec[row].length){
            row++;
            col=0;
        }
        return val;
    }
    
    public boolean hasNext() {
       while (row < vec.length && (vec[row] == null || vec[row].length == 0)) {
                row++;
            }

            return vec != null && vec.length!=0 && row < vec.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */