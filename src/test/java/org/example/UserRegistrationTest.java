package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {
    @Test
    void testValidFirstName() {

        assertTrue(UserRegistration.isFirstNameValid.validate("Akshay"));

        assertFalse(UserRegistration.isFirstNameValid.validate("ak"));
        assertFalse(UserRegistration.isFirstNameValid.validate("akshay"));
    }

    @Test
    void testValidLastName() {

        assertTrue(UserRegistration.isLastNameValid.validate("Kawale"));

        assertFalse(UserRegistration.isLastNameValid.validate("Ka"));
        assertFalse(UserRegistration.isLastNameValid.validate("kawale"));
    }

    @Test
    void testValidPhoneNumber() {

        assertTrue(UserRegistration.isPhoneNumberValid.validate("919919819801"));

        assertFalse(UserRegistration.isPhoneNumberValid.validate("91 9919819801"));
        assertFalse(UserRegistration.isPhoneNumberValid.validate("91 99198"));
    }

    @Test
    void testValidPassword() {

        assertTrue(UserRegistration.isPasswordValid.validate("Password@1"));

        assertFalse(UserRegistration.isPasswordValid.validate("pass@1"));
        assertFalse(UserRegistration.isPasswordValid.validate("Password1"));
        assertFalse(UserRegistration.isPasswordValid.validate("Password@@1"));
        assertFalse(UserRegistration.isPasswordValid.validate("password@1"));
        assertFalse(UserRegistration.isPasswordValid.validate("PASSWORD@"));
    }




}
