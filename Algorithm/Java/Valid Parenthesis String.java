class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int minL = 0;
        int maxL = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minL++;
                maxL++;
            } else if (c == ')') {
                minL = --minL <= 0 ? 0 : minL;
                maxL--;
            } else {
                minL = --minL <= 0 ? 0 : minL;
                maxL++;
            }
            if (maxL < 0) {
                return false;
            }
        }
        return minL == 0;
    }
}