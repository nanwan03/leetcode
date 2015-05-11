public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        int start = -1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (map.containsKey(c)) {
        		start = Math.max(start, map.get(c));
        	}
        	map.put(c, i);
        	max = Math.max(max, i - start);
        }
        return max;
    }
}