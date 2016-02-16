public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num <= first) {  // update the minimum ending of LIS whose length is 1
                first = num;
            } else if (num <= second) {  // update the minimum ending of LIS whose length is 2
                second = num;
            } else {  // now first < second < num, num maybe the minimum ending of LIS whose length is 3
                return true;
            }
        }
        return false;
    }
}