public class Solution {
    public int singleNumber(int[] A) {
        int xor = 0;
        for (int i : A) {
            xor ^= i;
        }
        return xor;
    }
}