class Solution {
    public int countBinarySubstrings(String s) {
        int[] cnt = new int[2];
        int index = 0;        
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (0 < i && s.charAt(i - 1) != s.charAt(i)) {
                index ^= 1;
                cnt[index] = 0;
            }
            cnt[index]++;
            if (cnt[index] <= cnt[index ^ 1]) ans++;
        }
        return ans;
    }
}