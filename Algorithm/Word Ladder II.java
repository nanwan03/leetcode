public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if (dict == null || dict.size() == 0) {
            return rst;
        }
        List<String> path = new ArrayList<String>();
        path.add(start);
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put(start, new ArrayList<String>());
        map.put(end, new ArrayList<String>());
        for (String str : dict) {
            map.put(str, new ArrayList<String>());
        }
        List<String> currentLevel = new ArrayList<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            currentLevel.clear();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                currentLevel.add(temp);
                dict.remove(temp);
            }
            for (String str : currentLevel) {
                for (int i = 0; i < str.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == str.charAt(i)) {
                            continue;
                        }
                        String newStr = replace(str, i, c);
                        if (dict.contains(newStr)) {
                            map.get(str).add(newStr);
                            if (!queue.contains(newStr)) {
                                queue.offer(newStr);
                            }
                        }
                    }
                }
            }
            if (queue.contains(end)) {
                break;
            }
        }
        buildPath(rst, path, map, start, end);
        return rst;
    }
    private void buildPath(List<List<String>> rst, List<String> path, Map<String, List<String>> map, String start, String end) {
        List<String> list = map.get(start);
        if (start.equals(end)) {
            rst.add(new ArrayList<String>(path));
            return;
        }
        for (String temp : list) {
            path.add(temp);
            buildPath(rst, path, map, temp, end);
            path.remove(path.size() - 1);
        }
    }
    private String replace(String str, int index, char c) {
        char[] chars = str.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}