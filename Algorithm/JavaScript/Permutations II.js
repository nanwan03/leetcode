/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
    let rst = [];

    let dfs = (current, index) => {
        if (index === current.length) {
            rst.push(current.slice());
            return;
        }
        let set = new Set();
        for (let i = index; i < current.length; ++i) {
            if (set.has(current[i])) {
                continue;
            }
            set.add(current[i]);
            [current[index], current[i]] = [current[i], current[index]];
            dfs(current, index + 1);
            [current[index], current[i]] = [current[i], current[index]];
        }
    }

    dfs(nums, 0);
    return rst;
};

console.log(permuteUnique([0,1,0,0,9]));