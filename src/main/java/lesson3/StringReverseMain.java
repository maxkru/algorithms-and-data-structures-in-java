package lesson3;

import lesson3.util.StringUtil;

import java.util.Scanner;

public class StringReverseMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        while(!(line = scanner.nextLine()).isEmpty()) {
            System.out.println(StringUtil.reverse(line));
        }
    }
}
