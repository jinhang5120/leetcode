package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。



示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]*/
public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ThreeSum().threeSum(new int[]{0,0,0});
        System.out.println("lists = " + lists);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        /*1.将数组排序 2.定义三个指针，i，j，k。遍历i，那么这个问题就可以转化为在i之后的数组中寻找nums[j]+nums[k]=-nums[i]这个问题，
        也就将三数之和问题转变为二数之和---（可以使用双指针）*/
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            List<List<Integer>> list = twoSum(nums,i+1,nums.length-1,-nums[i]);
            for(List<Integer> l:list){
                List<Integer> tmp = new ArrayList<>(l);
                tmp.add(0,nums[i]);
                res.add(tmp);
            }
            while(nums[i]==nums[i+1]&&i<nums.length-2){//三数之和去重
                i++;
            }
        }
        return res;
    }
    public List<List<Integer>> twoSum(int[] nums,int left,int right,int target){//两数之和用双指针，一次遍历即可
        List<List<Integer>> list = new ArrayList<>();
        int i=left,j=right;
        while(i<j&&i<=right&&j>=left){
            if(nums[i]+nums[j]<target){
                i++;
            }else if(nums[i]+nums[j]>target){
                j--;
            }else{
                list.add(Arrays.asList(nums[i],nums[j]));
                i++;j--;
                while(nums[i-1]==nums[i]&&nums[j]==nums[j+1]&&i<j&&i<=right&&j>=left){//两数之和去重
                    i++;j--;
                }
            }
        }
        return list;
    }
}
