public class Refactor1<T extends Comparable<T>> {
    public T findMaximum(T x, T y, T z) {
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
        Refactor1<Integer> finder = new Refactor1<>();
        Refactor1<Float> finder1 = new Refactor1<>();
        Refactor1<String> finder2 = new Refactor1<>();
        // Test case 1: Max Number at 1st Position
        Integer maxFirstPosition = finder.findMaximum(10, 5, 8);
        System.out.println("Max Number at 1st Position: " + maxFirstPosition);

        // Test case 2: Max Number at 2nd Position
        Integer maxSecondPosition = finder.findMaximum(3, 15, 7);
        System.out.println("Max Number at 2nd Position: " + maxSecondPosition);

        // Test case 3: Max Number at 3rd Position
        Integer maxThirdPosition = finder.findMaximum(4, 6, 20);
        System.out.println("Max Number at 3rd Position: " + maxThirdPosition);

        // Test case 1: Max Number at 1st Position
        Float maxFirstPosition1 = finder1.findMaximum(10.5f, 5.3f, 8.9f);
        System.out.println("Max Number at 1st Position: " + maxFirstPosition1);

        // Test case 2: Max Number at 2nd Position
        Float maxSecondPosition1 = finder1.findMaximum(3.2f, 15.7f, 7.1f);
        System.out.println("Max Number at 2nd Position: " + maxSecondPosition1);

        // Test case 3: Max Number at 3rd Position
        Float maxThirdPosition1 = finder1.findMaximum(4.8f, 6.6f, 20.3f);
        System.out.println("Max Number at 3rd Position: " + maxThirdPosition1);

        // Test case 1: Max String at 1st Position
        String maxFirstPosition2 = finder2.findMaximum("Peach", "Apple", "Banana");
        System.out.println("Max String at 1st Position: " + maxFirstPosition2);
        
        // Test case 2: Max String at 2nd Position
        String maxSecondPosition2 = finder2.findMaximum("Apple", "Banana", "Peach");
        System.out.println("Max String at 2nd Position: " + maxSecondPosition2);
        
        // Test case 3: Max String at 3rd Position
        String maxThirdPosition2 = finder2.findMaximum("Apple", "Banana", "Peach");
        System.out.println("Max String at 3rd Position: " + maxThirdPosition2);
        
    }
}
