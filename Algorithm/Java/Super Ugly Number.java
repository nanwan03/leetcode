public class Solution {
    private class uglyNumber implements Comparable<uglyNumber> {
        int val;
        int index;
        int prime;
        public uglyNumber(int val, int index, int prime) {
            this.val = val;
            this.index = index;
            this.prime = prime;
        }
        @Override
        public int compareTo(uglyNumber num) {
            return this.val - num.val;
        }
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> rst = new ArrayList<Integer>();
        if (n == 0 || primes == null || primes.length == 0) {
            return 1;
        }
        Queue<uglyNumber> heap = new PriorityQueue<uglyNumber>();
        for (int prime : primes) {
            heap.offer(new uglyNumber(prime, 1, prime));
        }
        rst.add(1);
        for (int i = 1; i < n; ++i) {
            rst.add(heap.peek().val);
            while (heap.peek().val == rst.get(i)) {
                uglyNumber num = heap.poll();
                heap.offer(new uglyNumber(rst.get(num.index) * num.prime, num.index + 1, num.prime));
            }
        }
        return rst.get(n - 1);
    }
}