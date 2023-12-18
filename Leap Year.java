import java.util.Scanner;

class Leapyear{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 4-digit year: ");
        int year = input.nextInt();
        boolean isLeapYear = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                // If divisible by 100, also check if divisible by 400
                isLeapYear = year % 400 == 0;
            } else {
                // If not divisible by 100, it's a leap year
                isLeapYear = true;
            }
        }

        if (isLeapYear) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }

        input.close();
    }
}