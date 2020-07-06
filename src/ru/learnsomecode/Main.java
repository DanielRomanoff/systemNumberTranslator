package ru.learnsomecode;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static BigInteger value = null;
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the original number system (integer from 2 to 36) - ");
            int a = scanner.nextInt();
            if (a > 36 || a < 2) throw new NumberFormatException("The number system is an integer from 2 to 36");
            System.out.print("Enter the target number system (integer from 2 to 36) - ");
            int b = scanner.nextInt();
            if (b > 36 || b < 2) throw new NumberFormatException("The number system is an integer from 2 to 36");
            System.out.print("Enter your number - ");
            String number = scanner.next();
            value = init(number, a);
            System.out.println(value.toString(b));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public static BigInteger init(String number, int radix) {
        String valid = getValues(radix);
        if(number.matches("^["+ valid +"]+$")) {
            return new BigInteger(number, radix);
        }
        else throw new NumberFormatException("In " + radix + "-system allowed numbers is " + valid.toString());
    }

    public static String getValues(int radix) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < radix; i++)
            if(i < 10)
                sb.append(i);
            else {
                sb.append(Character.toChars(i + 87));
            }
        return sb.toString();
    }
}