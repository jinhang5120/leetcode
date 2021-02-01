package union;

import java.util.HashMap;
import java.util.Map;
/*684. 冗余连接
在本问题中, 树指的是一个连通且无环的无向图。

输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。

结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。

返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。

示例 1：

输入: [[1,2], [1,3], [2,3]]
输出: [2,3]
解释: 给定的无向图为:
  1
 / \
2 - 3*/
public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {//测试通过
        Map<Integer,Integer> map = new HashMap<>();//并查集
        for(int[] edge:edges){
            int node1 = edge[0];
            int node2 = edge[1];
            while(map.containsKey(node1)){
                node1 = map.get(node1);
            }
            while(map.containsKey(node2)){
                node2 = map.get(node2);
            }
            if(node1==node2){
                return edge;
            }
            map.put(node1,node2);
        }
        return null;
    }
}
