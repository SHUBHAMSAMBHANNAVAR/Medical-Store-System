
package com.medicalApp.util;
import java.util.Random;

public class RandomPhoneNumberGenerator {

    // Method to generate a phone number with last 5 digits randomized
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

        // Print the generated unique phone number
       // System.out.println("Generated unique phone number: " + uniquePhoneNumber);
        return uniquePhoneNumber;
    }
}
