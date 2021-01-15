package sort;
/*
* */

import java.util.ArrayList;
import java.util.List;
/*1030. 距离顺序排列矩阵单元格
给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。

另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。

返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）



示例 1：

输入：R = 1, C = 2, r0 = 0, c0 = 0
输出：[[0,0],[0,1]]
解释：从 (r0, c0) 到其他单元格的距离为：[0,1]*/
public class AllCellsDistOrder {
    public static void main(String[] args) {
        int[][] ints = new AllCellsDistOrder().allCellsDistOrder(2 , 2, 0, 1);
        System.out.println("ints = " + ints);
    }
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {//测试通过
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{r0,c0});
        int d=1;
        while(list.size()<R*C){
            for(int i=r0-d;i<=r0+d;i++){
                if(i>=0&&i<R){
                    if(Math.abs(r0-i)==d){
                        list.add(new int[]{i,c0});
                    }else{
                        if(c0-(d-Math.abs(r0-i))>=0){
                            list.add(new int[]{i,c0-(d-Math.abs(r0-i))});
                        }
                        if(c0+(d-Math.abs(r0-i))<C){
                            list.add(new int[]{i,c0+(d-Math.abs(r0-i))});
                        }
                    }
                }
            }
            d++;
        }
        int[][] res = new int[R*C][2];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
