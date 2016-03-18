public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        if(num == 0){ return result;}
        int leftMostOne = 1; // will increase as 2, 4, 8, 16, 32 ....
        for(int i = 1; i <= num; i++){
            if(i == 2 * leftMostOne){ leftMostOne = i;}
            result[i] = 1 + result[i - leftMostOne];
        }
        return result;
    }
}