public class Solution {
    public void moveZeroes(int[] nums) {
        int rightPos = 0, curr = 0;
        while(curr < nums.length) {
            if(nums[curr]!=0) nums[rightPos++] = nums[curr];
            curr++;
        }
        while(rightPos < nums.length) {
            nums[rightPos++] = 0;
        }
    }
}