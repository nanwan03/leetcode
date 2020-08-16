/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    if (!nums1.length || !nums2.length) {
        return;
    }
    let insertPos = m + n - 1;
    m--;
    n--;
    while (n >= 0) {
        nums1[insertPos--] = nums1[m] >= nums2[n] ? nums1[m--] : nums2[n--];
    }
};

console.log(merge([1,2,3,0,0,0], 3, [2,5,6], 3));