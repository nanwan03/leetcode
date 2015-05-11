public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        if (numRows == 0) {
            return rst;
        }
        cur.add(1);
        rst.add(cur);
        List<Integer> prev = cur;
        for (int i = 1; i < numRows; i++) {
            cur =  new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                }  else {
                    cur.add(prev.get(j - 1) + prev.get(j));
                }
            }
            rst.add(cur);
            prev = cur;
        }
        return rst;
    }
}