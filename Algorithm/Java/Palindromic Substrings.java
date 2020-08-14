public class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int rst = 0;
        for(int i = 0; i < s.length(); ++i) {
            rst += helper(s, i, i) + helper(s, i, i + 1); 
        }
        return rst;
    }
    private int helper(String s, int left, int right) {
        int rst = 0;
        while(left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)){
            rst++;
        }
        return rst;
    }
}