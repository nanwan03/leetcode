public class Solution {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String rst = "";
        for (String str : d) {
            int index = 0;
            for (char c : s.toCharArray()) {
                if (index < str.length() && c == str.charAt(index)) {
                    index++;
                }
            }
            if (index == str.length()) {
                if (str.length() > rst.length() || (str.length() == rst.length() && str.compareTo(rst) < 0)) {
                    rst = str;
                }
            }
        }
        return rst;
    }
}