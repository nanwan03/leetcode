public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
        	return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : num) {
        	map.put(i, 1);
        }
        int max = 0;
        for (int i : num) {
        	if (map.get(i) == 2) {
        		continue;
        	}
        	int temp = i;
        	int tempLength = 1;
        	while (map.containsKey(temp - 1)) {
        		temp--;
        		tempLength++;
        		map.put(temp, 2);
        	}
        	temp = i;
        	while (map.containsKey(temp + 1)) {
        		temp++;
        		tempLength++;
        		map.put(temp, 2);
        	}
        	max = Math.max(max, tempLength);
        }
        return max;
    }
}