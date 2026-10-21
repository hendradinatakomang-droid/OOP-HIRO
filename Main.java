import java.util.Scanner;

public class Main {
    // One Scanner shared by all methods
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Starting data: tests the 3 constructors
        Student.insert(new Student());
        Student.insert(new Student("Rama", "2515091074"));
        Student.insert(new Student("Indra", "2515091107", "Information Systems", 2006, 3.75));

        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInt("Choose a menu (1-5): ");

            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                Student.showAll();
            } else if (choice == 3) {
                editStudent();
            } else if (choice == 4) {
                deleteStudent();
            } else if (choice == 5) {
                System.out.println("Thank you");
                running = false;
            } else {
                System.out.println("Error: Menu not available.");
            }
        }

        input.close();
    }

    // MENU

    static void showMenu() {
        System.out.println("\nSTUDENT DATA MENU");
        System.out.println("1. Add data");
        System.out.println("2. Show all data");
        System.out.println("3. Edit data");
        System.out.println("4. Delete data");
        System.out.println("5. Exit");
    }

    static void addStudent() {
        System.out.println("\nADD DATA");
        String name = readText("Enter name: ");

        String id = "";
        boolean validId = false;
        while (!validId) {
            id = readText("Enter student ID (max 10 characters): ");
            if (!Student.isValidId(id)) {
                System.out.println("Error: ID must be 1 to 10 characters.");
            } else {
                validId = true;
            }
        }

        String major = readText("Enter major: ");
        int birthYear = readBirthYear();
        double gpa = readGpa();

        Student student = new Student(name, id, major, birthYear, gpa);
        if (Student.insert(student)) {
            System.out.println("Data added successfully.");
        } else {
            System.out.println("Error: Storage is full (maximum " + Student.MAX_STUDENTS + " students).");
        }
    }

    static void editStudent() {
        System.out.println("\nEDIT DATA");
        String id = readText("Enter the student ID to edit: ");
        Student student = Student.getStudent(id);

        if (student == null) {
            System.out.println("Error: ID not found.");
            return;
        }

        System.out.println("1. Change major");
        System.out.println("2. Change GPA");
        System.out.println("3. Change major and GPA");
        int choice = readInt("Choose (1-3): ");

        if (choice == 1) {
            student.updateData(readText("New major: "));
        } else if (choice == 2) {
            student.updateData(readGpa());
        } else if (choice == 3) {
            String major = readText("New major: ");
            student.updateData(major, readGpa());
        } else {
            System.out.println("Error: Option not available.");
            return;
        }

        student.showData("DATA AFTER EDIT");
    }

    static void deleteStudent() {
        System.out.println("\nDELETE DATA");
        String id = readText("Enter the student ID to delete: ");

        if (Student.delete(id)) {
            System.out.println("Data deleted successfully.");
        } else {
            System.out.println("Error: ID not found.");
        }
    }

    // INPUT HELPERS

    static String readText(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    static int readInt(String prompt) {
        int value = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                value = input.nextInt();
                input.nextLine();
                valid = true;
            } else {
                System.out.println("Error: Please enter a valid number.");
                input.nextLine();
            }
        }
        return value;
    }

    static int readBirthYear() {
        int year = 0;
        boolean valid = false;
        while (!valid) {
            year = readInt("Enter birth year: ");
            if (Student.isValidBirthYear(year)) {
                valid = true;
            } else {
                System.out.println("Error: Birth year must be between 1950 and " + Student.CURRENT_YEAR + ".");
            }
        }
        return year;
    }

    static double readGpa() {
        double gpa = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter GPA (0.0 - 4.0): ");
            if (input.hasNextDouble()) {
                gpa = input.nextDouble();
                input.nextLine();
                if (Student.isValidGpa(gpa)) {
                    valid = true;
                } else {
                    System.out.println("Error: GPA must be between 0 and 4.");
                }
            } else {
                System.out.println("Error: Please enter a valid number.");
                input.nextLine();
            }
        }
        return gpa;
    }
}