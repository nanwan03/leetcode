public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}
		int k = 0;
		while (k < nums.length - 1 && nums[k] == nums[k + 1]) {
			k++;
		}
		if (k == nums.length - 1) {
			return 1;
		}
		int rst = 1; 
		boolean flag = nums[k] < nums[k + 1];
		for (int i = k + 1; i < nums.length; i++) {
			if ((flag && nums[i - 1] < nums[i]) ||
                    (!flag && nums[i - 1] > nums[i])){
				nums[rst++] = nums[i];
				flag = !flag;
            }
		}
		return rst;
    }
}