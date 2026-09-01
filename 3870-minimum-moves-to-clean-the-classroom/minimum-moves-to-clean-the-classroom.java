class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int startR = -1, startC = -1;
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }
        int litterCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startR = i;
                    startC = j;
                } else if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }
        if (litterCount == 0) return 0;
        int fullMask = (1 << litterCount) - 1;
        int[][][] maxEnergy = new int[m][n][1 << litterCount];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR, startC, 0, energy});
        maxEnergy[startR][startC][0] = energy;
        int moves = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int e = curr[3];
                if (mask == fullMask) {
                    return moves;
                }
                if (e == 0) continue;
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    char cell = classroom[nr].charAt(nc);
                    if (cell == 'X') continue;
                    int nmask = mask;
                    if (cell == 'L' && litterId[nr][nc] != -1) {
                        nmask |= (1 << litterId[nr][nc]);
                    }
                    int ne = e - 1;
                    if (cell == 'R') {
                        ne = energy;
                    }
                    if (ne > maxEnergy[nr][nc][nmask]) {
                        maxEnergy[nr][nc][nmask] = ne;
                        queue.offer(new int[]{nr, nc, nmask, ne});
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
}