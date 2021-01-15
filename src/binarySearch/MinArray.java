package binarySearch;
/*剑指 Offer 11. 旋转数组的最小数字
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。

示例 1：

输入：[3,4,5,1,2]
输出：1*/
public class MinArray {
    public int minArray(int[] numbers) {//测试通过
        return minArray(numbers,0,numbers.length-1);
    }
    public int minArray(int[] numbers,int left,int right){
        if(left==right){
            return numbers[left];
        }else if(left+1==right){
            return Math.min(numbers[left],numbers[right]);
        }else{
            int mid = left+(right-left)/2;
            int tmp1 = 0;
            if(numbers[left]<numbers[mid-1]){
                tmp1 = numbers[left];
            }else{
                tmp1 = minArray(numbers,left,mid-1);
            }
            int tmp2 = 0;
            if(numbers[mid]<numbers[right]){
                tmp2 = numbers[mid];
            }else{
                tmp2 = minArray(numbers,mid,right);
            }
            return Math.min(tmp1,tmp2);
        }
    }
}
