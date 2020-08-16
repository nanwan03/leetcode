/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    if (!nums.length) {
        return;
    }
    k %= nums.length;

    const swap = (i, j) => {
        while (i < j) {
            [nums[i++], nums[j--]] = [nums[j], nums[i]]
        }
    }

    swap(0, nums.length - 1);
    swap(0, k - 1);
    swap(k, nums.length - 1);
};

const nums = [1,2,3,4,5,6,7]
rotate(nums, 3);
console.log(nums);