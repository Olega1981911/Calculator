package converter;

public interface Converter {
    //int numbersToInt(String number);
    int romanToInt(String roman);

    boolean isRoman(String number);

    String intToRoman(int number);
}
