public class Solution {
    public int findPeakElement(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int left = 0;
        int right = num.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (num[mid - 1] < num[mid] && num[mid + 1] < num[mid]) {
                return mid;
            } else if (num[mid] < num[mid - 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return num[left] > num[right] ? left : right;
    }
}