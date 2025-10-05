package tana;

import java.util.*;

public class Question4_ThreeMostCommon {

    /**
     * Returns the three most common strings in a sentence, in ascending alphabetical order
     * @param sentence Input sentence
     * @return Array of three most common strings (or fewer if less than 3 unique words)
     */
    public static String[] threeMostCommon(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return new String[0];
        }

        // Split sentence into words and count frequencies
        String[] words = sentence.toLowerCase().trim().split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // Create list of words sorted by frequency (descending) then alphabetically
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCount.entrySet());
        sortedEntries.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        });

        // Get top 3 most common words and sort them alphabetically
        List<String> topThree = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sortedEntries.size()); i++) {
            topThree.add(sortedEntries.get(i).getKey());
        }

        Collections.sort(topThree);

        return topThree.toArray(new String[0]);
    }

    // Test method
    public static void main(String[] args) {
        // Test case 1: Example from problem
        String sentence1 = "hi there care to discuss algorithm basis or how to solve algorithm or";
        String[] result1 = threeMostCommon(sentence1);
        System.out.println("Test 1: " + Arrays.toString(result1));

        // Test case 2: Less than 3 unique words
        String sentence2 = "hello world hello";
        String[] result2 = threeMostCommon(sentence2);
        System.out.println("Test 2: " + Arrays.toString(result2));

        // Test case 3: All words appear once
        String sentence3 = "apple banana cherry date";
        String[] result3 = threeMostCommon(sentence3);
        System.out.println("Test 3: " + Arrays.toString(result3));

        // Test case 4: Empty sentence
        String sentence4 = "";
        String[] result4 = threeMostCommon(sentence4);
        System.out.println("Test 4: " + Arrays.toString(result4));

        // Test case 5: Case sensitivity test
        String sentence5 = "Hello hello HELLO world World";
        String[] result5 = threeMostCommon(sentence5);
        System.out.println("Test 5: " + Arrays.toString(result5));
    }
}