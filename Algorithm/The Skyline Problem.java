public class Solution {
    private class heightComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> rst = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0) {
            return rst;
        }
        List<int[]> height = new ArrayList<int[]>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, new heightComparator());
        Queue<Integer> heap = new PriorityQueue<Integer>(buildings.length, Collections.reverseOrder());
        heap.offer(0);
        int prevHeight = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                heap.offer(-h[1]);
            } else {
                heap.remove(h[1]);
            }
            int curHeight = heap.peek();
            if (prevHeight != curHeight) {
                rst.add(new int[]{h[0], curHeight});
                prevHeight = curHeight;
            }
        }
        return rst;
    }
}