public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> rst = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return rst;
        }
        int count = words.length;
        int curLen = 0;
        int strLen = 0;
        int lastI = 0;
        for (int i = 0; i <= words.length; i++) {
            if (i == count || curLen + words[i].length() > L) {
                StringBuilder sb = new StringBuilder();
                int spaceCount = L - strLen;
                int spaceSlot = i - lastI - 1;
                if (i == count || spaceSlot == 0) {
                    for (int j = lastI; j < i; j++) {
                        sb.append(words[j]);
                        if (j < i - 1) {
                            sb.append(" ");
                        }
                    }
                    append(sb, L - sb.length());
                } else {
                    int spaceNum = spaceCount / spaceSlot;
                    int spaceExtra = spaceCount % spaceSlot;
                    for (int j = lastI; j < i; j++) {
                        sb.append(words[j]);
                        if (j < i - 1) {
                            append(sb, spaceNum + (j - lastI < spaceExtra ? 1 : 0));
                        }
                    }
                }
                rst.add(sb.toString());
                curLen = 0;
                strLen = 0;
                lastI = i;
            }
            if (i < count) {
                curLen += words[i].length() + 1;
                strLen += words[i].length();
            }
        }
        return rst;
    }
    private void append(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
    }
}