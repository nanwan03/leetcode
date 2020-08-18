function subsets(nums: number[]): number[][] {
    if (!nums.length) {
        return [];
    }
    const rst: number[][] = [];

    const helper = (current: number[], index: number) => {
        rst.push(current);
        for (let i = index; i < nums.length; ++i) {
            helper([...current, nums[i]], i + 1);
        }
    }

    helper([], 0);
    return rst;
};