/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    let rst = [];

    let dfs = (current, index) => {
        rst.push(current);
        for (let i = index; i < nums.length; ++i) {
            dfs([...current, nums[i]], i + 1);
        }
    }

    dfs([], 0);

    return rst;
};

console.log(subsets([1,2,3]));