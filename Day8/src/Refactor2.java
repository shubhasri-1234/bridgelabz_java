public class Refactor2<T extends Comparable<T>> {
    private T x;
    private T y;
    private T z;

    // Parameterized constructor
    public Refactor2(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Test maximum method
    public T testMaximum() {
        return Refactor2.testMaximum(x, y, z);
    }

    // Static method to find maximum of three values
    public static <T extends Comparable<T>> T testMaximum(T x, T y, T z) {
        T max = x;

        if (y.compareTo(max) > 0) {
            max = y;
        }

        if (z.compareTo(max) > 0) {
            max = z;
        }

        return max;
    }

    public static void main(String[] args) {
        // Test case using Integer values
        Refactor2<Integer> integerMaximum = new Refactor2<>(3, 7, 1);
        System.out.println("Maximum Integer: " + integerMaximum.testMaximum());

        // Test case using Double values
        Refactor2<Double> doubleMaximum = new Refactor2<>(3.5, 7.2, 1.9);
        System.out.println("Maximum Double: " + doubleMaximum.testMaximum());

        // Test case using String values
        Refactor2<String> stringMaximum = new Refactor2<>("apple", "banana", "orange");
        System.out.println("Maximum String: " + stringMaximum.testMaximum());
    }
}

