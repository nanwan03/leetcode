public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] counts = new int[256];
        boolean[] isVisited = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        for (char c : s.toCharArray()) {
            counts[c]--;
            if (isVisited[c] ||
                (sb.length() != 0 && sb.charAt(sb.length() - 1) == c)) {
                continue;
            }
            while ((sb.length() != 0 && sb.charAt(sb.length() - 1) > c) &&
                    counts[sb.charAt(sb.length() - 1)] > 0) {
                isVisited[sb.charAt(sb.length() - 1)] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            isVisited[c] = true;
        }
        return sb.toString();
    }
}