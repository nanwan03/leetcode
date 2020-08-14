public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int left = 0;
        int right = num.length - 1;
        while (left + 1 < right && num[left] >= num[right]) {
            int mid = left + (right - left) / 2;
            if (num[left] < num[mid]) {
                left = mid + 1;
            } else if (num[left] > num[mid]) {
                right = mid;
            } else if (num[mid] != num[right]) {
                left = mid;
            } else {
                left++;
            }
        }
        return Math.min(num[left], num[right]);
    }
}