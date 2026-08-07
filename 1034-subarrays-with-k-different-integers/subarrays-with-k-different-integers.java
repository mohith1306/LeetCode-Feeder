class Solution {
    public int slidingwindow(int[] nums,int k){
        int low=0,high=0,cnt=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(high=0;high<nums.length;high++){
            map.put(nums[high],map.getOrDefault(nums[high],0)+1);
            while(map.size()>k&&low<=high){
                map.put(nums[low],map.get(nums[low])-1);
                if(map.get(nums[low])==0)map.remove(nums[low]);
                low++;
            }
            cnt+=high-low+1;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingwindow(nums,k)-slidingwindow(nums,k-1);
    }
}