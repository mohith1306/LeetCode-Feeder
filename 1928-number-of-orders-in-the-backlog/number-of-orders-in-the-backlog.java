class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        int MOD = 1_000_000_007;
        PriorityQueue<int[]> buyBacklog =
            new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        PriorityQueue<int[]> sellBacklog =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int type = order[2];
            if (type == 0) {
                while (amount > 0 &&
                       !sellBacklog.isEmpty() &&
                       sellBacklog.peek()[0] <= price) {

                    int[] sell = sellBacklog.peek();

                    int trade = Math.min(amount, sell[1]);

                    amount -= trade;
                    sell[1] -= trade;

                    if (sell[1] == 0) {
                        sellBacklog.poll();
                    }
                }
                if (amount > 0) {
                    buyBacklog.add(new int[]{price, amount});
                }

            } 
            else{
                while (amount > 0 &&
                       !buyBacklog.isEmpty() &&
                       buyBacklog.peek()[0] >= price) {
                    int[] buy = buyBacklog.peek();
                    int trade = Math.min(amount, buy[1]);
                    amount -= trade;
                    buy[1] -= trade;
                    if (buy[1] == 0) {
                        buyBacklog.poll();
                    }
                }
                if (amount > 0) {
                    sellBacklog.add(new int[]{price, amount});
                }
            }
        }
        long result = 0;
        for (int[] buy : buyBacklog) {
            result += buy[1];
            result %= MOD;
        }
        for (int[] sell : sellBacklog) {
            result += sell[1];
            result %= MOD;
        }
        return (int) result;
    }
}