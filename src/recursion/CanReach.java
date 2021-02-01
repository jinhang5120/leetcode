package recursion;
/*1306. 跳跃游戏 III
这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。

请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。

注意，不管是什么情况下，你都无法跳到数组之外。



示例 1：

输入：arr = [4,2,3,0,3,1,2], start = 5
输出：true
解释：
到达值为 0 的下标 3 有以下可能方案：
下标 5 -> 下标 4 -> 下标 1 -> 下标 3
下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3 */
public class CanReach {
    public static void main(String[] args) {//测试通过
        boolean b = new CanReach().canReach(new int[]{4, 4, 1, 3, 0, 3}, 2);
        System.out.println("b = " + b);
    }
    public boolean canReach(int[] arr, int start) {
        if(arr[start]==0) return true;
        boolean[] isVisited = new boolean[arr.length];
        return canReach(arr,start,isVisited);
    }
    public boolean canReach(int[] arr,int start,boolean[] isVisited){
        isVisited[start] = true;
        boolean res = false;
        if(start+arr[start]<arr.length&&!isVisited[start+arr[start]]){
            if(arr[start+arr[start]]==0){
                return true;
            }
            res = canReach(arr,start+arr[start],isVisited);
            if(res) return res;//dfs,要及时返回
        }
        if(start-arr[start]>=0&&!isVisited[start-arr[start]]){
            if(arr[start-arr[start]]==0){
                return true;
            }
            res = canReach(arr,start-arr[start],isVisited);
            if(res) return res;//dfs,要及时返回
        }
        return res;
    }
}
