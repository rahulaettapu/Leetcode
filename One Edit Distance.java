/* One Edit Distance */



class Solution {
    public boolean isOneEditDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        if(m>n)
            return isOneEditDistance(word2,word1);
        
        if(m-n>1)
            return false;
        
        for(int i=0;i<m;i++){
            if(word1.charAt(i) != word2.charAt(i)){
                if(m==n)
                    return word1.substring(i+1).equals(word2.substring(i+1));
                else
                    return word1.substring(i).equals(word2.substring(i+1));
            }
        }
        
        return (m+1 ==n);
    }
}