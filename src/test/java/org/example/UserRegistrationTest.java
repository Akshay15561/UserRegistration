package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {
    @Test
    void testValidFirstName() {

        assertTrue(UserRegistration.isValidName("John"), "Valid first name pass validation.");


        assertFalse(UserRegistration.isValidName("jo"), "First name with less than 3 characters fail.");
        assertFalse(UserRegistration.isValidName("john"), "First name not starting with a capital letter fail.");
    }

    @Test
    void testValidLastName() {

        assertTrue(UserRegistration.isValidName("Doe"), "Valid last name pass validation.");


        assertFalse(UserRegistration.isValidName("do"), "Last name with less than 3 characters fail.");
        assertFalse(UserRegistration.isValidName("doe"), "Last name not starting with a capital letter fail.");
    }

//    @Test
//    void testValidEmail() {
//
//        assertTrue(UserRegistration.isValidEmail("test@example.com"), "Valid email pass validation.");
//
//
//        assertFalse(UserRegistration.isValidEmail("testexample.com"), "Email without '@' fail.");
//        assertFalse(UserRegistration.isValidEmail("test@@example.com"), "Email with multiple '@'  fail.");
//        assertFalse(UserRegistration.isValidEmail("test@.com"), "Email with invalid domain fail.");
//        assertFalse(UserRegistration.isValidEmail("test@example..com"), "Email with consecutive dots fail.");
//    }
    @Test
    void testValidPhoneNumber() {

        assertTrue(UserRegistration.isValidPhoneNumber("919919819801"), "Valid phone number pass validation.");


        assertFalse(UserRegistration.isValidPhoneNumber("91 9919819801"), "Phone number with space fail.");
        assertFalse(UserRegistration.isValidPhoneNumber("91 99198198"), "Phone number with less than 10 digits fail.");
    }

    @Test
    void testValidPassword() {

        assertTrue(UserRegistration.isValidPassword("Password@1"), "Valid password pass validation.");


        assertFalse(UserRegistration.isValidPassword("pass@1"), "Password with less than 8 characters fail.");
        assertFalse(UserRegistration.isValidPassword("Password1"), "Password without a special character fail.");
        assertFalse(UserRegistration.isValidPassword("Password@@1"), "Password with more than one special character fail.");
        assertFalse(UserRegistration.isValidPassword("password@1"), "Password without an uppercase letter fail.");
        assertFalse(UserRegistration.isValidPassword("PASSWORD@"), "Password without a digit fail.");
    }




}
