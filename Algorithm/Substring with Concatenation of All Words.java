public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> rst = new ArrayList<Integer>();
        if (S == null || S.length() == 0 || L == null || L.length == 0) {
        	return rst;
        }
        Map<String, Integer> total = new HashMap<String, Integer>();
        Map<String, Integer> found = new HashMap<String, Integer>();
        for (String str : L) {
        	if (!total.containsKey(str)) {
        		total.put(str, 1);
        	} else {
        		total.put(str, total.get(str) + 1);
        	}
        }
        int arrSize = L.length;
        int strSize = L[0].length();
        for (int i = 0; i <= S.length() - arrSize * strSize; i++) {
        	found.clear();
        	int j = 0;
        	for (j = 0; j < arrSize; j++) {
        		int k = i + j * strSize;
        		String str = S.substring(k, k + strSize);
        		if (!total.containsKey(str)) {
        			break;
        		}
        		if (!found.containsKey(str)) {
        			found.put(str, 1);
        		} else {
        			found.put(str, found.get(str) + 1);
        		}
        		if (found.get(str) > total.get(str)) {
        			break;
        		}
        	}
        	if (j == arrSize) {
        		rst.add(i);
        	}
        }
        return rst;
    }
}