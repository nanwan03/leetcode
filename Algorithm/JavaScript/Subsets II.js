/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    if (nums.length === 0) {
        return [];
    }
    const rst = [];
    nums = nums.sort((a, b)=>(a - b));

    const helper = (current, index) => {
        rst.push(current);
        for (let i = index; i < nums.length; ++i) {
            if (i > index && nums[i] === nums[i - 1]) {
                continue;
            }
            helper([...current, nums[i]], i + 1);
        }
    }

    helper([], 0);
    return rst;
};

console.log(subsetsWithDup([2, 1,1,2,3]));