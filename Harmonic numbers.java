import java.util.Scanner;
class Harmonic{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter value of N");
        int N = input.nextInt();
        if (N <= 0) {
            System.out.println("N should be greater than 0.");
            return;
        }
        double hvalue = 0.0;
        for(int i=1;i<=N;i++){
            hvalue+=1.0/i;
        }
        System.out.println("The " + N + "th Harmonic Value is: " + hvalue);
        input.close();
    } 
}