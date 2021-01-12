package tree;

//1022. 从根到叶的二进制数之和
//给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
//
//对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
//
//返回这些数字之和。题目数据保证答案是一个 32 位 整数。
//
//
//
//示例 1：
//
//
//输入：root = [1,0,1,0,1,0,1]
//输出：22
//解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
public class SumRootToLeaf {
    public static void main(String[] args) {//测试通过
        TreeNode root = new TreeNode(0);
        TreeNode n01 = new TreeNode(1);
        TreeNode n00 = new TreeNode(0);
        TreeNode n010 = new TreeNode(0);
        TreeNode n000l = new TreeNode(0);
        TreeNode n000r = new TreeNode(0);
        TreeNode n0001 = new TreeNode(1);
        TreeNode n00011 = new TreeNode(1);
        root.left = n01;
        root.right = n00;
        n01.left =  n010;
        n00.left = n000l;
        n00.right = n000r;
        n000l.right = n0001;
        n0001.right = n00011;


        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        int i = sumRootToLeaf.sumRootToLeaf(root);
        System.out.println("i = " + i);
    }
    public int sumRootToLeaf(TreeNode root) {
        return sum(root,0);
    }
    public int sum(TreeNode root,int parentSum){//递归遍历，算总和的，考虑在递归方法的参数和返回值中做文章，比如参数中设置统计量
        if(root!=null){
            parentSum = parentSum*2+root.val;
            if(root.left==null&&root.right==null){
                return parentSum;
            }
            return sum(root.left,parentSum)+sum(root.right,parentSum);
        }else{
            return 0;
        }
    }

/*    public int sumRootToLeaf(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        List<List<TreeNode>> list = new ArrayList<>();
        list.add(nodes);
        while(true){
            List<List<TreeNode>> list1 = new ArrayList<>();
            boolean flag = true;
            for(List<TreeNode> l:list){
                TreeNode last = l.get(l.size()-1);
                if(last.left==null&&last.right==null){
                    list1.add(l);
                }
                if(last.left!=null){
                    List<TreeNode> tmp = new ArrayList<>(l);
                    tmp.add(last.left);
                    list1.add(tmp);
                    flag = false;
                }
                if(last.right!=null){
                    List<TreeNode> tmp = new ArrayList<>(l);
                    tmp.add(last.right);
                    list1.add(tmp);
                    flag = false;
                }
            }
            if(flag) break;
            list = list1;
        }
        int res = 0;
        for(List<TreeNode> l:list){
            int sum = 0;
            for(TreeNode n:l){
                sum = sum*2+n.val;
            }
            res+=sum;
        }
        return res;
    }*/
}
