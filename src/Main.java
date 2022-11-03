import converter.RomanConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String input;
    static RomanConverter converter = new RomanConverter();
    static String[] reg = {"+", "-", "/", "*"};
    static String[] regArg = {"\\+", "-", "/", "\\*"};

    public static String calc(String input) {


        int index = -1;
        for (int i = 0; i < reg.length; i++) {
            if (input.contains(reg[i])) {
                index = i;
            } else if (index == -1) {
                throw new IllegalArgumentException("т.к. строка не является математической операцией");

            }

        }

        String[] numbers = input.split(regArg[index]);
        if (numbers.length > 2) {
            throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        int output = 0;
        if (converter.isRoman(numbers[0]) == converter.isRoman(numbers[1])) {

            boolean isRoman = converter.isRoman(numbers[0]);
            int a, b;

            if (isRoman) {
                a = converter.numbersToInt(numbers[0]);
                b = converter.numbersToInt(numbers[1]);
            } else {
                a = Integer.parseInt(numbers[0]);
                b = Integer.parseInt(numbers[1]);
            }
            if (a <= 0 || a > 10 || b <= 0 || b > 10) {
                throw new IllegalArgumentException("числа должны быть от 1 до 10");
            }
            switch (reg[index]) {
                case "+" -> output = a + b;
                case "-" -> output = a - b;
                case "/" -> output = a / b;
                case "*" -> output = a * b;
                default ->
                        throw new IllegalArgumentException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            if (isRoman) {
                System.out.println(converter.intToRoman(output));

            }

        } else {
            throw new IllegalArgumentException("в выражении одновременно используются арабские и римские цифры");
        }
        return String.valueOf(output);
    }


    public static void main(String[] args) {

        System.out.println("введите математическое выражение:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            input = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(calc(input));

    }
}
