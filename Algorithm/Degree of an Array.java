class Solution {
    private static class Node {
        int freq;
        int start;
        int end;
        Node(int start) {
            this.freq = 1;
            this.start = start;
            this.end = start;
        }
        public int getDist() {
            return this.end - this.start + 1;
        }
    }
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Node> map = new HashMap<Integer, Node>();
        int maxFreq = 1;
        int rst = nums.length + 1;
        for (int i = 0; i < nums.length; ++i) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new Node(i));
            } else {
                Node n = map.get(nums[i]);
                n.freq++;
                n.end = i;
            }
            if (maxFreq < map.get(nums[i]).freq) {
                maxFreq = map.get(nums[i]).freq;
                rst = map.get(nums[i]).getDist();
            } else if (maxFreq == map.get(nums[i]).freq) {
                rst = Math.min(rst, map.get(nums[i]).getDist());
            }
        }
        return rst;
    }
}