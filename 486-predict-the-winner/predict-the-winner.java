class Solution {
    int[][] dp;
    public int memo(int[] nums, int i, int j) {
        if (i == j)
            return nums[i];
        if (dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];
        int left = nums[i] - memo(nums, i + 1, j);
        int right = nums[j] - memo(nums, i, j - 1);
        return dp[i][j] = Math.max(left, right);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MIN_VALUE);
        return memo(nums, 0, n - 1) >= 0;
    }
}