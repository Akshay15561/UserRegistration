package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {
    @Test
    void testValidFirstName() {

        assertDoesNotThrow(() -> UserRegistration.isfirstValidName("Akshay"),"Valid first name pass validation.");



        assertThrows(InvalidNameException.class, () -> UserRegistration.isfirstValidName("ak"),"first name with less than 3 characters fail.");
        assertThrows(InvalidNameException.class, () -> UserRegistration.isfirstValidName("akshay"),"first name not starting with a capital letter fail.");
    }

    @Test
    void testValidLastName() {

        assertDoesNotThrow(() -> UserRegistration.islastValidName("Kawale"),"Valid first name pass validation.");



        assertThrows(InvalidNameException.class, () -> UserRegistration.islastValidName("Ka"),"first name with less than 3 characters fail.");
        assertThrows(InvalidNameException.class, () -> UserRegistration.islastValidName("kawale"),"first name not starting with a capital letter fail.");
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

        assertDoesNotThrow(() -> UserRegistration.isValidPhoneNumber("919919819801"), "Valid phone number pass validation.");


        assertThrows(InvalidPhoneNumberException.class, () -> UserRegistration.isValidPhoneNumber("91 9919819801"), "Phone number with space fail.");
        assertThrows(InvalidPhoneNumberException.class, () -> UserRegistration.isValidPhoneNumber("91 99198"), "Phone number with less than 10 digits fail.");
    }

    @Test
    void testValidPassword() {

        assertDoesNotThrow(() -> UserRegistration.isValidPassword("Password@1"), "Valid password pass validation.");


        assertThrows(InvalidPasswordException.class, () -> UserRegistration.isValidPassword("pass@1"), "Password with less than 8 characters fail.");
        assertThrows(InvalidPasswordException.class, () -> UserRegistration.isValidPassword("Password1"), "Password without a special character fail.");
        assertThrows(InvalidPasswordException.class, () -> UserRegistration.isValidPassword("Password@@1"), "Password with more than one special character fail.");
        assertThrows(InvalidPasswordException.class, () -> UserRegistration.isValidPassword("password@1"), "Password without an uppercase letter fail.");
        assertThrows(InvalidPasswordException.class, () -> UserRegistration.isValidPassword("PASSWORD@"), "Password without a digit fail.");
    }




}
