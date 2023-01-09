
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

    public int[] convertToDecimal() {
        int[] newArray = new int[(int) ((double) digits.length * base / 10 + 0.5) + 1];
        System.out.println(newArray.length);
        for(int i = 0; i < digits.length; i++) {
            int index = newArray.length - 1;
            newArray[index] += digits[digits.length - i - 1] * Math.pow(base, i);
            while(newArray[index] > 9) {
                index --;
                newArray[index] += (newArray[index + 1] - newArray[index + 1] % 10) / 10;
                newArray[index + 1] %= 10;
            }
        }
        return newArray;
    }

    public int[] convertToBinary() {
        int[] newArray = new int[(int) ((double) digits.length * base / 2 + 0.5) + 1];
        System.out.println(newArray.length);
        for(int i = 0; i < digits.length; i++) {
            int index = newArray.length - 1;
            newArray[index] += digits[digits.length - i - 1] * Math.pow(base, i);
            while(newArray[index] > 1) {
                index --;
                newArray[index] += (newArray[index + 1] - newArray[index + 1] % 2) / 2;
                newArray[index + 1] %= 2;
            }
        }
        return newArray;
    }

    public int[] convertToOctal() {
        int[] newArray = new int[(int) ((double) digits.length * base / 8 + 0.5) + 1];
        System.out.println(newArray.length);
        for(int i = 0; i < digits.length; i++) {
            int index = newArray.length - 1;
            newArray[index] += digits[digits.length - i - 1] * Math.pow(base, i);
            while(newArray[index] > 8) {
                index --;
                newArray[index] += (newArray[index + 1] - newArray[index + 1] % 8) / 8;
                newArray[index + 1] %= 8;
            }
        }
        return newArray;
    }
    public String[] convertToBase(int baseTwo) {
        int[] newArray = new int[(int) ((double) digits.length * base / Math.abs(base - baseTwo) + 0.5) + 1];
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
    public String[] convertToHexadecimal() {
        int[] newArray = new int[(int) ((double) digits.length * base / Math.abs(base - 16) + 0.5) + 1];
        System.out.println(newArray.length);
        for(int i = 0; i < digits.length; i++) {
            int index = newArray.length - 1;
            newArray[index] += digits[digits.length - i - 1] * Math.pow(base, i);
            while(newArray[index] > 16) {
                index --;
                newArray[index] += (newArray[index + 1] - newArray[index + 1] % 16) / 16;
                newArray[index + 1] %= 16;
            }
        }
        return baseChars(newArray);
    }
    public String[] baseChars(int[] array) {
        String[] newArray = new String[array.length];
        for(int i = 0; i < array.length; i++) {
            newArray[i] = CHAR_DATA.substring(i, i + 1);
        }
        return newArray;
    }
}

