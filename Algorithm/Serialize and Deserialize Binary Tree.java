/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> parent = new LinkedList<>();
        parent.offer(root);
        while(!parent.isEmpty()) {
            Queue<TreeNode> children = new LinkedList<>();
            while(!parent.isEmpty()) {
                TreeNode node = parent.poll();
                if(node!=null) {
                    sb.append(node.val);
                    children.offer(node.left);
                    children.offer(node.right);
                } else {
                    sb.append("null");
                }
                sb.append(" ");
            }
            parent = children;
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(" ");
        Queue<TreeNode> parent = new LinkedList<>();
        TreeNode root = strs[0].equals("null") ? null : new TreeNode(Integer.valueOf(strs[0]));
        parent.offer(root);
        int i = 1;
        while(!parent.isEmpty()) {
            Queue<TreeNode> children = new LinkedList<>();
            while(!parent.isEmpty()) {
                TreeNode node = parent.poll();
                if(node!=null) {
                    if(i< strs.length && !strs[i].equals("null")){
                        node.left = new TreeNode(Integer.valueOf(strs[i++]));
                    } else {
                        i++;
                    }
                    if(i< strs.length && !strs[i].equals("null")){
                        node.right = new TreeNode(Integer.valueOf(strs[i++]));
                    } else {
                        i++;
                    }
                    children.offer(node.left);
                    children.offer(node.right);
                }
            }
            parent = children;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));