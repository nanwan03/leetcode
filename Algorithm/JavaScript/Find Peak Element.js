/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {
    if (!nums.length) {
        return -1;
    }
    let left = 0;
    let right = nums.length - 1;
    while (left + 1 < right) {
        const mid = Math.floor((left + right) / 2);
        if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
            return mid;
        } else if (nums[mid - 1] < nums[mid]) {
            left = mid;
        } else {
            right = mid;
        }
    }
    return nums[left] < nums[right] ? right : left;
};

console.log(findPeakElement([1,2,1,3,5,6,4]));