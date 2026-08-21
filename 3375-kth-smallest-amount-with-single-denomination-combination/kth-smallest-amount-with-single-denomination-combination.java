class Solution {
    public boolean check(int[] coins, int k, long x) {
        int n = coins.length;
        long cnt = 0;

        for(int msk = 1; msk < (1 << n); msk++) {
            long l = 1;
            int bit = 0;

            for(int i = 0; i < n; i++) {
                if((msk & (1 << i)) != 0) {
                    l = lcm(l, coins[i]);
                    bit++;

                    if(l > x)
                        break;
                }
            }

            if(l > x)
                continue;

            if(bit % 2 == 1) {
                cnt += x / l;
            }
            else {
                cnt -= x / l;
            }
        }
        return cnt >= k;
    }
    public long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    public long gcd(long a, long b) {
        while(b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        long low = 1;
        long high = 1L * coins[0] * k;
        for(int x : coins) {
            high = Math.min(high, 1L * x * k);
        }
        long ans = high;
        while(low <= high) {
            long mid = low + (high - low) / 2;
            if(check(coins, k, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}