import java.util.Comparator;
import java.util.PriorityQueue;
class Number{
    int un;
    int pos;
    int prime;
    Number(int un, int pos, int prime){
        this.un = un;
        this.pos = pos;
        this.prime = prime;
    }
}
class NumberCompare implements Comparator<Number>{

    @Override
    public int compare(Number x, Number y) {
        // TODO Auto-generated method stub
        if (x.un > y.un)
            return 1;
        else if (x.un < y.un)
            return -1;
        else
            return 0;
    }
}
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Comparator<Number> comparator = new NumberCompare();
        PriorityQueue<Number> queue = 
                new PriorityQueue<Number>(primes.length, comparator);
        for(int i = 0; i < primes.length; i ++) 
            queue.add(new Number(primes[i], 0, primes[i]));
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        for(int i = 1; i < n; i++){
            Number min = queue.peek();
            uglyNums[i] = min.un;
            while(queue.peek().un == min.un){
                Number tmp = queue.poll();
                queue.add(new Number(uglyNums[tmp.pos + 1] * tmp.prime, tmp.pos+1, tmp.prime)); 
            }
        }
    
        return uglyNums[n-1];
    }
}