class Solution {
    public long slidingwindow(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int low = 0;
        // int maxFreq = Integer.MIN_VALUE;
        long count = 0;
        for (int high = 0; high < nums.length; high++) {
            map.put(nums[high], map.getOrDefault(nums[high], 0) + 1);
            while (map.get(nums[high]) > k) {
                map.put(nums[low], map.get(nums[low]) - 1);
                low++;
            }
            count = Math.max(count, high - low + 1);
        }
        return count;
    }
    public int maxSubarrayLength(int[] nums, int k) {
        return (int)(slidingwindow(nums, k));
    }
}