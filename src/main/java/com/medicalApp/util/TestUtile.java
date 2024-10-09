/**
 * Utility class for test-related constants.
 */
package com.medicalApp.util;

/**
 * Provides static constants for test-related timeouts.
 */
public class TestUtile {

    /**
     * The maximum time allowed for a page to load before a test fails.
     */
    public static long PAGE_LOAD_TIMEOUT = 40;

    /**
     * The maximum time the WebDriver will wait for elements to become visible before a test fails.
     */
    public static long IMPLICIT_WAIT = 40;
}
