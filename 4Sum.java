class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        int pos1=0;
        int pos2 = nums.length-1;
        Set<List<Integer>> se = new HashSet<>();
        while(pos1<nums.length-3){
            //System.out.println(nums[pos1]);
            pos2=nums.length-1;
            while(pos2 > pos1+2){
            int sum = nums[pos1]+ nums[pos2];
            int i= pos1+1;
            int j = pos2-1;
            while(i<j){
                if(nums[i]+nums[j]+sum == target){
                    List<Integer> l =new ArrayList<>();
                    l.add(nums[pos1]);
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[pos2]);
                    se.add(l);
                    i++;
                    j--;
                }
                else if(nums[i]+nums[j]+sum < target)
                    i++;
                else
                    j--;
                    
            }
                
            
          pos2--;  
            
        }
            pos1++;
    }
    Iterator<List<Integer>> itr = se.iterator(); 
        while(itr.hasNext()){
            ans.add(itr.next());
        }
        return ans;
}
}