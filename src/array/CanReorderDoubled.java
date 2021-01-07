package array;

import java.util.Map;
import java.util.TreeMap;
/*
* 954. 二倍数对数组
给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。



示例 1：

输入：[3,1,3,6]
输出：false
示例 2：

输入：[2,1,2,6]
输出：false
示例 3：

输入：[4,-2,2,-4]
输出：true
解释：我们可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
示例 4：

输入：[1,2,4,16,8,4]
输出：false
* */
public class CanReorderDoubled {//TODO 通过，利用TreeMap，key排序的Map
    public static void main(String[] args) {
        boolean b = canReorderDoubled(new int[]{1,2,1,-8,8,-4,4,-4,2,-2});
        System.out.println("b = " + b);
    }
    public static boolean canReorderDoubled(int[] A) {
        if(A.length==0) return true;
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i:A){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Integer key:map.keySet()){
            if(map.get(key)==0) continue;
            if(key==0&&map.get(key)%2!=0){
                return false;
            }else if(key<0){
                if(key%2!=0){
                    return false;
                }else{
                    if(map.get(key)>map.getOrDefault(key/2,0)){
                        return false;
                    }
                    map.put(key/2,map.getOrDefault(key/2,0)-map.get(key));
                    map.put(key,0);
                }
            }else if(key>0){
                if(map.get(key)>map.getOrDefault(key*2,0)){
                    return false;
                }else{
                    map.put(key*2,map.getOrDefault(key*2,0)-map.get(key));
                    map.put(key,0);
                }
            }
        }
        return true;
    }
}
