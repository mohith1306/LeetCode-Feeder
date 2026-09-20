class Solution {
    public int reverseDegree(String s) {
        int degree = 0;
        int index = 1;
        for(char ch:s.toCharArray()){
            degree = degree + (index * (26-(ch-'a')));
            index++;
        }
        return degree;
    }
}