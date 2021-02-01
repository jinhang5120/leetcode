package union;

import java.util.HashSet;
import java.util.Set;
/*947. 移除最多的同行或同列石头
n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。

如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。

给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。



示例 1：

输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
输出：5
解释：一种移除 5 块石头的方法如下所示：
1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。*/
public class RemoveStones {
    public int removeStones(int[][] stones) {//测试通过
        int[] arr = new int[stones.length];
        for(int i=1;i<arr.length;i++){
            arr[i] = i;
        }
        for(int i=1;i<stones.length;i++){
            for(int j=0;j<i;j++){
                if(stones[j][0]==stones[i][0]||stones[j][1]==stones[i][1]){
                    int root = j;
                    while(arr[root] != root){
                        root = arr[root];
                    }
                    arr[root] = i;
                }
            }
        }
        Set<Integer> roots = new HashSet<>();
        for(int i:arr){
            int root = i;
            while(arr[root]!=root){
                root = arr[root];
            }
            roots.add(root);
        }
        return stones.length-roots.size();
    }
}
