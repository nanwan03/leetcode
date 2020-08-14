public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            return 0;
        }
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int i1 = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            int i2 = i < v2.length ? Integer.valueOf(v2[i]) : 0;
            if (i1 != i2) {
                return i1 < i2 ? -1 : 1;
            }
        }
        return 0;
    }
}