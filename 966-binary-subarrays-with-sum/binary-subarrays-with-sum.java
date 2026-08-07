class Solution {
    public int slidingwindow(int[] nums,int goal){
        int low=0,high=0,ans=0,sum=0;
        for(high=0;high<nums.length;high++){
            sum+=nums[high];
            while(sum>goal&&low<=high){
                sum-=nums[low];
                low++;
            }
            ans=ans+high-low+1;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingwindow(nums,goal)-slidingwindow(nums,goal-1);
    }
}