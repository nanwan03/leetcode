public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b)->b-a);
        int time=0;
        for (int[] c : courses) 
        {
            time += c[0]; 
            heap.add(c[0]);
            if (time > c[1]) {
                time -= heap.poll();
            }
        }        
        return heap.size();
    }
}