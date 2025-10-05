package tana;

import java.util.*;

public class Question2_firstUniqueProduct {

    /**
     * Finds the first product that occurs only once in the array
     * @param products Array of product names
     * @return First unique product or null if none found
     */
    public static String firstUniqueProduct(String[] products) {
        if (products == null || products.length == 0) {
            return null;
        }

        Map<String, Integer> countMap = new LinkedHashMap<>();

        for (String product : products) {
            countMap.put(product, countMap.getOrDefault(product, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;
    }

    // Test method
    public static void main(String[] args) {
        // Test case 1: Example from problem
        String[] products1 = {"Apple", "Computer", "Apple", "Bag"};
        System.out.println("Test 1: " + firstUniqueProduct(products1));

        // Test case 2: No unique products
        String[] products2 = {"Apple", "Apple", "Bag", "Bag"};
        System.out.println("Test 2: " + firstUniqueProduct(products2));

        // Test case 3: All unique products
        String[] products3 = {"Apple", "Computer", "Bag"};
        System.out.println("Test 3: " + firstUniqueProduct(products3));

        // Test case 4: Single element
        String[] products4 = {"Apple"};
        System.out.println("Test 4: " + firstUniqueProduct(products4));

        // Test case 5: Empty array
        String[] products5 = {};
        System.out.println("Test 5: " + firstUniqueProduct(products5));

        // Test case 6: Null array
        System.out.println("Test 6: " + firstUniqueProduct(null));
    }
}