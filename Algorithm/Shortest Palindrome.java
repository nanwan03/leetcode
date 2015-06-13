public class Solution {
    public String shortestPalindrome(String s) {
        String result = "";
        if(s.length() == 0)
            return result;
        int[] next = new int[s.length() * 2 + 1];
        next[0] = -1;
        String mirror = s + new StringBuilder(s).reverse().toString();
        int j = 0;
        int k = -1;
        while (j < s.length() * 2) {
            if (k == -1 || mirror.charAt(j) == mirror.charAt(k)) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        int count = s.length() - next[s.length() * 2];
        result = new StringBuilder(s.substring(s.length()-count, s.length())).reverse().toString() + s;
        return result;
    }
}