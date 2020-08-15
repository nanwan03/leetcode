/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    let rst = [];

    const helper = (current, index) => {
        rst.push(current);
        for (let i = index; i < nums.length; ++i) {
            helper([...current, nums[i]], i + 1);
        }
    }

    helper([], 0);

    return rst;
};

console.log(subsets([1,2,3]));