public class Solution {
    public String shortestPalindrome(String s) {
        String s_reverse = new StringBuilder(s).reverse().toString();
        String str = s + "." + s_reverse;
        int[] size = new int[str.length()];
        for(int i = 1; i < str.length(); i++){
            int temp = size[i - 1];
            while(temp != 0 && str.charAt(temp) != str.charAt(i))
                temp = size[temp - 1];
            if(str.charAt(temp) == str.charAt(i))
                temp++;
            size[i] = temp;
        }

        return s_reverse.substring(0, s.length() - size[str.length() - 1]) + s;
    }
}