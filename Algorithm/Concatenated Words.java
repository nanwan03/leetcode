public class Solution {
    private class Cmp implements Comparator<String> {
        public int compare(String a, String b) {
            return a.length() - b.length();
        }
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> rst = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return rst;
        }
        Set<String> used = new HashSet<String>();
        Arrays.sort(words, new Cmp());
        for (int i = 0; i < words.length; i++) {
            if (isValid(words[i], used)) {
                rst.add(words[i]);
            }
            used.add(words[i]);
        }
        return rst;
    }
    private boolean isValid(String s, Set<String> dict) {
        if (dict.isEmpty()) {
            return false;
        }
        int size = s.length();
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;
        for (int i = 1; i <= size; ++i) {
            for (int j = i - 1; j >= 0 && !dp[i]; --j) {
                dp[i] = dp[j] && dict.contains(s.substring(j, i));
            }
        }
        return dp[size];
    }
}