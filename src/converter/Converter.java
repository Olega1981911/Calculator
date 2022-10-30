package converter;

public interface Converter {
    int numbersToInt(String number);

    boolean isRoman(String number);

    String intToRoman(int number);
}
