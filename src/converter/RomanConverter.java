package converter;


import java.util.List;

import java.util.regex.Pattern;

public class RomanConverter implements Converter {
    private static final Pattern romanPattern = Pattern.compile("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");


    @Override
    public int romanToInt(String roman) {
        int result = 0;
        List<RomanNumbers> romanNumerals = RomanNumbers.getReverseSortedValues();
        int i = 0;
        while ((roman.length() > 0) && (i < romanNumerals.size())) {
            RomanNumbers symbol = romanNumerals.get(i);
            if (roman.startsWith(symbol.name())) {
                result += symbol.getValue();
                roman = roman.substring(symbol.name().length());
            } else {
                i++;
            }

        }
        return result;
    }


    @Override
    public boolean isRoman(String number) {


        return romanPattern.matcher(number).matches();
    }

    @Override
    public String intToRoman(int number) {

        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " т.к. в римской системе нет отрицательных чисел");
        }

        List<RomanNumbers> romanNumerals = RomanNumbers.getReverseSortedValues();

        int i = 0;
        StringBuilder result = new StringBuilder();
        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumbers currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                result.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return result.toString();
    }
}
