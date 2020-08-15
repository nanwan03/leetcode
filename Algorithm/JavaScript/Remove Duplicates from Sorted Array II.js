/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if (!nums.length) {
        return 0;
    }
    let index = 1;
    let counter = 1;
    for (let i = 1; i < nums.length; ++i) {
        if (nums[i] != nums[i - 1]) {
            nums[index++] = nums[i];
            counter = 1;
        } else if (counter === 1) {
            nums[index++] = nums[i];
            counter = 0;
        }
    }
    return index;
};

console.log(removeDuplicates([0,0,1,1,1,1,2,3,3]));