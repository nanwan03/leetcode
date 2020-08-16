/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    const length = nums1.length + nums2.length;

    if (length % 2 === 0) {
        return (helper(nums1, 0, nums2, 0, Math.floor(length / 2)) + helper(nums1, 0, nums2, 0, Math.floor(length / 2) + 1)) / 2.0;
    } else {
        return helper(nums1, 0, nums2, 0, Math.floor(length / 2) + 1);
    }
};

function helper(nums1, i1, nums2, i2, size) {
    if (i1 >= nums1.length) {
        return nums2[i2 + size - 1];
    }
    if (i2 >= nums2.length) {
        return nums1[i1 + size - 1];
    }
    if (size === 1) {
        return Math.min(nums1[i1], nums2[i2]);
    }
    const keyA = i1 + Math.floor(size / 2) - 1 < nums1.length ? nums1[i1 + Math.floor(size / 2) - 1] : Number.POSITIVE_INFINITY;
    const keyB = i2 + Math.floor(size / 2) - 1 < nums2.length ? nums2[i2 + Math.floor(size / 2) - 1] : Number.POSITIVE_INFINITY;
    if (keyA < keyB) {
        return helper(nums1, i1 + Math.floor(size / 2), nums2, i2, size - Math.floor(size / 2));
    } else {
        return helper(nums1, i1, nums2, i2 + Math.floor(size / 2), size - Math.floor(size / 2));
    }
}

console.log(findMedianSortedArrays([1,2], [3,4]))