package org.example;
import java.util.Scanner;


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

    public static void isfirstValidName(String firstName) {
        if (!firstName.matches("^[A-Z][a-zA-Z]{2,}")) {
            throw new InvalidNameException("Invalid Name: Must start with a capital letter and have at least 3 characters.");
        }
    }public static void islastValidName(String lastName) {
        if( !lastName.matches("^[A-Z][a-zA-Z]{2,}")){
            throw new InvalidNameException("Invalid Name: Must start with a capital letter and have at least 3 characters.");
        }
    }



    public static void isValidPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("^91\\d{10}$")){
            throw new InvalidPhoneNumberException("Invalid Phone Number: Must follow the format '919919819801'.");
        }
    }

    public static void isValidPassword(String password) {
        if (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*\\d.*") ||
                !password.matches(".*[!@#$%^&*(),.?\":{}|<>].*") ||
                password.replaceAll("[^!@#$%^&*(),.?\":{}|<>]", "").length() != 1) {
            throw new InvalidPasswordException("Invalid Password: Must meet all specified rules.");
        }
    }

    public static boolean isValidEmail(String email) throws InvalidEmailException {
        String emailRegex = "^[a-zA-Z0-9]+[a-zA-Z0-9._+-]*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+$";

        // Check for invalid patterns like "..", ending with ".", etc.
        if (email.contains("..") || email.endsWith(".") || email.contains("@.") || email.indexOf('@') != email.lastIndexOf('@')) {
            throw new InvalidEmailException("Invalid email: " + email);
        }

        // Split the email into username and domain parts
        String[] emailParts = email.split("@");
        if (emailParts.length < 2) {
            throw new InvalidEmailException("Invalid email: " + email);
        }

        String domainPart = emailParts[1];
        if (domainPart.startsWith(".") || !domainPart.matches(".*\\.[a-zA-Z]{2,}$")) {
            throw new InvalidEmailException("Invalid email: " + email);
        }

        // Check if the top-level domain (TLD) contains digits
        String tld = domainPart.substring(domainPart.lastIndexOf('.') + 1);
        if (tld.matches(".*\\d.*")) {
            throw new InvalidEmailException("Invalid email: " + email);
        }

        // Final regex check for email validity
        if (!email.matches(emailRegex)) {
            throw new InvalidEmailException("Invalid email: " + email);
        }
        return email.matches(emailRegex);
    }
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

