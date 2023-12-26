// In Java, we can reverse a number either by using a for loop, a while loop, or using
// recursion. The simplest way to reverse a number is by using a for loop or a while loop. In
// order to reverse a number, we have to follow the following steps:
// a. We need to calculate the remainder of the number using the modulo
// b. After that, we need to multiply the variable reverse by 10 and add the remainder into
// it.
// c. We then divide the number by 10 and repeat the steps until the number becomes 0.
import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int reversedNumber = reverseNumber(number);

        System.out.println("Reversed number: " + reversedNumber);
        input.close();
    }

    public static int reverseNumber(int num) {
        int reversed = 0;

        while (num != 0) {
            int remainder = num % 10;
            reversed = reversed * 10 + remainder;
            num /= 10;
        }

        return reversed;
    }

}
