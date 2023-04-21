package calculator_programm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String newOperation = reader.readLine();
        operationCalculate(newOperation);

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
            throw new Exception("Строка не является математической операцией");
        } else {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
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

    public static String arabToRoman(int num) {
        int[] arabNumbers = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romanNumbers = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int i = 12;
        String translateString = "";
        while (num > 0) {
            while (arabNumbers[i] > num) {
                i--;
            }
            translateString += romanNumbers[i];
            num -= arabNumbers[i];
        }
        return translateString;
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

    public static boolean checkingTheEnteredValueForMinimumAndMaximum(String string) {
        if (!romanNumbersGetting(string) && arabNumbersGetting(string) && Integer.parseInt(string) > 0 && Integer.parseInt(string) < 11) {
            return true;
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


    public static void operationCalculate(String string) throws Exception {
        List<Integer> listOperands = typeChecking(gettingData(string));
        List<String> operatorList = gettingData(string);
        String operator = operatorList.get(2);
        int operand1 = listOperands.get(0);
        int operand2 = listOperands.get(1);
        if (operator.equals("+")) {
            if (ownershipCheck(operatorList)) {
                System.out.println(arabToRoman(plus(operand1, operand2)));
            } else {
                System.out.println(plus(operand1, operand2));
            }
        } else if (operator.equals("-")) {
            int min = minus(operand1, operand2);
            if (min < 0) {
                if (ownershipCheck(operatorList)) {
                    throw new Exception("В римской системе нет отрицательных чисел");
                } else {
                    System.out.println(min);
                }
            } else {
                if (ownershipCheck(operatorList)) {
                    System.out.println(arabToRoman(min));
                } else {
                    System.out.println(min);
                }
            }
        } else if (operator.equals("*")) {
            if (ownershipCheck(operatorList)) {
                System.out.println(arabToRoman(multiplication(operand1, operand2)));
            } else {
                System.out.println(multiplication(operand1, operand2));
            }
        } else if (operator.equals("/")) {
            if (ownershipCheck(operatorList)) {
                System.out.println(arabToRoman(division(operand1, operand2)));
            } else {
                System.out.println(division(operand1, operand2));
            }
        }
    }


    public static boolean ownershipCheck(List<String> gettingData) {
        if (romanNumbersGetting(gettingData.get(0)) && romanNumbersGetting(gettingData.get(1))) {
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
