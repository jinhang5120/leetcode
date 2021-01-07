package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 剑指 Offer 32 - II. 从上到下打印二叉树 II
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。



例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
* */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {//测试通过
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        res.add(Arrays.asList(root.val));
        List<TreeNode> pre = new ArrayList<>();
        pre.add(root);
        while(true){
            List<TreeNode> next = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            for(TreeNode n:pre){
                if(n.left!=null){
                    next.add(n.left);
                    l.add(n.left.val);
                }
                if(n.right!=null){
                    next.add(n.right);
                    l.add(n.right.val);
                }
            }
            if(next.size()==0){
                break;
            }else{
                pre = next;
                res.add(l);
            }
        }
        return res;
    }
}
