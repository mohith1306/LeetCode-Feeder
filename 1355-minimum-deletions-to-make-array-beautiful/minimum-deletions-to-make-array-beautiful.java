class Solution {
    public int minDeletion(int[] nums) {
        int len=1;
        int cnt=0;
        int prev=nums[0];
        for(int i=1;i<nums.length;i++){
            if(len%2!=0){
                if(prev==nums[i]){
                    cnt++;
                    continue;
                }
                else{
                    len++;
                    prev=nums[i];
                }
            }
            else{
                len++;
                prev=nums[i];
            }
            // len++;
        }if(len%2==1)cnt++;
        return cnt;
    }
}