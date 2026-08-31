package com.codingshuttle.sathwik.SpringTesting;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;




@DisplayName("Comprehensive JUnit 5 & AssertJ Concepts Test")
class UnderstandingJUnitAndAssertJTest {

    // @BeforeAll: Executed ONCE before all test methods in this class (must be static)
    @BeforeAll
    static void setUpAll() {
        System.out.println("@BeforeAll - Executed once before all tests.");
    }

    // @BeforeEach: Executed BEFORE EACH test method to reset test conditions
    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach - Executed before each test method.");
    }

    // @AfterEach: Executed AFTER EACH test method
    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - Executed after each test method.");
    }

    // @AfterAll: Executed ONCE after all test methods in this class (must be static)
    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll - Executed once after all tests.");
    }

    // @Test: Marks a method as a test method
    // @DisplayName: Sets a custom display name used in IDEs and test reports
    @Test
    @DisplayName("AssertJ - Number Assertions")
    void testNumberAssertions() {
        // Demonstrating AssertJ fluent assertions for numbers
        assertThat(5)
                .isEqualTo(5)
                .isNotEqualTo(10)
                .isGreaterThan(3);
    }

    @Test
    @DisplayName("AssertJ - String Assertions")
    void testStringAssertions() {
        // Demonstrating AssertJ fluent assertions for strings
        assertThat("hello")
                .startsWith("he")
                .endsWith("lo")
                .contains("ell");
    }

    @Test
    @DisplayName("AssertJ - Boolean Assertions")
    void testBooleanAssertions() {
        // Demonstrating AssertJ assertions for boolean values
        assertThat(true).isTrue();
        assertThat(false).isFalse();
    }

    @Test
    @DisplayName("AssertJ - List and Array Assertions")
    void testListAssertions() {
        // Demonstrating AssertJ assertions for collections/lists
        assertThat(List.of("apple", "banana"))
                .contains("apple")
                .doesNotContain("orange")
                .hasSize(2);
    }

    @Test
    @DisplayName("AssertJ - Exception Handling Assertions")
    void testExceptionAssertions() {
        // Demonstrating assertThatThrownBy for verifying exceptions and stack trace details[cite: 1]
        assertThatThrownBy(() -> {
            throw new IllegalArgumentException("Invalid argument");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid argument")
                .hasStackTraceContaining("UnderstandingJUnitAndAssertJTest");
    }

    // @Disabled: Disables a test method so it is skipped during execution[cite: 1]
    @Test
    @Disabled("Skipping this test demonstration as an example of @Disabled")
    @DisplayName("Disabled Test Demonstration")
    void testDisabledExample() {
        System.out.println("This test is disabled and will not run.");
    }
}