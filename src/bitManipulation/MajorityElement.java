package bitManipulation;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public int majorityElement1(int[] nums) {//摩尔投票法，不同的数计数就两两抵消，超过一半的数字是抵消后剩余的数字
        int res = 0, count = 0;
        for(int i:nums){
            if(count == 0){
                res = i;
                count++;
            }else{
                if (res == i) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return res;
    }

}
