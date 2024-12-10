package org.example;
import java.util.Scanner;

@FunctionalInterface
interface ValidationRule<T> {
    boolean validate(T input) throws RuntimeException;
}


public class UserRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Welcome to the User Registration System!\n");

        try {

            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();


            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();


            System.out.print("Enter Username: ");
            String username = scanner.nextLine();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();


            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            System.out.print("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
            String dob = scanner.nextLine();

            System.out.println("\nRegistration Details:");
            System.out.println("First Name: " + firstName);
            System.out.print("Last Name: " + lastName);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Email: " + email);
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Date of Birth: " + dob);

            System.out.println("\nRegistration Successful!");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static ValidationRule<String> isFirstNameValid = firstName -> firstName.matches("^[A-Z][a-zA-Z]{2,}");
    static ValidationRule<String> isLastNameValid = lastName -> lastName.matches("^[A-Z][a-zA-Z]{2,}");



    static ValidationRule<String> isPhoneNumberValid = phoneNumber -> phoneNumber.matches("^91\\d{10}$");

    static ValidationRule<String> isPasswordValid = password ->
            password.length() >= 8 &&
                    password.matches(".*[A-Z].*") &&
                    password.matches(".*\\d.*") &&
                    password.matches(".*[!@#$%^&*(),.?\":{}|<>].*") &&
                    password.replaceAll("[^!@#$%^&*(),.?\":{}|<>]", "").length() == 1;



        static ValidationRule<String> isEmailValid = email -> {
            String emailRegex = "^[a-zA-Z0-9]+[a-zA-Z0-9._+-]*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+$";
            return email.matches(emailRegex) &&
                    !email.contains("..") &&
                    !email.endsWith(".") &&
                    email.indexOf('@') == email.lastIndexOf('@') &&
                    email.split("@")[1].matches(".*\\.[a-zA-Z]{2,}$");
        };
}




class InvalidNameException extends RuntimeException {
    public InvalidNameException(String message) {
        super(message);
    }
}


class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

class InvalidPhoneNumberException extends RuntimeException {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

