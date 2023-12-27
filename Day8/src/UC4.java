import java.util.Arrays;

public class UC4<T extends Comparable<T>> {
    private T x;
    private T y;
    private T z;
    public T[] values;


    // Parameterized constructor
    public UC4(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    

    public UC4(T... values) {
        this.values = values;
    }


    public T value() {
        return UC4.value(values);
    }

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

    public T testMaximum() {
        return UC4.testMaximum(x, y, z);
    }
    
    public static <T extends Comparable<T>> T value(T... values) {

        if (values == null || values.length == 0) {
            System.out.println("At least one value must be provided");
        }

        Arrays.sort(values);
        return values[values.length - 1];

    }

    public void printMax() {
        T max = value();
        System.out.println("Maximum Value: " + max);
    }

    public static void main(String[] args) {
        // Test case using Integer values
        Refactor2<Integer> integerMaximum = new Refactor2<>(3, 7, 1);
        System.out.println("Maximum Integer: " + integerMaximum.testMaximum());

        // Test case using Double values
        UC4<Double> doubleMaximum = new UC4<>(3.5, 7.2, 1.9);
        System.out.println("Maximum Double: " + doubleMaximum.testMaximum());

        // Test case using String values
        UC4<String> stringMaximum = new UC4<>("apple", "banana", "orange");
        System.out.println("Maximum String: " + stringMaximum.testMaximum());

        UC4<Integer> int1 = new UC4<Integer>(10,20,30,40,50);
        UC4<Float> flo1= new UC4<Float>(3.5f, 7.2f, 1.9f, 2.2f, 9.6f);
        UC4<String> str1 = new UC4<String>("Apple", "Orange", "Banana", "Grape", "Kiwi");

        int1.printMax();
        flo1.printMax();
        str1.printMax();
    }
}

