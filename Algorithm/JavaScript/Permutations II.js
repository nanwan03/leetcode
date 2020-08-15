/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
    if (!nums.length) {
        return [];
    }
    const rst = [];

    const helper = (current, index) => {
        if (index === current.length) {
            rst.push([...current]);
            return;
        }
        const set = new Set();
        for (let i = index; i < current.length; ++i) {
            if (set.has(current[i])) {
                continue;
            }
            set.add(current[i]);
            [current[index], current[i]] = [current[i], current[index]];
            helper(current, index + 1);
            [current[index], current[i]] = [current[i], current[index]];
        }
    }

    helper(nums, 0);
    return rst;
};

console.log(permuteUnique([0,1,0,0,9]));