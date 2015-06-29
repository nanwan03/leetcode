public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        int candidate1 = 0;
        int count1 = 0;
        int candidate2 = 0;
        int count2 = 0;
        for (int i : nums) {
            if  (candidate1 == i) {
                count1++;
            } else if (candidate2 == i) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = i;
                count1++;
            } else if(count2 == 0) {
                candidate2 = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (candidate1 == i) {
                count1++;
            } else if (candidate2 == i) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            rst.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            rst.add(candidate2);
        }
        return rst;
    }
}