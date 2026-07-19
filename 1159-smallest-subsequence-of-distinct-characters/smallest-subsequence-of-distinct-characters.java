class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        boolean[] seen = new boolean[26];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (seen[ch - 'a']) continue;
            while (st.size() > 0 && st.peek() > ch && lastIndex[st.peek() - 'a'] > i) {
                char top = st.pop();
                seen[top - 'a'] = false; 
            }
            st.push(ch);
            seen[ch - 'a'] = true;
        }
        StringBuilder ans = new StringBuilder();
        while (st.size() > 0) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}