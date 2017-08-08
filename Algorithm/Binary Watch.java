public class Solution {
    private int[] nums1 = new int[]{8, 4, 2, 1};
    private int[] nums2 = new int[]{32, 16, 8, 4, 2, 1};
    public List<String> readBinaryWatch(int num) {
        List<String> rst = new ArrayList<String>();
        for(int i = 0; i <= num; i++) {
            List<Integer> list1 = generateDigit(nums1, i);
            List<Integer> list2 = generateDigit(nums2, num - i);
            for(int num1: list1) {
                if(num1 < 12) {
                    for(int num2: list2) {
                        if(num2 < 60) {
                            rst.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                        }
                    }
                }
            }
        }
        return rst;
    }

    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> rst = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, rst);
        return rst;
    }

    private void generateDigitHelper(int[] nums, int count, int index, int sum, List<Integer> rst) {
        if(count == 0) {
            rst.add(sum);
            return;
        }
        for(int i = index; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], rst);    
        }
    }
}