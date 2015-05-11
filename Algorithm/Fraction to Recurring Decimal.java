public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        String res = "";
        long a = Math.abs((long) numerator);
        long b = Math.abs((long) denominator);
        if ((denominator < 0 && numerator > 0) || (denominator > 0 && numerator < 0)) {
            res += "-";
        }
        long intPart= a / b;
        res += intPart;
        if (a % b == 0) {
            return res;
        }
        res += ".";
        long remainder = a % b;
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        int i = 1;
        map.put(remainder, 1);
        Queue<Long> queue = new LinkedList<Long>();
        int begin = -1;
        while (remainder != 0) {
            i++;
            long tmp = remainder * 10 / b;
            remainder = remainder * 10 % b;
            if (map.containsKey(remainder)) {
                begin = map.get(remainder);
                queue.offer(tmp);
                break;
            } else {
                map.put(remainder, i);
                queue.offer(tmp);
            }
        }
        if (remainder == 0) {
            while (!queue.isEmpty()) {
                res += queue.poll();
            }
        } else {
            int j = 1;
            while (!queue.isEmpty()) {
                long cur = queue.poll();
                if (j != begin) {
                    res += cur;
                } else {
                    res = res + "(" + cur;
                }
                j++;
            }
            res += ")";
        }
        return res;
    }
}