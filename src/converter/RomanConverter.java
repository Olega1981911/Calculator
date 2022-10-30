package converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanConverter implements Converter {

    Map<Character, Integer> romanNumber = new HashMap<>();


    {
        romanNumber.put('I', 1);
        romanNumber.put('V', 5);
        romanNumber.put('X', 10);
        romanNumber.put('L', 50);
        romanNumber.put('C', 100);
        romanNumber.put('D', 500);
        romanNumber.put('M', 1000);

    }


    @Override
    public int numbersToInt(String number) {
        int result = number.length() - 1;
        int previous = 0;
        for (int i = result; i >= 0; i--) {
            int current = romanNumber.get(number.charAt(i));
            if (current < previous) {
                result -= current;
            } else {
                result += current;
            }
            previous = current;
        }
        return result;
    }

    @Override
    public boolean isRoman(String number) {

        return romanNumber.containsKey(number.charAt(0));
    }

    @Override
    public String intToRoman(int number) {

        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " т.к. в римской системе нет отрицательных чисел");
        }

        List<RomanNumbers> romanNumerals = RomanNumbers.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumbers currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
