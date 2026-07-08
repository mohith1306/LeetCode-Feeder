class Solution {
    long MOD = 1_000_000_007; 
    private void processPow10(long[] pow, int m) {
        pow[0] = 1; 
        for(int i = 0; i < m; i++) {
            pow[i + 1] = (pow[i] * 10) % MOD; 
        }
    }
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length(); 
        long prefDigitSum[] = new long[m + 1]; 
        long prefNum[] = new long[m + 1]; 
        int prefCnt[] = new int[m + 1]; 
        long pow10[] = new long[m + 1]; 
        processPow10(pow10, m); 
        for(int i = 0; i < m; i++) {
            prefDigitSum[i + 1] = prefDigitSum[i]; 
            prefNum[i + 1] = prefNum[i]; 
            prefCnt[i + 1] = prefCnt[i]; 
            long cur = (long)(s.charAt(i) - '0'); 
            if(cur == 0) {
                continue; 
            }
            prefDigitSum[i + 1] = (prefDigitSum[i] + cur) % MOD; 
            prefNum[i + 1] = ((prefNum[i] * 10) % MOD + cur) % MOD; 
            prefCnt[i + 1] += 1; 
        }
        int[] ans = new int[queries.length]; 
        for(int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1]; 
            long sum = prefDigitSum[r + 1] - prefDigitSum[l]; 
            int cnt = prefCnt[r + 1] - prefCnt[l]; 
            long num = ((prefNum[r + 1] - (prefNum[l] * pow10[cnt]) % MOD) + MOD) % MOD; 
            ans[i] = (int)((sum * num) % MOD); 
        }
        return ans; 
    }
    private long pow(long x, int y) {
        if(y == 1) return x; 
        if(y == 0) return 1L; 
        long half = pow(x, y / 2); 
        long mul = (half * half)% MOD; 
        return (mul * (y % 2 == 0 ? 1L : x)) % MOD; 
    }
}