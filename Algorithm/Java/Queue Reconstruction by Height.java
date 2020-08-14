public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return people;
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> temp = new ArrayList<int[]>();
        for (int[] p : people) {
            temp.add(p[1], p);
        }
        for (int i = 0; i < people.length; ++i) {
            people[i] = temp.get(i);
        }
        return people;
    }
}