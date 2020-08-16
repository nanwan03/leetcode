/**
 * @param {string} A
 * @param {string} B
 * @return {boolean}
 */
var rotateString = function(A, B) {
    if (!A && !B) {
        return true;
    }
    if (A.length != B.length) {
        return false;
    }
    return A.concat(A).includes(B);
};

console.log(rotateString('abcde', 'cdeab'));