public class Solution {
    private class Cmp implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Cmp());
        int rst = 0;
        int dp[] = new int[envelopes.length];
        for(int[] envelope : envelopes){
            int index = search(dp, 0, rst, envelope[1]);
            dp[index] = envelope[1];
            if(index == rst) {
                rst++;
            }
        }
        return rst;
    }
    private int search(int[] A, int left, int right, int target) {
        if (right == 0) {
            return 0;
        }
        right = right - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[right] < target) {
            return right + 1;
        } else if (A[right] == target || A[left] < target) {
            return right;
        } else {
            return left;
        }
    }
}