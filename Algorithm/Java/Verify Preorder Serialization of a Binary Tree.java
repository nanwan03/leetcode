public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) return false;
        String[] strs = preorder.split(",");
        int depth = 0;
        int i = 0; 
        while (i < strs.length - 1) {
            if (strs[i++].equals("#")) {
                if (depth == 0) return false;
                else depth--;
            }
            else depth++;
        }
        if (depth != 0) return false;
        return strs[strs.length - 1].equals("#");
    }
}