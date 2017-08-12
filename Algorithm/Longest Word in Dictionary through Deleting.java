public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String rst = "";
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i)) {
                    i++;
                }
            }
            if (i == dictWord.length() && dictWord.length() >= rst.length()) {
                if (dictWord.length() > rst.length() || dictWord.compareTo(rst) < 0) {
                    rst = dictWord;
                }
            }
        }
        return rst;
    }
}