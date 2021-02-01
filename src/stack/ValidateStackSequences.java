package stack;

import java.util.Stack;

public class ValidateStackSequences {
    public static void main(String[] args) {
        boolean b = new ValidateStackSequences().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2});
        System.out.println("b = " + b);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {//测试通过，如果思路错误，就换思路
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (j < pushed.length) {
            if (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }else{
                stack.push(pushed[j]);
                j++;
            }
        }
        while (!stack.isEmpty() && stack.peek() == popped[i]) {
            stack.pop();
            i++;
        }
        return stack.isEmpty();
    }
}
