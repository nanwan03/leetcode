public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] rst = new int[2];
        if (nums == null || nums.length == 0) {
            return rst;
        }
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        int mask = xor & ~(xor - 1);
        int xorA = 0;
        int xorB = 0;
        for (int i : nums) {
            if ((mask & i) == 0) {
                xorA ^= i;
            } else {
                xorB ^= i;
            }
        }
        rst[0] = Math.min(xorA, xorB);
        rst[1] = Math.max(xorA, xorB);
        return rst;
    }
}