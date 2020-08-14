public class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char t : tasks) {
            if (!map.containsKey(t)) {
                map.put(t, 0);
            }
            map.put(t, map.get(t) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<Integer>(26, Collections.reverseOrder());
        heap.addAll(map.values());
        
        int rst = 0;
        int cycle = n + 1;
        while (!heap.isEmpty()) {
            int time = 0;
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < cycle; i++) {
                if (!heap.isEmpty()) {
                    tmp.add(heap.poll());
                    time++;
                }
            }
            for (int count : tmp) {
                if (--count > 0) {
                    heap.offer(count);
                }
            }
            rst += !heap.isEmpty() ? cycle : time;
        }
        
        return rst;
    }
}