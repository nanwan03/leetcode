public class Solution {
    private int addElement(TreeMap<Integer, Integer> heap, int element, int size) {
		size++;
		if (heap.containsKey(element)) {
			heap.put(element, heap.get(element) + 1);
		} else {
			heap.put(element, 1);
		}
		return size;
	}
	private int removeElement(TreeMap<Integer, Integer> heap, int element, int size) {
		size--;
		if (heap.containsKey(element)) {
			if (heap.get(element) == 1) {
				heap.remove(element);
			} else {
				heap.put(element, heap.get(element) - 1);
			}
		}
		return size;
	}
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k == 0 || t < 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int size = 0;
        for (int i = 1; i <= Math.min(nums.length - 1, k); ++i) {
            size = addElement(map, nums[i], size);
        }
        int first = 1;
        int last = k + 1;
        for (int i = 0; i < nums.length - 1; ++i) {
        	if (size > 0 && Math.abs((long)nums[i] - (long)map.firstKey()) <= t) {
                return true;
            }
            size = removeElement(map, nums[first++], size);
            if (last < nums.length) {
                size = addElement(map, nums[last++], size);
            }
        }
        return false;
    }
}