public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); ++i) {
            char sC = s.charAt(i);
            char tC = t.charAt(i);
            if (!map.containsKey(sC)) {
                if (map.containsValue(tC)) {
                    return false;
                }
                map.put(sC, tC);
            } else {
                if (map.get(sC) != tC) {
                    return false;
                }
            }
        }
        return true;
    }
}