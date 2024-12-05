package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidationTest {
    @ParameterizedTest
    @CsvSource({
            "akshaykawale973@gmail.com, true",
            "akshaykawalegmail.com, false",
            "akshaykawale973@@gmail.com, false",
            "akshaykawale973@.com, false",
            "akshaykawale973@gmail..com, false",
            "akshay.kawale@domain.co.in, true",
            "akshay-kawale@domain.com, true",
            "user@domain.co, true",
            "user@domain, false",
            "@domain.com, false",
            "user@@domain.com, false"
    })
    void testEmailValidation(String email, boolean expected) {
        assertEquals(expected, UserRegistration.isValidEmail(email),
                () -> "Email validation failed for: " + email);
    }
}
