/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    let rst = [];
    nums = nums.sort((a, b)=>(a - b));

    let dfs = (current, index) => {
        rst.push(current);
        for (let i = index; i < nums.length; ++i) {
            if (i > index && nums[i] === nums[i - 1]) {
                continue;
            }
            dfs([...current, nums[i]], i + 1);
        }
    }

    dfs([], 0);

    return rst;
};

console.log(subsetsWithDup([2, 1,1,2,3]));