public class Solution {
    public String multiply(String num1, String num2) {
        int length = num1.length() + num2.length();
        int length1 = num1.length();
        int length2 = num2.length();
        int[] rst = new int[length1 + length2];
        for (int i = length1 - 1; i >= 0; i--) {
            int carry = 0;
            int j = length2 - 1;
            for (;j >= 0; j--) {
                int product = carry + rst[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                carry = product / 10;
                rst[i + j + 1] = product % 10;
            }
            rst[i + j + 1] = carry;
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < length - 1 && rst[index] == 0) {
            index++;
        }
        while (index < length) {
            sb.append(rst[index++]);
        }
        return sb.toString();
    }
}