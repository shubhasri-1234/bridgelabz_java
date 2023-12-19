//Java Program to Compute Quotient and Remainder
import java.util.Scanner;
class QandR{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter value of N which is to be divided");
        int N = input.nextInt();
        System.out.println("Enter value of M which is dividing N");
        int M = input.nextInt();
        System.out.println("Quotient: " + N/M);
        System.out.println("Remainder: " + N%M);
        input.close();

    }
}