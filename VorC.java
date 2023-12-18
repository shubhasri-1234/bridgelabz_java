//Java Program to Check Whether an Alphabet is Vowel or Consonant
import java.util.Scanner;
class VorC{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Alphabet: ");
        char ch= input.next().charAt(0);

        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                System.out.println(ch + " is a Vowel.");
            } else {
                System.out.println(ch + " is a Consonant.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid alphabet.");
        }
        input.close();
    }
}