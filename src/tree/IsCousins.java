package tree;

public class IsCousins {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.right = n5;
        boolean cousins = new IsCousins().isCousins(n1, 4, 5);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        return getDepth(root,x,1)==getDepth(root,y,1) && findParent(null,root,x)!=findParent(null,root,y);
    }
    /*
    * 找到值为x的父节点
    * */
    public TreeNode findParent(TreeNode parent,TreeNode cur,int x){//参数和返回值都带父节点变量,DFS
        //cur当前遍历到的节点，parent是cur的父节点
        if(cur==null){
            return null;
        }else{
            if(cur.val==x){
                return parent;
            }else{
                TreeNode n1 = findParent(cur,cur.left,x);
                if(n1!=null){
                    return n1;
                }else{
                    TreeNode n2 = findParent(cur,cur.right,x);
                    if(n2!=null){
                        return n2;
                    }else{
                        return null;
                    }
                }
            }
        }
    }
    /*
    * 找到值为x的深度
    * */
    public int getDepth(TreeNode cur,int x,int depth){//参数和节点都带深度变量，DFS
        //d是当前遍历节点的深度
        if(cur==null){
            return -1;
        }else{
            if(cur.val==x){
                return depth;
            }else{
                int d1 = getDepth(cur.left,x,depth+1);
                if(d1!=-1) return d1;
                int d2 = getDepth(cur.right,x,depth+1);
                if(d2!=-1) return d2;
                return -1;
            }
        }
    }
}
