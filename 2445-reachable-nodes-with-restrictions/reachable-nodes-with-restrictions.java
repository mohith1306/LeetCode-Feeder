class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>> lst=new ArrayList<>();
        for(int i=0;i<n;i++){
            lst.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[i].length;j++){
                int u = edges[i][0];
                int v = edges[i][1];
                lst.get(u).add(v);
                lst.get(v).add(u);
            }
        }
        int[] visited=new int[n];
        boolean[] restr=new boolean[n];
        for(int res:restricted)restr[res]=true;
        Arrays.fill(visited,Integer.MAX_VALUE);
        dfs(visited,restr,lst,0);
        int cnt=0;
        for(int v:visited){
            if(v!=Integer.MAX_VALUE)cnt++;
        }
        return cnt;
    }
    public void dfs(int[] visited, boolean[] restr, ArrayList<ArrayList<Integer>> lst, int j){
        visited[j]=1;
        for(int i=0;i<lst.get(j).size();i++){
            if(visited[lst.get(j).get(i)]==Integer.MAX_VALUE && !restr[lst.get(j).get(i)]){
                    int neighbor = lst.get(j).get(i);
                    dfs(visited, restr, lst, neighbor);
            }
        }
    }
}