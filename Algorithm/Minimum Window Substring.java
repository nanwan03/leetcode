public class Solution {
    public String minWindow(String S, String T) {
    	if (S == null || S.length() == 0 || T == null || T.length() == 0) {
    		return "";
    	}
    	int[] total = new int[256];
    	int[] found = new int[256];
    	for (int i = 0; i < T.length(); i++) {
    		total[T.charAt(i)]++;
    	}
    	int start = -1;
    	int end = S.length();
    	int left = 0;
    	int windowSize = 0;
    	for (int i = 0; i < S.length(); i++) {
    		if (total[S.charAt(i)] != 0) {
    			found[S.charAt(i)]++;
    			if (found[S.charAt(i)] <= total[S.charAt(i)]) {
    				windowSize++;
    			}
    			if (windowSize == T.length()) {
    				while (total[S.charAt(left)] == 0 ||
    						--found[S.charAt(left)] >= total[S.charAt(left)]) {
    					left++;
    				}
    				if (i - left < end - start) {
    					start = left;
    					end = i;
    				}
    				left++;
    				windowSize--;
    			}
    		}
    	}
    	return start == -1 ? "" : S.substring(start, end + 1);
    }
}