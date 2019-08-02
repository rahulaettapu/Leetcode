/*Approach : Using Fisher Yates Algorithm. Random provides a random number in O(1) time. Generate a random number between 0<=j<=i. */



class Solution {
   private int[] array;
    private int[] orig;
    
    public Solution(int[] nums) {
        array = nums;
        orig = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = orig;
        orig = orig.clone();
        return orig;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random r = new Random();
        for(int i=array.length-1;i>=0;i--){
            int j = r.nextInt(i+1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}
