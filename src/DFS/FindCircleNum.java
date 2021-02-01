package DFS;
/*547. 省份数量
有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。

给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。

返回矩阵中 省份 的数量。



示例 1：


输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
输出：2*/
public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {//测试通过
        boolean[][] isVisited = new boolean[isConnected.length][isConnected[0].length];
        int res = 0;
        for(int i=0;i<isConnected.length;i++){
            boolean flag = true;
            for(int j=0;j<isVisited[i].length;j++){
                if(isVisited[i][j]) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                res++;
                dfs(isConnected,isVisited,i);
            }
        }
        return res;
    }
    public void dfs(int[][] isConnected,boolean[][] isVisited,int cur){//相当于感染函数
        for(int j=0;j<isConnected[cur].length;j++){
            if(isConnected[cur][j]==1&&!isVisited[cur][j]){
                isVisited[cur][j] = true;
                dfs(isConnected,isVisited,j);
            }
        }
    }
}
