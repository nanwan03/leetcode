import java.util.*;

public class NumArray {
    private int[] value;
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        value = new int[nums.length + 1];
        Arrays.fill(value, 0);
        for (int i = 0; i < nums.length; ++i) {
            updateDiff(i + 1, nums[i]);
        }
    }
    
    private static int lowBit(int index) {
		return index & (-index);
	}
	
    void update(int i, int val) {
    	updateDiff(i + 1, val - nums[i]);
        nums[i] = val;
    }
    
    void updateDiff(int i, int diff) {
        while (i < value.length) {
        	value[i] += diff;
        	i += lowBit(i);
        }
    }

    public int sumRange(int i, int j) {
    	return add(j + 1) - add(i);
    }
    
    private int add(int index) {
    	int sum = 0;
		while (index > 0) {
			sum += value[index];
			index -= lowBit(index);
		}
		return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);