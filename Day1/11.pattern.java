// 1
// 12
// 123
// 1234
// 12345
import java.util.Scanner;
class Pattern{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = input.nextInt();
        for(int i=0;i<num;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(j+1+" ");
            }
             System.out.println();
        }
        input.close();
    }
}