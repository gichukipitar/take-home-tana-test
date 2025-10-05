package tana;

public class Question3_ClosestMinimums {

    /**
     * Finds the distance between the two closest minimum values in the array
     * @param arr Array of integers (guaranteed to have at least 2 minimums)
     * @return Distance between closest minimums
     */
    public static int distanceBetweenClosestMinimums(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }


        int minDistance = Integer.MAX_VALUE;
        int lastMinIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                if (lastMinIndex != -1) {
                    int distance = i - lastMinIndex;
                    minDistance = Math.min(minDistance, distance);
                }
                lastMinIndex = i;
            }
        }

        return minDistance;
    }

    // Test method
    public static void main(String[] args) {
        // Test case 1: Example from problem
        int[] arr1 = {1, 2, 3, 1, 4, 5, 2};
        System.out.println("Test 1: " + distanceBetweenClosestMinimums(arr1));

        // Test case 2: Multiple minimums close together
        int[] arr2 = {5, 1, 3, 1, 1, 2};
        System.out.println("Test 2: " + distanceBetweenClosestMinimums(arr2));

        // Test case 3: Minimums at start and end
        int[] arr3 = {0, 5, 3, 2, 0};
        System.out.println("Test 3: " + distanceBetweenClosestMinimums(arr3));

        // Test case 4: Negative numbers
        int[] arr4 = {-1, 0, 2, -1, 3};
        System.out.println("Test 4: " + distanceBetweenClosestMinimums(arr4));

        // Test case 5: All same numbers
        int[] arr5 = {2, 2, 2, 2};
        System.out.println("Test 5: " + distanceBetweenClosestMinimums(arr5));
    }
}