//Java Program to Find the Largest Among Three Numbers
import java.util.Scanner;
class Largest{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = input.nextInt();

        System.out.print("Enter the third number: ");
        int num3 = input.nextInt();

        int largest = num1; 

        if (num2 > largest) {
            largest = num2; 
        }
        if (num3 > largest) {
            largest = num3; 
        }
        System.out.print("Largest number is : "+ largest);

        input.close();
    }
}