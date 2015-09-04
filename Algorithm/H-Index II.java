public class Solution {
    public int hIndex(int[] citations) {
        int[] a = citations;
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int length = a.length;
        int left = 0;
        int right = a.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > length - mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (a[left] >= length - left) {
            return length - left;
        } else if (a[right] >= length - right) {
            return length - right;
        } else {
            return length - (right + 1);
        }
    }
}