package tree;

import java.util.Arrays;
/*
* 面试题 04.02. 最小高度树
给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

示例:
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0
         / \
       -3   9
       /   /
     -10  5
* */
public class SortedArrayToBST {//测试通过
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        if(nums.length==1) return new TreeNode(nums[0]);
        int[] nums1 = Arrays.copyOfRange(nums,0,nums.length/2);
        int[] nums2 = null;
        if(nums.length/2+1==nums.length){
            nums2 = new int[0];
        }else{
            nums2 = Arrays.copyOfRange(nums,nums.length/2+1,nums.length);
        }
        TreeNode root = new TreeNode(nums[nums.length/2]);
        root.left =  sortedArrayToBST(nums1);
        root.right = sortedArrayToBST(nums2);
        return root;
    }
}
