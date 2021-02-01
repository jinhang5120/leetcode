package tree;

public class LongestUnivaluePath {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        int i = new LongestUnivaluePath().longestUnivaluePath(n1);
        System.out.println("i = " + i);
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        int left = longestUnivaluePath(root.left);
        int right = longestUnivaluePath(root.right);
        int mid = longestUnivaluePathFromRoot(root);
        return Math.max(Math.max(left,right),mid);
    }
    public int longestUnivaluePathFromRoot(TreeNode root){
        if(root==null) return 0;
        int res = 1;
        if(root.left!=null&&root.left.val==root.val){
            res+=longestUnivaluePathFromRoot(root.left);
        }
        if(root.right!=null&&root.right.val==root.val){
            res+=longestUnivaluePathFromRoot(root.right);
        }
        return res;
    }
}
