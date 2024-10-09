
package com.medicalApp.util;

import java.util.Random;

/**
 * Utility class for generating random phone numbers.
 * Provides a method to generate unique phone numbers based on a given base phone number.
 */
public class RandomPhoneNumberGenerator {

    /**
     * Generates a unique phone number by randomizing the last 5 digits of the provided base phone number.
     *
     * @param basePhoneNumber The base phone number to use as a starting point.
     * @return The generated unique phone number.
     * @throws IllegalArgumentException if the base phone number has less than or equal to 5 digits.
     */
    public static String generateUniquePhoneNumber(String basePhoneNumber) {
        // Check if the phone number has enough length (more than 5 digits)
        if (basePhoneNumber.length() <= 5) {
            throw new IllegalArgumentException("Base phone number must have more than 5 digits");
        }

        // Generate a random 5-digit number
        Random randomnum = new Random();
        int randomLastFive = 10000 + randomnum.nextInt(90000); // Ensures it's a 5-digit number

        // Get the first part of the phone number (excluding the last 5 digits)
        String initialPart = basePhoneNumber.substring(0, basePhoneNumber.length() - 5);

        // Concatenate the initial part with the random 5 digits
        String uniquePhoneNumber = initialPart + randomLastFive;

        // Print the generated unique phone number (optional)
        // System.out.println("Generated unique phone number: " + uniquePhoneNumber);

        return uniquePhoneNumber;
    }
}