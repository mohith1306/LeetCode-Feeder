class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());
        for(int freq : map.values()){
            pq.add(freq);
        }
        int time = 0;
        while(!pq.isEmpty()){
            ArrayList<Integer> lst = new ArrayList<>();
            int i = 0;
            int cycles = n + 1;
            while(i < cycles && !pq.isEmpty()){
                int cnt = pq.poll();
                cnt--;
                if(cnt > 0)
                    lst.add(cnt);
                time++;
                i++;
            }
            for(int rem : lst){
                pq.add(rem);
            }
            if(!pq.isEmpty())
                time += (cycles - i);
        }
        return time;
    }
}