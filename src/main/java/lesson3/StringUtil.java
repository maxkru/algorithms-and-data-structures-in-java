package lesson3;

import lesson3.util.Stack;

public class StringUtil {

    public static String reverse(String string) {
//        return new StringBuilder(string).reverse().toString(); - простой метод
//
//        а теперь с использованием стека
        Stack<Character> stack = new Stack<>(string.length());
        for(char c : string.toCharArray()) {
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}
