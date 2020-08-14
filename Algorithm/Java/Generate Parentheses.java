public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<String>();
        if (n == 0) {
            return rst;
        }
        String items = "";
        helper(rst, items, n, n);
        return rst;
    }
    private void helper(List<String> rst, String items, int leftNum, int rightNum) {
        if (leftNum == 0 && rightNum == 0) {
            rst.add(items);
            return;
        }
        if (leftNum > 0) {
            helper(rst, items + "(", leftNum - 1, rightNum);
        }
        if (rightNum > leftNum && rightNum > 0) {
            helper(rst, items + ")", leftNum, rightNum - 1);
        }
    }
}