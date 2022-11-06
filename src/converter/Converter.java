package converter;

public interface Converter {
    //int numbersToInt(String number);
    int romanToInt(String number);

    boolean isRoman(String number);

    String intToRoman(int number);
}
