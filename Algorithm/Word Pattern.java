public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map id = new HashMap();
        for (int i=0; i<words.length; ++i)
            if (!Objects.equals(id.putIfAbsent(pattern.charAt(i), i),
                                id.putIfAbsent(words[i], i)))
                return false;
        return true;
    }
}