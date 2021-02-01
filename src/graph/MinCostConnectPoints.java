package graph;
/*1584. 连接所有点的最小费用
给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。

连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。

请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。



示例 1：



输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
输出：20*/
import java.util.ArrayList;
import java.util.List;

public class MinCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {//测试通过，prim算法，从已访问过的顶点出发，找到邻接最小的顶点连接，并标记访问，再循环
        List<int[]> pointsList = new ArrayList<>();//待访问list
        List<Integer> minD = new ArrayList<>();//待访问的最短路径list
        for(int[] point:points){
            pointsList.add(point);
            minD.add(Integer.MAX_VALUE);
        }
        List<int[]> visitedPoints = new ArrayList<>();//已访问list
        visitedPoints.add(pointsList.get(0));
        pointsList.remove(0);
        minD.remove(0);
        int res = 0;
        List<Integer> d = new ArrayList<>();
        while(pointsList.size()!=0){
            int nextPointIndex = 0;
            int min = Integer.MAX_VALUE;
            for(int i=0;i<pointsList.size();i++){
                int[] point = pointsList.get(i);
                int[] last = visitedPoints.get(visitedPoints.size()-1);
                int tmp = Math.abs(point[0]-last[0])+Math.abs(point[1]-last[1]);
                minD.set(i,Math.min(tmp,minD.get(i)));
                if(minD.get(i)<min){
                    nextPointIndex = i;
                    min = minD.get(i);
                }
            }
            visitedPoints.add(pointsList.get(nextPointIndex));
            pointsList.remove(nextPointIndex);
            minD.remove(nextPointIndex);
            res+=min;
        }
        return res;
    }
}
