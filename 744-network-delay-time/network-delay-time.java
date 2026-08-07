class Solution {
    class Pair{
        int to,time;
        Pair(int to,int time){
            this.to=to;
            this.time=time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time: times){
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->a.time-b.time
        );
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.add(new Pair(k,0));
        dist[k]=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            for(int[] nei:adj.get(p.to)){
                int to=nei[0];
                int time=nei[1];
                if(dist[to]>time+p.time){
                    dist[to]=time+p.time;
                    pq.add(new Pair(to,time+p.time));
                }
            }
        }
        for(int i=1;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    } 
}
