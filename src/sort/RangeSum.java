package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeSum {
    public static void main(String[] args) {
        int i = new RangeSum().rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 10);
        System.out.println("i = " + i);
    }
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[i]);
            for(int j:list){
                tmp.add(j+nums[i]);
            }
            list.addAll(tmp);
        }
        Collections.sort(list);
        long sum = 0l;
        for(int i=left;i<=right;i++){
            sum+=list.get(i-1);
        }
        return (int)sum%1000000007;
    }
}