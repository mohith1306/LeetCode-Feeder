class Solution {
    public String smallestPalindrome(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder left = new StringBuilder();
        String mid = "";
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            if (freq % 2 != 0) {
                if (mid.equals("") || ch < mid.charAt(0)) {
                    mid = Character.toString(ch);
                }
            }
            for (int i = 0; i < freq / 2; i++) {
                left.append(ch);
            }
        }
        StringBuilder right = new StringBuilder(left).reverse();
        return left.toString() + mid + right.toString();
    }
}
