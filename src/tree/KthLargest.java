package tree;
/*
* 剑指 Offer 54. 二叉搜索树的第k大节点
给定一棵二叉搜索树，请找出其中第k大的节点。



示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
* */
import java.util.ArrayList;
import java.util.List;

public class KthLargest {//测试通过
    /*
    * 二叉树的三种遍历方式： a. 前序遍历 b. 中序遍历 c. 后续遍历
        二叉搜索树的一个特性：通过中序遍历所得到的序列，就是有序的。
    * */
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        midOrder(root,list);
        return list.get(list.size()-k);
    }
    public void midOrder(TreeNode root,List<Integer> list){
        if(root!=null){
            midOrder(root.left,list);
            list.add(root.val);
            midOrder(root.right,list);
        }
    }
}
