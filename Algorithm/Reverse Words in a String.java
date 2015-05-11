public class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        String trimedString = s.trim();
        if (trimedString.length() == 0 || trimedString.length() == 1) {
            return trimedString;
        }
        String reversedString = reverseString(trimedString);
        String[] words = reversedString.split("\\s+");
        String rst = words.length > 0 ? reverseString(words[0]) : "";
        for (int i = 1; i < words.length; i++) {
            rst = rst + " " + reverseString(words[i]);
        }
        return rst;
    }
    public String reverseString(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }
}