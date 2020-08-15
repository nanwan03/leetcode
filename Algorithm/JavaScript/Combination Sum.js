/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    let rst = [];

    const helper = (current, sum, index) => {
        if (sum === target) {
            rst.push(current.slice());
            return;
        }
        for (let i = index; i < candidates.length; ++i) {
            if (sum + candidates[i] <= target) {
                helper([...current, candidates[i]], sum + candidates[i], i);
            }
        }
    }

    helper([], 0, 0);
    return rst;
};

console.log(combinationSum([2,3,7], 7));