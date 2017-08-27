class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 0;
        int right = m * n + 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isValid(mid, m, n, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return isValid(left, m, n, k) ? left : right;
    }
    private boolean isValid(int target, int m, int n, int k) {
        int rst = 0;
        for (int i = 1; i <= m; ++i) {
            rst += Math.min(target / i, n);
        }
        return rst >= k;
    }
}