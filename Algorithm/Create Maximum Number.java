public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int get_from_nums1 = Math.min(nums1.length, k);
        String ans = "";
        for (int i = Math.max(k - nums2.length, 0); i <= get_from_nums1; i++) {
            String res1 = solve(nums1, 0, "", 0, i);
            String res2 = solve(nums2, 0, "", 0, k - i);
            if (res1.length() + res2.length() != k) continue;
            int pos1 = 0, pos2 = 0;
            String res = "";
            while (res1 != "" && res2 != "" && pos1 < res1.length() && pos2 < res2.length()) {
                if (res1.charAt(pos1) > res2.charAt(pos2))
                    res += res1.charAt(pos1++);
                else if (res1.charAt(pos1) < res2.charAt(pos2))
                    res += res2.charAt(pos2++);
                else {
                    int x = pos1;
                    int y = pos2;
                    while (x < res1.length() && y < res2.length() && res1.charAt(x) == res2.charAt(y)) {
                        x++;
                        y++;
                    }
                    if (x < res1.length() && y < res2.length()) {
                        if (res1.charAt(x) < res2.charAt(y)) {
                            res += res2.charAt(pos2++);
                        } else {
                            res += res1.charAt(pos1++);
                        }
                    } else if (x < res1.length()) {
                        res += res1.charAt(pos1++);
                    } else {
                        res += res2.charAt(pos2++);
                    }
                }
            }
            if (pos1 < res1.length())
                res += res1.substring(pos1);
            if (pos2 < res2.length())
                res += res2.substring(pos2);
            if (res.compareTo(ans) > 0)
                ans = res;
        }
        int[] t = new int[k];
        for (int i = 0; i < ans.length(); i++) {
            t[i] = (int) (ans.charAt(i) - '0');
        }
        return t;
    }

    public String solve(int[] nums1, int start, String res, int cur, int k) {
        if (cur == k) return res;
        int[] dig_num1 = new int[10];
        for (int i = 0; i < 10; i++)
            dig_num1[i] = -1;

        for (int i = start; i < nums1.length; i++) {
            if (dig_num1[nums1[i]] == -1) {
                dig_num1[nums1[i]] = i;
            }
        }

        int pos1 = -1;
        for (int i = 0; i < 10; i++) {
            if (dig_num1[i] >= 0)
                pos1 = i;
        }

        if (pos1 >= 0 && nums1.length - dig_num1[pos1] + cur < k) {
            pos1--;
            while (pos1 > 0 && (dig_num1[pos1] == -1 || nums1.length - dig_num1[pos1] + cur < k))
                pos1--;
        }
        if (pos1 < 0) return res;
        return solve(nums1, dig_num1[pos1] + 1, res + pos1, cur + 1, k);
    }
}