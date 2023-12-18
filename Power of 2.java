import java.util.Scanner;

class Power{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter value of N");
        int N = input.nextInt();
         if (N < 0 || N >= 31) {
            System.out.println("N should be in the range 0 <= N < 31.");
            return;
        }
        System.out.println("Powers of 2 table for N = " + N + ":");
        for (int i = 0; i <= N; i++) {
            int result = (int) Math.pow(2, i);
            System.out.println("2^" + i + " = " + result);
        }
        input.close();
    }
}