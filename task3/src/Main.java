import java.io.File;
import java.nio.file.attribute.UserPrincipal;
import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static contact contact = new contact();
    //private static filehandler fileHandler = new filehandler();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        System.out.println("\nContact Management System");
        System.out.print("ENTER YOUR ID : ");
        int userId = getIntInput();
        String user = Integer.toString(userId);
        File dir = new File("D:\\Intellj\\TASK 3");
        String[] files = dir.list();
        boolean found = false;
        for (String file : files) {
            if (file.equals(user)) {
                found = true;
            }
        }
        if (found == false) {
            System.out.print("\nFile not found");
            run = false;
        }

        int choice = 0;
        while (run && (choice != 5)) {
            System.out.print("YOUR MENU:\n1. Add Contact. \n2. View Contacts. \n3. Edit Contact. \n4. Delete Contact. \n5. Exit\n");
            System.out.print("Enter your choice: ");
            choice = getIntInput();

            switch (choice) {
                case 1:
                    addContact(userId);
                    break;

                case 2:
                    viewContacts(userId);
                    break;

                case 3:
                    editContact(userId);
                    break;

                case 4:
                    deleteContact(userId);
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }


    private static void addContact(int userId) {
        System.out.print("ENTER CONTACT NAME : ");
        String name = scanner.next();
        System.out.print("ENTER CONTACT PHONE : ");
        String phone = scanner.next();
        System.out.print("ENTER CONTACT EMAIL : ");
        String email = scanner.next();
        contact.addContact(userId, name, phone, email);
    }

    private static void viewContacts(int userId) {
        contact.viewContacts(userId);
    }

    private static void editContact(int userId) {
        System.out.print("ENTER CONTACT NAME YOU WANT TO EDIT : ");
        String name = scanner.next();
        System.out.print("ENTER THE NEW PHONE : ");
        String new_phone = scanner.next();

        if (contact.editPhone(userId, name, new_phone)) {
            System.out.print("DONE SUCCESFULLY \n");
        } else {
            System.out.print("FAILD :( \n ");
        }
    }

    private static void deleteContact(int userId) {
        System.out.print("ENTER CONTACT NAME YOU WANT TO DELETE : ");
        String name = scanner.next();
        if (contact.deleteContact(userId, name)) {
            System.out.print("DONE SUCCESFULLY \n");
        } else {
            System.out.print("FAILD :( \n ");
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }

    }
}