class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=nums[0];i<nums[nums.length-1];i++){
            if(!map.containsKey(i))ans.add(i);
        } 
        return ans;
    }
}