package calculator_programm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       /* String newOperation = reader.readLine();
        System.out.println(gettingData(newOperation));*/

    }

    public static List<String> gettingData(String string) {
        String[] data = string.split(" ");
        List<String> listOfData = new ArrayList<>();
        if (data.length == 3) {
            if ((Integer.parseInt(data[0]) > 0 && Integer.parseInt(data[0]) < 11) && (Integer.parseInt(data[2]) > 0 && Integer.parseInt(data[2]) < 11)) {
                listOfData.add(data[0]);
                listOfData.add(data[2]);
                listOfData.add(data[1]);
            }
            return listOfData;
        } else if (data.length < 3) {
            System.out.println("throws Exception //т.к. строка не является математической операцией");
        } else {
            System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        return null;
    }

    public static boolean arabNumbersGetting(String str) {
        int[] arabNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < arabNumbers.length; i++) {
            if (Integer.parseInt(str) == arabNumbers[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean romanNumbersGetting(String str) {
        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < romanNumbers.length; i++) {
            if (str.equals(romanNumbers[i])) {
                return true;
            }
        }
        return false;
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
