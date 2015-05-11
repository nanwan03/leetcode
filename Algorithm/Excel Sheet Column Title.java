public class Solution {
    public String convertToTitle(int n) {
        if (n == 0) {
        	return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
        	n--;
        	int index = n % 26;
        	n /= 26;
        	sb.append((char)('A' + index));
        }
        return sb.reverse().toString();
    }
}