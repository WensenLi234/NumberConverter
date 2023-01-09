
import java.util.Objects;

public class NumberConverter {
    final String CHAR_DATA = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public String[] convertToBase(int baseTwo) {
        int[] newArray = new int[(int) ((double) digits.length * base / baseTwo + 0.5 + 1)];
        System.out.println(newArray.length);
        for(int i = 0; i < digits.length; i++) {
            int index = newArray.length - 1;
            newArray[index] += digits[digits.length - i - 1] * Math.pow(base, i);
            while(newArray[index] > baseTwo) {
                index --;
                newArray[index] += (newArray[index + 1] - newArray[index + 1] % baseTwo) / baseTwo;
                newArray[index + 1] %= baseTwo;
            }

        }
        return baseChars(newArray);
    }
    public String[] baseChars(int[] array) {
        String[] newArray = new String[array.length];
        for(int i = 0; i < array.length; i++) {
            newArray[i] = CHAR_DATA.substring(array[i], array[i] + 1);
        }
        return newArray;
    }
}

