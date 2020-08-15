/**
 * @param {number[]} nums
 * @param {number} target
 * @return {boolean}
 */
var search = function(nums, target) {
    if (nums.length === 0) {
        return false;
    }
    let left = 0;
    let right = nums.length - 1;
    while (left + 1 < right) {
        const mid = Math.floor((left + right) / 2);
        if (nums[mid] === target) {
            return true;
        } else if (nums[mid] === nums[left]) {
            left++;
        } else {
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
        }
    }
    return nums[left] === target || nums[right] === target;
};

console.log(search([2,5,6,0,0,1,2], 0))