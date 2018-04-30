class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = Arrays.asList(new Integer[]{1});
        while (--rowIndex >= 0) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int i = 0; i <= prev.size(); ++i) {
                if (i == 0 || i == prev.size()) {
                    cur.add(1);
                } else {
                    cur.add(prev.get(i) + prev.get(i - 1));
                }
            }
            prev = cur;
        }
        return prev;
    }
}