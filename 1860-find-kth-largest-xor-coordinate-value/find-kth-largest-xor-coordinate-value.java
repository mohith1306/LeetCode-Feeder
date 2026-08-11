class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] xor = new int[m][n];
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                xor[i][j] = matrix[i][j];
                if (i > 0) {
                    xor[i][j] ^= xor[i - 1][j];
                }
                if (j > 0) {
                    xor[i][j] ^= xor[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    xor[i][j] ^= xor[i - 1][j - 1];
                }
                pq.add(xor[i][j]);
            }
        }
        while (k > 1) {
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}