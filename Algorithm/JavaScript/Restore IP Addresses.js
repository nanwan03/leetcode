/**
 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function(s) {
    if (s.length < 4 || s.length > 12) {
        return [];
    }
    const rst = [];

    const isValid = (str) => {
        if (str.length > 1 && str[0] === '0') {
            return false;
        }
        if (Number(str) > 255) {
            return false;
        }
        return true;
    }

    const helper = (current, index) => {
        if (index === s.length && current.length === 4) {
            rst.push(Array.from(current).join('.'));
            return;
        }
        for (let i = index; i < Math.min(index + 4, s.length); ++i) {
            const str = s.slice(index, i + 1);
            if (isValid(str)) {
                current.push(str);
                helper(current, i + 1);
                current.pop();
            }
        }
    }

    helper([], 0);
    return rst;
};

console.log(restoreIpAddresses('25525511135'));