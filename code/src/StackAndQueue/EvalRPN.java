package StackAndQueue;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 */
public class EvalRPN {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int a = Integer.parseInt(stack.peek());
                stack.pop();
                int b = Integer.parseInt(stack.peek());
                stack.pop();
                int result = a + b;
                stack.push(String.valueOf(result));
            } else if (token.equals("-")) {
                int a = Integer.parseInt(stack.peek());
                stack.pop();
                int b = Integer.parseInt(stack.peek());
                stack.pop();
                int result = b - a;
                stack.push(String.valueOf(result));
            } else if (token.equals("*")) {
                int a = Integer.parseInt(stack.peek());
                stack.pop();
                int b = Integer.parseInt(stack.peek());
                stack.pop();
                int result = a * b;
                stack.push(String.valueOf(result));
            } else if (token.equals("/")) {
                int a = Integer.parseInt(stack.peek());
                stack.pop();
                int b = Integer.parseInt(stack.peek());
                stack.pop();
                int result = b / a;
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
