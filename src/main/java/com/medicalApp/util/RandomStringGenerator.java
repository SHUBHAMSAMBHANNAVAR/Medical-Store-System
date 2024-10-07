package com.medicalApp.util;

import java.util.Random;

/**
 * Utility class for generating random strings.
 */
public class RandomStringGenerator {

    /**
     * Generates a random string of the specified length using lowercase letters.
     *
     * @param length The length of the random string to be generated.
     * @return A random string consisting of lowercase letters of the specified length.
     */
    public static String generateRandomString(int length) {
        // Define the characters to choose from (lowercase letters)
        String chars = "abcdefghijklmnopqrstuvwxyz"; // Only lowercase letters
        Random random = new Random(); // Create a Random instance for generating random values  //26^3=26×26×26=17,576
        StringBuilder sb = new StringBuilder(length); // Initialize a StringBuilder to construct the random string

        // Loop to append random characters to the StringBuilder
        for (int i = 0; i < length; i++) {
            // Append a random character from the chars string to the StringBuilder
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        // Return the generated random string
        return sb.toString();
    }
}
