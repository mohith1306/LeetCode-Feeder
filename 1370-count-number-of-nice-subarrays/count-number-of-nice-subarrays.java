class Solution {
    public int slidingwindow(int[] nums,int k){
        int low=0,high=0,cnt=0,ans=0;
        for(high=0;high<nums.length;high++){
            if(nums[high]%2!=0)cnt++;
            while(cnt>k&&low<=high){
                if(nums[low]%2!=0)cnt--;
                low++;
            }
            ans=ans+high-low+1;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return slidingwindow(nums,k)-slidingwindow(nums,k-1);
    }
}