package calculator_programm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String newOperation = reader.readLine();
        String str = "10 - 5";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(String.valueOf(str.charAt(i)));
        }
        System.out.println(list);

    }

    public static int gettingNumbers(String str) {
        int[] arabNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        return 0;
    }

    public static void operandSelection(String str) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '-') {
                System.out.println(5 + 5);
            }
        }
    }

    public static int plus(int a, int b) {
        int res = a + b;
        return res;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        int res = a - b;
        return res;
    }

    public static int multiplication(int a, int b) {
        //напишите тут ваш код
        return a * b;
    }

    public static int division(int a, int b) {
        //напишите тут ваш код
        return a / b;
    }
}
