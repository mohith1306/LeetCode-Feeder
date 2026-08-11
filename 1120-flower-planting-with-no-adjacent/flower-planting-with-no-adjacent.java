class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] flowers = new int[n + 1];
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lst.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            lst.get(path[0]).add(path[1]);
            lst.get(path[1]).add(path[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (flowers[i] == 0) {
                dfs(i, lst, flowers);
            }
        }
        int[] ans = new int[n];
        for (int i = 1; i <= n; i++) {
            ans[i - 1] = flowers[i];
        }
        return ans;
    }
    public void dfs(int node, ArrayList<ArrayList<Integer>> lst, int[] flowers) {
        boolean[] used = new boolean[5];
        for (int neighbor : lst.get(node)) {
            if (flowers[neighbor] != 0) {
                used[flowers[neighbor]] = true;
            }
        }
        for (int flower = 1; flower <= 4; flower++) {
            if (!used[flower]) {
                flowers[node] = flower;
                break;
            }
        }
        for (int neighbor : lst.get(node)) {
            if (flowers[neighbor] == 0) {
                dfs(neighbor, lst, flowers);
            }
        }
    }
}