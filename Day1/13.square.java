import java.util.Scanner;
class Square{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int N = input.nextInt();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==0 || i==N-1 || j==0 || j==N-1){
                    System.out.print("*");
                }
                else System.out.print(" ");
            }
            System.out.println();
        }
        input.close();
    }
}