package hash;

import java.util.HashMap;
import java.util.Map;
/*594. 最长和谐子序列
和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。

现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。

示例 1:

输入: [1,3,2,2,5,2,3,7]
输出: 5
原因: 最长的和谐数组是：[3,2,2,2,3].*/
public class HindLHS {
    public int findLHS(int[] nums) {//测试通过
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int res = 0;
        for(int key:map.keySet()){
            int tmp = map.get(key);
            int tmp1 = map.getOrDefault(key-1,0);
            int tmp2 = map.getOrDefault(key+1,0);
            if(tmp1!=0){
                res = Math.max(res,tmp+tmp1);
            }
            if(tmp2!=0){
                res = Math.max(res,tmp+tmp2);
            }
        }
        return res;
    }
}
