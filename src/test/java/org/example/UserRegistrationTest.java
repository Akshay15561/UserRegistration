package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {
    @Test
    void testValidFirstName() {

        assertTrue(UserRegistration.isValidName("Akshay"), "Valid first name pass validation.");


        assertFalse(UserRegistration.isValidName("aksha"), "First name with less than 3 characters fail.");
        assertFalse(UserRegistration.isValidName("akshay"), "First name not starting with a capital letter fail.");
    }

    @Test
    void testValidLastName() {

        assertTrue(UserRegistration.isValidName("Kawale"), "Valid last name pass validation.");


        assertFalse(UserRegistration.isValidName("kaw"), "Last name with less than 3 characters fail.");
        assertFalse(UserRegistration.isValidName("kawale"), "Last name not starting with a capital letter fail.");
    }

    @Test
    void testValidEmail() {

        assertTrue(UserRegistration.isValidEmail("akshaykawale973@gmail.com"), "Valid email pass validation.");


        assertFalse(UserRegistration.isValidEmail("akshaykawalegmail.com"), "Email without '@' fail.");
        assertFalse(UserRegistration.isValidEmail("akshaykawale973@@gmail.com"), "Email with multiple '@'  fail.");
        assertFalse(UserRegistration.isValidEmail("akshaykawale973@.com"), "Email with invalid domain fail.");
        assertFalse(UserRegistration.isValidEmail("akshaykawale973@gmail..com"), "Email with consecutive dots fail.");
    }
    @Test
    void testValidPhoneNumber() {

        assertTrue(UserRegistration.isValidPhoneNumber("91 9919819801"), "Valid phone numbe pass validation.");


        assertFalse(UserRegistration.isValidPhoneNumber("919919819801"), "Phone number without space fail.");
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
