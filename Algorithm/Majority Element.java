public class Solution {
    public int majorityElement(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int count = 0;
        int candidate = 0;
        for (int i : num) {
            if (count == 0) {
                candidate = i;
                count = 1;
            } else if (i == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}