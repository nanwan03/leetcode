public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        int step = 1;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                for (int j = 0; j < str.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == str.charAt(j)) {
                            continue;
                        }
                        String newStr = replace(str, j, c);
                        if (dict.contains(newStr)) {
                            queue.offer(newStr);
                            dict.remove(newStr);
                        }
                        if (newStr.equals(end)) {
                            return step + 1;
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
    private String replace(String str, int index, char c) {
        char[] chars = str.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}