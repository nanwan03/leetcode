public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> rst = new ArrayList<String>();
        if (nums.length == 0) {
            return rst;
        }
        for (int i = 0; i < nums.length; ++i) {
            int start = nums[i];
            int startIndex = i;
            while (i + 1 < nums.length && nums[i + 1] - start == i + 1 - startIndex) {
                i++;
            }
            if (i == startIndex) {
            	rst.add(new StringBuilder().append(start).toString());
            } else {
            	rst.add(new String(start + "->" + nums[i]));
            }
        }
        return rst;
    }
}