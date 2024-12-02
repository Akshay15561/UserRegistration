package org.example;
import java.util.Scanner;


public class UserRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Welcome to the User Registration System!\n");

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        if (!isValidName(firstName)) {
            System.out.println("Invalid First Name\n"+  "It must start with a capital letter and have at least 3 characters");
            return;
        }

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        if (!isValidName(lastName)) {
            System.out.println("Invalid Last Name\n"+  "It must start with a capital letter and have at least 3 characters");
            return;
        }

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        if (!isValidPassword(password)) {
            System.out.println("Invalid Password! It must meet the following rules:");
            System.out.println("1. At least 8 characters long.");
            System.out.println("2. Contain at least one uppercase letter.");
            System.out.println("3. Contain at least one numeric digit.");
            System.out.println("4. Contain exactly one special character (e.g., @, #, $, %, etc.).");
            return;
        }

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        if (!isValidEmail(email)) {
            System.out.println("Invalid Email! Please enter a valid email address.");
            return;
        }

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        if (!isValidPhoneNumber(phoneNumber)) {
            System.out.println("Invalid Phone Number!\n"+" It must follow the format '91 9919819801'.");
            return;
        }

        System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
        String dob = scanner.nextLine();

        System.out.println("\nRegistration Details:");
        System.out.println("First Name: " + firstName);
        System.out.print("Last Name: "+ lastName);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Date of Birth: " + dob);

        System.out.println("\nRegistration Successful!");
    }

    public static boolean isValidName(String firstName) {
        return firstName.matches("^[A-Z][a-zA-Z]{2,}");
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9]+[a-zA-Z0-9._+-]*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+$";
        if (email.contains("..") || email.endsWith(".") || email.contains("@.") || email.indexOf('@') != email.lastIndexOf('@')) {
            return false;
        }

        String[] emailParts = email.split("@");
        if (emailParts.length < 2) {
            return false;
        }
        String domainPart = emailParts[1];
        if (domainPart.startsWith(".") || !domainPart.matches(".*\\.[a-zA-Z]{2,}$")) {
            return false;
        }


        String tld = domainPart.substring(domainPart.lastIndexOf('.') + 1);
        if (tld.matches(".*\\d.*")) {
            return false;
        }
        return email.matches(emailRegex);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^91 \\d{10}$");
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        if (!password.matches(".*\\d.*")) {
            return false;
        }

        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*") || password.replaceAll("[^!@#$%^&*(),.?\":{}|<>]", "").length() != 1) {
            return false;
        }

        return true;
    }



}
