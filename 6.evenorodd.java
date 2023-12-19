//Java Program to Check Whether a Number is Even or Odd
import java.util.Scanner;
class EvenorOdd{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = input.nextInt();

        if(num%2==0) System.out.print(num + ": is a even number");
        else System.out.print(num + ": is a odd number");
        input.close();
    }
}