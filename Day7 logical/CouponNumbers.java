import java.util.HashSet;
import java.util.Set;

public class CouponNumbers {

    // Function to generate a random coupon number
    private static int generateRandomCoupon(int numberOfCoupons) {
        return (int) (Math.random() * numberOfCoupons) + 1;
    }

    // Function to generate distinct coupons
    private static int generateDistinctCoupons(int numberOfCoupons) {
        Set<Integer> distinctCoupons = new HashSet<>();
        int totalRandomNumbers = 0;

        while (distinctCoupons.size() < numberOfCoupons) {
            int randomCoupon = generateRandomCoupon(numberOfCoupons);
            distinctCoupons.add(randomCoupon);
            totalRandomNumbers++;
        }

        return totalRandomNumbers;
    }

    public static void main(String[] args) {
        // Example: Generate distinct coupons for 10 different coupons
        int numberOfCoupons = 10;
        int totalRandomNumbers = generateDistinctCoupons(numberOfCoupons);

        System.out.println("Total random numbers needed to have all distinct coupons: " + totalRandomNumbers);
    }
}
