public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int rst = 0;
        for (int i = 0; i < s.length  && rst < g.length; ++i) {
            if (s[i] >= g[rst]) {
                rst++;
            }
        }
        return rst;
    }
}