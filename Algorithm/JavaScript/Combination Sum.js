/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    let rst = [];

    let dfs = (current, sum, index) => {
        if (sum === target) {
            rst.push(current.slice());
            return;
        }
        for (let i = index; i < candidates.length; ++i) {
            if (sum + candidates[i] <= target) {
                dfs([...current, candidates[i]], sum + candidates[i], i);
            }
        }
    }

    dfs([], 0, 0);
    return rst;
};

console.log(combinationSum([2,3,7], 7));