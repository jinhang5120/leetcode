package tree;

import java.util.ArrayList;
import java.util.List;
/*
* 面试题 04.03. 特定深度节点链表
给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。



示例：

输入：[1,2,3,4,5,null,7,8]

        1
       /  \
      2    3
     / \    \
    4   5    7
   /
  8

输出：[[1],[2,3],[4,5,7],[8]]
* */
public class ListOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {//层序遍历
        List<ListNode> l = new ArrayList<>();
        List<List<TreeNode>> res = new ArrayList<>();
        if(tree==null) return new ListNode[0];
        List<TreeNode> list = new ArrayList<>();
        list.add(tree);
        res.add(list);
        l.add(new ListNode(tree.val));
        while(true){
            List<TreeNode> last = res.get(res.size()-1);
            List<TreeNode> tmp = new ArrayList<>();
            for(TreeNode n:last){
                if(n.left!=null) tmp.add(n.left);
                if(n.right!=null) tmp.add(n.right);
            }
            if(tmp.size()==0) break;
            ListNode first = new ListNode(tmp.get(tmp.size()-1).val);
            for(int i=tmp.size()-2;i>=0;i--){
                ListNode n = new ListNode(tmp.get(i).val);
                n.next = first;
                first = n;
            }
            l.add(first);
            res.add(tmp);
        }
        ListNode[] nodes = new ListNode[l.size()];
        for(int i=0;i<nodes.length;i++){
            nodes[i] = l.get(i);
        }
        return nodes;
    }
}
