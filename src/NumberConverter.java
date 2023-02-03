
import java.util.ArrayList;
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
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i] * (Math.pow(10, digits.length - i - 1));
        }
        newArray.add(sum);
        System.out.println("Base: " + baseTwo + ", Sum: " + sum);
        while(sum > sum % baseTwo) {
            newArray.add(0, sum / baseTwo);
            sum /= baseTwo;
            newArray.set(1, newArray.get(1) % baseTwo);
            //System.out.println(newArray);
            //System.out.println(newArray.size());
        }
        return baseChars(newArray);
    }
    public String[] baseChars(ArrayList<Integer> array) {
        String[] newArray = new String[array.size()];
        for(int i = 0; i < array.size(); i++) {
            newArray[i] = CHAR_DATA.substring(array.get(i), array.get(i) + 1);
        }
        return newArray;
    }
}

