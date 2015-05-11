public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        String str = replace(s, t);
        return s.equals(str);
    }
    private String replace(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                if (!set.add(s.charAt(i))) {
                    return "";
                }
                map.put(t.charAt(i), s.charAt(i));
            }
            sb.append(map.get(t.charAt(i)));
        }
        return sb.toString();
    }
}