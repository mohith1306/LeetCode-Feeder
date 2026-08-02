class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0,j=0;
        int maxfreq=0,ans=0;
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            maxfreq=Math.max(maxfreq,map.get(s.charAt(j)));
            while((j-i+1)-maxfreq>k){
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0)map.remove(left);
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}