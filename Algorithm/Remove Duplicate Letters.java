class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean[] isused = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            count[c]--;
            char tail = sb.length() == 0 ? ' ' : sb.charAt(sb.length() - 1);
            if (isused[c]) {
                continue;
            }
            while (sb.length() != 0 && tail > c && count[tail] > 0) {
                sb.deleteCharAt(sb.length() - 1);
                isused[tail] = false;
                if (sb.length() == 0) {
                    break;
                }
                tail = sb.charAt(sb.length() - 1);
            }
            sb.append(c);
            isused[c] = true;
        }
        return sb.toString();
    }
}