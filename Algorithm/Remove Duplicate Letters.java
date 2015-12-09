public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        boolean[] isCandidate = new boolean[26];
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            isCandidate[ch - 'a'] = true;
            if (--cnt[ch - 'a'] == 0) break;
        }
        for (int i = 0; i < 26; i++)
            if (isCandidate[i]) {
                char ch = (char) (i + 'a');
                for (int j = 0; j < s.length(); j++)
                    if (s.charAt(j) == ch) return ch + removeDuplicateLetters(s.substring(j + 1).replaceAll("" + ch, ""));
            }
        return "";
    }
}