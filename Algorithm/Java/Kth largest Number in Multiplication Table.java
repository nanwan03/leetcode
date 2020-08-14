class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isValid(m, n, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return isValid(m, n, k, left) ? left : right;
    }
    private boolean isValid(int m, int n, int k, int value) {
        int rst = 0;
        for (int i = 1; i <= m; ++i) {
            rst += Math.min(n, value / i);
        }
        return rst >= k;
    }
}