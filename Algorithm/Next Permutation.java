public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        for (int i = num.length - 1; i >= 0; i--) {
            for (int j = num.length - 1; j > i; j--) {
                if (num[j] > num[i]) {
                    swap(num, i, j);
                    reverse(num, i + 1, num.length - 1);
                    return;
                }
            }
        }
        reverse(num, 0, num.length - 1);
    }
    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    private void reverse(int[] num, int left, int right) {
        while (left < right) {
            swap(num, left++, right--);
        }
    }
}