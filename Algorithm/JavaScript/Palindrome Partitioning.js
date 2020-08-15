/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
    if (s.length === 0) {
        return [];
    }

    let rst = [];

    const isPalindrome = (left, right) => {
        while (left < right) {
            if (s[left++] != s[right--]) {
                return false;
            }
        }
        return true;
    }

    const helper = (current, index) => {
        if (index === s.length) {
            rst.push(current);
            return;
        }
        for (let i = index; i < s.length; ++i) {
            if (isPalindrome(index, i)) {
                helper([...current, s.slice(index, i + 1)], i + 1);
            }
        }
    }

    helper([], 0);
    return rst;
};

console.log(partition('aab'))