import java.util.Scanner;

class Factors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find its prime factors: ");
        int N = scanner.nextInt();
        int x=0;

        System.out.print("Prime factors of " + N + ": ");
        for (int i = 2; i * i <= N; i++) {
            while (N % i == 0){
                if(i>x){
                System.out.print(i + " ");
                x=i;
                }
                N /= i;
            }
        }
        if(N > 1) {
            System.out.print(N);
        }
        scanner.close();
    }
}
