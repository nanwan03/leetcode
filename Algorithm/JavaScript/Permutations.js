/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    let rst = [];

    let dfs = (current, index) => {
        if (index === nums.length) {
            rst.push(current.slice());
            return;
        }
        for (let i = index; i < current.length; ++i) {
            [current[index], current[i]] = [current[i], current[index]];
            dfs(current, index + 1);
            [current[index], current[i]] = [current[i], current[index]];
        }
    }

    dfs(nums, 0);
    return rst;
};

console.log(permute([0,1,9]));