package bitManipulation;
/*面试题 16.01. 交换数字
编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。

示例：

输入: numbers = [1,2]
输出: [2,1]*/
public class SwapNumbers {
        public int[] swapNumbers(int[] numbers) {//测试通过，用异或存储中间值
            numbers[0] = numbers[0]^numbers[1];
            numbers[1] = numbers[0]^numbers[1];
            numbers[0] = numbers[0]^numbers[1];
            return numbers;
        }
//a b
//a^b  b
// b   a
}
