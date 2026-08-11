class Solution{
    public double frogPosition(int n, int[][] edges, int t, int target) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return dfs(adj, 1, target, t, 1.0, 0);
    }
    private double dfs(ArrayList<ArrayList<Integer>> adj,int node,int target,int t,double probability,int parent
    ) {
        int children = 0;
        for (int next : adj.get(node)) {
            if (next != parent) {
                children++;
            }
        }
        if (node == target) {
            if (t == 0 || children == 0) {
                return probability;
            }
            return 0.0;
        }
        if (t == 0) {
            return 0.0;
        }
        for (int next : adj.get(node)) {
            if (next == parent) {
                continue;
            }
            double result = dfs(adj,next,target,t-1,probability / children,node);
            if (result > 0) {
                return result;
            }
        }
        return 0.0;
    }
}