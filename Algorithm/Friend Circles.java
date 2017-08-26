class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < M.length; ++i) {
            for (int j = i; j < M.length; ++j) {
                if (M[i][j] == 1) {
                    count++;
                    mark(M, j);
                }
            }
        }
        return count;
    }
    private void mark(int[][] M, int next) {
        for (int i = 0; i < M.length; ++i) {
            if (M[next][i] == 1) {
                M[next][i] = 0;
                mark(M, i);
            }
        }
    }
}