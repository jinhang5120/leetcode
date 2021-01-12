package hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*554. 砖墙
你的面前有一堵矩形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。

砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。

如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。

你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。



示例：

输入: [[1,2,2,1],
      [3,1,2],
      [1,3,2],
      [2,4],
      [3,1,2],
      [1,3,1,1]]*/
public class LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {//测试通过
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(List<Integer> list:wall){
            int tmp = 0;
            for(int i=0;i<list.size()-1;i++){
                tmp+=list.get(i);
                int j = map.getOrDefault(tmp,0);
                map.put(tmp,j+1);
                max = Math.max(max,j+1);
            }
        }
        return wall.size()-max;
    }
}
