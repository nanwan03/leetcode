class Solution {
    private int index = 0;
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            chars[index++] = c;
            int val = 1;
            while (i + 1 < chars.length && chars[i + 1] == c) {
                i++;
                val++;
            }
            if (val > 1) {
                char[] tmp = String.valueOf(val).toCharArray();
                for (int j = 0; j < tmp.length; ++j) {
                    chars[index++] = tmp[j];
                }
            }
        }
        return index;
    }
}