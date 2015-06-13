public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        char[] s = haystack.toCharArray();
        char[] t = needle.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = getNext(needle);
        while (i < s.length && j < t.length) {
            if (j == -1 || s[i] == t[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == t.length) {
            return i - j;
        }
        return -1;
    }
    private int[] getNext(String target) {
        char[] t = target.toCharArray();
        int[] next = new int[t.length];
        if (t.length == 0) {
            return next;
        }
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < t.length - 1) {
            if (k == -1 || t[j] == t[k]) {
                j++;
                k++;
                if (t[j] != t[k]) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }
}