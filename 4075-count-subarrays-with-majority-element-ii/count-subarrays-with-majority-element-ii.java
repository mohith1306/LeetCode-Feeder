class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        TreeMap<Long, Long> freq = new TreeMap<>();
        long sum = 0;
        long tillThisPoint = 0;
        long ans = 0;
        freq.put(0L, 1L);
        for(int x:nums){
            if(x==target){
                tillThisPoint += freq.getOrDefault(sum, 0L);
                sum++;
            }
            else{
                sum--;
                tillThisPoint -= freq.getOrDefault(sum, 0L);
            }
            freq.put(sum, freq.getOrDefault(sum, 0L) + 1);
            ans += tillThisPoint;
        }
        return ans;
    }
}