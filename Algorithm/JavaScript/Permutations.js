/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    let rst = [];

    const helper = (current, index) => {
        if (index === nums.length) {
            rst.push([...current]);
            return;
        }
        for (let i = index; i < current.length; ++i) {
            [current[index], current[i]] = [current[i], current[index]];
            helper(current, index + 1);
            [current[index], current[i]] = [current[i], current[index]];
        }
    }

    helper(nums, 0);
    return rst;
};

console.log(permute([0,1,9]));