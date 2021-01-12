package DFS;

/*
* 面试题 08.10. 颜色填充
编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。

待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。

「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。

请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。



示例：

输入：
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
输出：[[2,2,2],[2,2,0],[2,0,1]]
解释:
初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
* */
public class FloodFill {
    public static void main(String[] args) {//测试成功
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] ints = new FloodFill().floodFill(image, 1, 1, 2);
        System.out.println("ints = " + ints);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(newColor==image[sr][sc]) return image;
        infect(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    public void infect(int[][] image,int sr,int sc,int newColor,int oldColor){//DFS,增加参数进行判断
        image[sr][sc] = newColor;
        if(sr>0&&image[sr-1][sc]==oldColor){
            infect(image,sr-1,sc,newColor,oldColor);
        }
        if(sr<image.length-1&&image[sr+1][sc]==oldColor){
            infect(image,sr+1,sc,newColor,oldColor);
        }
        if(sc>0&&image[sr][sc-1]==oldColor){
            infect(image,sr,sc-1,newColor,oldColor);
        }
        if(sc<image[0].length-1&&image[sr][sc+1]==oldColor){
            infect(image,sr,sc+1,newColor,oldColor);
        }
    }
}
//000
//011