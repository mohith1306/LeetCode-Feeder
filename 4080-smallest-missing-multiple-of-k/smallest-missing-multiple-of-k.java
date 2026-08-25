class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        boolean found=false;
        int i=1;
        int res=-1;
        while(!found){
            if(!map.containsKey(k*i)){found=true;res=k*i;}
            i++;
        }
        return res;
    }
}