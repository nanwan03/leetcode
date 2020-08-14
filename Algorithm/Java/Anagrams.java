public class Solution {
	private int hashCode(int[] count) {
		int rst = 0;
		for (int i : count) {
			rst = rst * 31 + i;
		}
		return rst;
	}
    public List<String> anagrams(String[] strs) {
        List<String> rst = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
        	return rst;
        }
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for (String str : strs) {
        	int[] count = new int[256];
        	for (char c : str.toCharArray()) {
        		count[c]++;
        	}
        	int hash = hashCode(count);
        	if (!map.containsKey(hash)) {
        		map.put(hash, new ArrayList<String>());
        	}
        	map.get(hash).add(str);
        }
        for (List<String> list : map.values()) {
        	if (list.size() > 1) {
        		rst.addAll(list);
        	}
        }
        return rst;
    }
}