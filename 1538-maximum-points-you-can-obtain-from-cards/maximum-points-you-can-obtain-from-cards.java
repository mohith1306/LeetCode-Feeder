class Solution {
    public int maxScore(int[] cardPoints, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<cardPoints.length;i++){
            ans.add(cardPoints[i]);
        }
        for(int i=0;i<cardPoints.length;i++){
            ans.add(cardPoints[i]);
        }
        int low=cardPoints.length-k;
        int high=cardPoints.length;
        int res=0;
        for(int i=low;i<low+k;i++){
            res+=ans.get(i);
        }
        int temp=res;
        for(int i=low+1;i<=high;i++){
            temp-=ans.get(i-1);
            temp+=ans.get(i+k-1);
            res=Math.max(temp,res);
        }
        return res;
    }
}