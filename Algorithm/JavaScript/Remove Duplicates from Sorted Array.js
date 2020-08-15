/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if (!nums.length) {
        return 0;
    }
    let index = 1;
    for (let i = 1; i < nums.length; ++i) {
        if (nums[i] === nums[i - 1]) {
            continue;
        }
        nums[index++] = nums[i];
    }
    return index;
};

console.log(removeDuplicates([0,0,1,1,1,2,2,3,3,4]));