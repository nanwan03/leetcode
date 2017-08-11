public class Solution {
    private class Cmp implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }   
        Arrays.sort(people, new Cmp());
        int size = people.length;
        ArrayList<int[]> tmp = new ArrayList<int[]>();
        for (int i = 0; i < size; i++) {
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }
        int[][] rst = new int[size][2];
        int index = 0;
        for (int[] array : tmp) {
            rst[index][0] = array[0];
            rst[index++][1] = array[1];
        }
        return rst;
    }
}