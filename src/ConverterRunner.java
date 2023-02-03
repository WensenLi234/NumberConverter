import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        boolean validNum = true;
        for(int i = 0; i < number.length(); i++) {
            if(Integer.parseInt(number.substring(i, i+ 1)) >= base) {
                validNum = false;
            }
        }
        int n = Integer.parseInt(number);

        s.close();
        if(validNum) {
            NumberConverter nc = new NumberConverter(n, base);
            int[] digits = nc.getDigits();
            System.out.println("\n\nDigit array: " + Arrays.toString(digits));
            System.out.println("Number: " + nc.displayOriginalNumber());
            if(base == 10) {
                System.out.println(Arrays.toString(nc.convertToBase(2)));
                System.out.println(Arrays.toString(nc.convertToBase(8)));
                System.out.println(Arrays.toString(nc.convertToBase(16)));
            } else if(base == 2) {
                System.out.println(Arrays.toString(nc.convertToBase(8)));
                System.out.println(Arrays.toString(nc.convertToBase(10)));
                System.out.println(Arrays.toString(nc.convertToBase(16)));
            } else {
                System.out.println(Arrays.toString(nc.convertToBase(2)));
                System.out.println(Arrays.toString(nc.convertToBase(10)));
                System.out.println(Arrays.toString(nc.convertToBase(16)));
            }
        } else {
            System.out.println("Your number must not have a digit greater than the base - 1.");
        }
    }
}

