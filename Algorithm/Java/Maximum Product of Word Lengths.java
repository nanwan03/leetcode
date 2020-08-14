public class Solution {
    public int maxProduct(String[] words) {
        Arrays.sort(words, new LengthCompare());
        int res = 0;
        int[] bit = new int[words.length];
        for (int i = 0; i < words.length; i++)
            for (int j = 0; j < words[i].length(); j++)
                bit[i] |= (1<<(words[i].charAt(j)-'a'));
        for (int i = 0; i < words.length-1 && words[i].length()*words[i].length() > res; i++)
            for (int j = i+1; j < words.length && words[i].length()*words[j].length() > res; j++)
                if ((bit[i] & bit[j]) == 0)
                    res = words[i].length()*words[j].length();
        return res;
    }
    private static class LengthCompare implements Comparator<String>{
        public int compare(String s1, String s2){
            return (s2.length() - s1.length());
        }
    }
}