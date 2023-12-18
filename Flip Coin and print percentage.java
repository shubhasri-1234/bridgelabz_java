import java.util.Scanner;

class FlipCoin {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of times to flip the coin: ");
        int numofflips = input.nextInt();

        if (numofflips <= 0) {
            System.out.println("Please enter a positive integer for the number of flips.");
            return;
        }

        int heads = 0;
        int tails = 0;

        for (int i = 0; i < numofflips; i++) {
            // Use Random function to get value between 0 and 1
            double random = Math.random();

            // If the value is less than 0.5, consider it as heads, otherwise tails
            if (random < 0.5) heads++;
            else tails++;
            //The ternary operator is an expression, not a standalone statement.An expression is something that produces a value.
            // (random < 0.5) ? heads++ : tails++;
            
        }

        System.out.println("Heads: " + heads);
        System.out.println("Tails: " + tails);

        // Calculate percentages
        double headsPercentage = (heads * 100.0) / numofflips;
        double tailsPercentage = (tails * 100.0) / numofflips;

        // Output: Percentage of Head vs Tails
        System.out.println("Percentage of Heads: " + headsPercentage + "%");
        System.out.println("Percentage of Tails: " + tailsPercentage + "%");

        //Preventing Resource Locks
        input.close();
    }
}
