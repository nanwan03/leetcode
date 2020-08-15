/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    if (digits.length === 0) {
        return [];
    }
    const map = {
        2: 'abc',
        3: 'def',
        4: 'ghi',
        5: 'jkl',
        6: 'mno',
        7: 'pqrs',
        8: 'tuv',
        9: 'wxyz',
    };

    const rst = [];

    const helper = (current, index) => {
        if (index === digits.length) {
            rst.push(current);
            return;
        }

        for (const c of map[digits[index]]) {
            helper(current + c, index + 1);
        }
    }

    helper('', 0);
    return rst;
};

console.log(letterCombinations('23'));