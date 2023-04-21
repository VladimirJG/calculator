package calculator_programm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String newOperation = reader.readLine();
        System.out.println(gettingNumericOperands(newOperation));


    }

    public static List<String> gettingData(String string) throws Exception {
        String[] data = string.split(" ");
        List<String> listOfData = new ArrayList<>();
        if (data.length == 3) {
            listOfData.add(data[0]);
            listOfData.add(data[2]);
            listOfData.add(data[1]);
            return listOfData;
        } else if (data.length < 3) {
            throw new Exception("строка не является математической операцией");
        } else if ((minus(romanToArab(data[0]), romanToArab(data[2]))) < 0) {
            throw new Exception("в римской системе нет отрицательных чисел");
        } else {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        }
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

    public static List<Integer> typeChecking(List<String> listInputData) throws Exception {
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
            throw new Exception("используются одновременно разные системы счисления");
        }
    }

    public static List<Integer> gettingNumericOperands(String inputOperation) throws Exception {
        List<String> listOfData = gettingData(inputOperation);
        return typeChecking(listOfData);
    }

    public static void operationCalculate(List<Integer> listOfData, List<String> gettingData) {
        String operator = gettingData.get(2);
        int operand1 = listOfData.get(0);
        int operand2 = listOfData.get(1);
        if (operator.equals("+")) {
            System.out.println(plus(operand1, operand2));
        } else if (operator.equals("-")) {
            System.out.println();
        }
    }

    public static boolean checkingTheEnteredValueForMinimumAndMaximum(String string) {
        if (!romanNumbersGetting(string) && arabNumbersGetting(string) && Integer.parseInt(string) > 0 && Integer.parseInt(string) < 11) {
            return true;
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
