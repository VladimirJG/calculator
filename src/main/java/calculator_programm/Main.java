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
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("10");
        list.add("-");
        System.out.println(typeChecking(list));
        // System.out.println(romanToArab("II"));

    }

    public static List<String> gettingData(String string) {
        String[] data = string.split(" ");
        List<String> listOfData = new ArrayList<>();
        if (data.length == 3) {
            listOfData.add(data[0]);
            listOfData.add(data[2]);
            listOfData.add(data[1]);
            return listOfData;
        } else if (data.length < 3) {
            System.out.println("throws Exception //т.к. строка не является математической операцией");
        } else {
            System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        return null;
    }

    public static int romanToArab(String string) {
        int[] arabNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int translateNum = 0;
        for (int i = 0; i < 10; i++) {
            if (string.equals(romanNumbers[i])) {
                translateNum = arabNumbers[i];
            }
        }
        return translateNum;
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

    public static List<Integer> typeChecking(List<String> listInputData) {
        List<Integer> outputDataList = new ArrayList<>();
        if (checkingTheEnteredValueForMinimumAndMaximum(listInputData.get(0)) && checkingTheEnteredValueForMinimumAndMaximum(listInputData.get(1))) {
            outputDataList.add(0, Integer.parseInt(listInputData.get(0)));
            outputDataList.add(1, Integer.parseInt(listInputData.get(1)));
            return outputDataList;
        } else if (romanNumbersGetting(listInputData.get(0)) && romanNumbersGetting(listInputData.get(1))) {
            outputDataList.add(0, romanToArab(listInputData.get(0)));
            outputDataList.add(1, romanToArab(listInputData.get(1)));
            return outputDataList;
        } else {
            System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
        }
        return null;
    }

    public static void operation(String inputOperation) {
        List<String> listOfData = gettingData(inputOperation);
    }

    public static void operandSelection(String str) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '-') {
                System.out.println(5 + 5);
            }
        }
    }

    public static boolean checkingTheEnteredValueForMinimumAndMaximum(String string) {
        if (!romanNumbersGetting(string) && arabNumbersGetting(string) && Integer.parseInt(string) > 0 && Integer.parseInt(string) < 11) {
            return true;
        } else {
            System.out.println("Введенное значение не соответствует условиям");
        }
        return false;
    }

    public static int plus(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static int division(int a, int b) {
        return a / b;
    }
}
