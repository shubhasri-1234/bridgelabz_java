public class UC4<T extends Comparable<T>> {
    private T x;
    private T y;
    private T z;

    // Parameterized constructor
    public UC4(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Test maximum method
    public T testMaximum() {
        return UC4.testMaximum(x, y, z);
    }

    // Static method to find maximum of n values
    public static <T extends Comparable<T>> T testMaximum(T... values) {
        if (values.length == 0) {
            System.out.println("No values provided");
        }

        T max = values[0];

        for (T value : values) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        // Test case using Integer values
       UC4<Integer> integerMaximum = new UC4<>(3, 7, 1);
        System.out.println("Maximum Integer: " + integerMaximum.testMaximum());

        // Test case using Double values
        UC4<Double> doubleMaximum = new UC4<>(3.5, 7.2, 1.9);
        System.out.println("Maximum Double: " + doubleMaximum.testMaximum());

        // Test case using String values
        UC4<String> stringMaximum = new UC4<>("apple", "banana", "orange");
        System.out.println("Maximum String: " + stringMaximum.testMaximum());

        // Test case with more parameters
        // Test case with more parameters
        UC4<Integer> extendedIntegerMaximum = new UC4<>(5, 8, 3);
        System.out.println("Extended Maximum Integer: " + extendedIntegerMaximum.testMaximum(12, 7, 2));

    }
}
