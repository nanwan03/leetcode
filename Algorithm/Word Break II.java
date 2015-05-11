public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> rst = new ArrayList<String>();
        if (dict == null || dict.size() == 0) {
        	return rst;
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return helper(map, s, dict);
    }
    private List<String> helper(Map<String, List<String>> map, String s, Set<String> dict) {
    	if (map.containsKey(s)) {
    		return map.get(s);
    	}
    	List<String> rst = new ArrayList<String>();
    	for (int i = 0; i < s.length(); i++) {
    		String firstPart = s.substring(0, i + 1);
    		if (dict.contains(firstPart)) {
    			String secondPart = s.substring(i + 1);
    			if (secondPart.length() == 0) {
    				rst.add(firstPart);
    			} else {
    				List<String> items = helper(map, secondPart, dict);
    				for (String str : items) {
    					rst.add(firstPart+" "+str);
    				}
    			}
    		}
    	}
    	map.put(s, rst);
    	return rst;
    }
}