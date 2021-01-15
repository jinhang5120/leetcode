package binarySearch;
/*
剑指 Offer 53 - II. 0～n-1中缺失的数字
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。



示例 1:

输入: [0,1,3]
输出: 2
示例 2:

输入: [0,1,2,3,4,5,6,7,9]
输出: 8
* */
public class MissingNumber {
    public int missingNumber(int[] nums) {//测试通过，重置left和right通过举例子得知
        int left = 0,right = nums.length-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > mid){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        if(nums[left] == left){//递归到最后一个直接加1输出
            return left+1;
        }
        return nums[left]-1;//否则返回前一个值
    }
}
