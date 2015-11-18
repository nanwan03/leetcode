import java.util.*;

public class NumArray {
    private int[] value;
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        value = new int[nums.length + 1];
        Arrays.fill(value, 0);
        for (int i = 1; i <= nums.length; ++i) {
        	int temp = i;
        	while (temp < value.length) {
        		value[temp] += nums[i - 1];
        		temp += lowBit(temp);
        	}
        }
    }
    
    private static int lowBit(int index) {
		return index & (index ^ (index - 1));
	}
	
    void update(int i, int val) {
    	int temp = i++;
    	int diff = val - nums[temp];
        while (i < value.length) {
			value[i] += diff;
			i += lowBit(i);
		}
        nums[temp] = val;
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