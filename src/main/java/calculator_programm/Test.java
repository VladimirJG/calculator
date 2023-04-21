package calculator_programm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] newOperation = reader.readLine().split(" ");

        if (newOperation.length == 2) {
            String firstOperand = newOperation[0];
            String secondOperand = newOperation[2];
            String operator = newOperation[1];

        } else {

            System.out.println("Формат введенных значений не соответствует условиям. Пример: 1 + 1\n Повторите ввод");
        }


    }

}

