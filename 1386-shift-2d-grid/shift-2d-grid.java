class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int n = grid[0].length;
        int m = grid.length;
        int len = m * n;
        int idx = (len - k % len) % len;
        for (int i = 0; i < m; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                rowList.add(grid[idx / n][idx % n]);
                idx = (idx + 1) % len;
            }
            res.add(rowList);
        }
        return res;
    }
}