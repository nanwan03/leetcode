public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> rst = new ArrayList<String>();
        if (s == null || s.length() == 0) {
        	return rst;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <= s.length() - 10; i++) {
        	String str = s.substring(i, i + 10);
        	int key = str2int(str);
        	if (!map.containsKey(key)) {
        		map.put(key, 1);
        	} else if (map.get(key) == 1) {
        		rst.add(str);
        		map.put(key, 2);
        	}
        }
        return rst;
    }
    private int str2int(String str) {
    	int rst = 0;
    	for (char c : str.toCharArray()) {
    		rst = (rst << 3) | (c & 7);
    	}
    	return rst;
    }
}