public class Question1_GetLongestString {
    /**
     * Returns the longest string that has non-repetitive characters and
     * contains only valid characters from the given list
     * @param characters List of valid characters
     * @param strings Array of strings to check
     * @return Longest valid string or empty string if none found
     */
    public static String getLongestString(String characters, String[] strings) {
        String longestValid = "";
        Set<Character> validChars = new HashSet<>();

        // Store valid characters in a set for O(1) lookup
        for (char c : characters.toCharArray()) {
            validChars.add(c);
        }

        for (String str : strings) {
            if (isValidString(str, validChars) && str.length() > longestValid.length()) {
                longestValid = str;
            }
        }

        return longestValid;
    }

    /**
     * Checks if a string has no repetitive consecutive characters and
     * contains only valid characters
     */
    private static boolean isValidString(String str, Set<Character> validChars) {
        if (str.length() <= 1) return true;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            // Check if character is valid
            if (!validChars.contains(currentChar)) {
                return false;
            }

            // Check for consecutive identical characters
            if (i > 0 && str.charAt(i-1) == currentChar) {
                return false;
            }
        }

        return true;
    }

    // Test method
    public static void main(String[] args) {
        // Test case 1: Example from problem
        String characters1 = "ABCD";
        String[] strings1 = {"AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA"};
        System.out.println("Test 1: " + getLongestString(characters1, strings1)); // Expected: ABCDABDCA

        // Test case 2: No valid strings
        String characters2 = "AB";
        String[] strings2 = {"AAB", "XYZ", "AABB"};
        System.out.println("Test 2: " + getLongestString(characters2, strings2)); // Expected: ""

        // Test case 3: Single character strings
        String characters3 = "ABC";
        String[] strings3 = {"A", "B", "C", "AA"};
        System.out.println("Test 3: " + getLongestString(characters3, strings3)); // Expected: A, B, or C

        // Test case 4: Empty array
        String characters4 = "ABC";
        String[] strings4 = {};
        System.out.println("Test 4: " + getLongestString(characters4, strings4)); // Expected: ""
    }
}
