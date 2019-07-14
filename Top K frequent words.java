/*
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
    */

class Solution{
    
    public List<String> topKFrequent(String[] words, int k) {
            Map<String,Integer> ctr = new HashMap<>();
            for(String word:words){
                if(ctr.containsKey(word))
                    ctr.put(word,ctr.get(word)+1);
                else
                    ctr.put(word,1);
            }
            
            PriorityQueue<String> pq = new PriorityQueue<String>(
                (w1,w2) -> ctr.get(w1).equals(ctr.get(w2))? 
                w1.compareTo(w2) : ctr.get(w2) - ctr.get(w1));
        
            for(String word: ctr.keySet()){
                pq.add(word);
                
            }
            List<String> ans = new ArrayList<>();
            
            int i=0;
            while(i<k){
                ans.add(pq.poll());
                i++;
            }
            
            return ans;
            
        
    }
}