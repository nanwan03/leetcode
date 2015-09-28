public class Solution {
    public int findDuplicate(int[] nums) {
        int fast, slow;

        fast = slow = nums[0];
    
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
    
        slow = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
    
        return fast;
    }
}