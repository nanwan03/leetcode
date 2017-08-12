/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> rst = new LinkedList<>();
        if (root == null) {
            return rst;
        }
        traverse(root, new HashMap<String, Integer>(), rst);
        return rst;
    }
    public String traverse(TreeNode cur, Map<String, Integer> map, List<TreeNode> rst) {
        if (cur == null) {
            return "#";  
        }
        String str = cur.val + "," + traverse(cur.left, map, rst) + "," + traverse(cur.right, map, rst);
        if (!map.containsKey(str)) {
            map.put(str, 0);
        } else if (map.get(str) == 1) {
            rst.add(cur);
        }
        map.put(str, map.get(str) + 1);
        return str;
    }
}