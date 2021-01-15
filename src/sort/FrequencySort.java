package sort;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        int[] ints = new FrequencySort().frequencySort(new int[]{2,3,1,3,2});
        System.out.println("ints = " + ints);
    }
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> resMap = new HashMap<>();
        List<Integer> numsList = new ArrayList<>();
        //统计次数
        for (int curr : nums) {
            numsList.add(curr);
            resMap.put(curr, resMap.getOrDefault(curr, 0) + 1);
        }
        numsList.sort((a, b) -> {//重写list的排序方法
            int aCount = resMap.get(a);
            int bCount = resMap.get(b);
            if (aCount == bCount) {
                return b - a;
            }
            return aCount - bCount;
        });

        return numsList.stream().mapToInt(Integer::intValue).toArray();
    }
}
