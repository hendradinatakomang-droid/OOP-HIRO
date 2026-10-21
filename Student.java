public class Student {
    // Constants
    public static final int CURRENT_YEAR = 2026;
    public static final int MAX_STUDENTS = 10;

    // Shared storage (static = belongs to the class)
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int count = 0;

    // Data of each student object
    private String name;
    private String id;
    private String major;
    private int birthYear;
    private double gpa;

    // CONSTRUCTORS

    // Constructor 1: no parameters
    public Student() {
        this.name = "Not Set";
        this.id = "-";
        this.major = "Undeclared";
        this.birthYear = 2000;
        this.gpa = 0.0;
    }

    // Constructor 2: name and ID only
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.major = "Undeclared";
        this.birthYear = 2000;
        this.gpa = 0.0;
    }

    // Constructor 3: full data
    public Student(String name, String id, String major, int birthYear, double gpa) {
        this.name = name;
        this.id = id;
        this.major = major;
        this.birthYear = birthYear;
        this.gpa = gpa;
    }
    
    // Update name
    public void updateName(String name) {
        this.name = name;
    }

    // METHOD OVERLOADING

    // Overload 1: update major
    public void updateData(String major) {
        this.major = major;
    }

    // Overload 2: update GPA
    public void updateData(double gpa) {
        if (isValidGpa(gpa)) {
            this.gpa = gpa;
        } else {
            System.out.println("Error: GPA must be between 0 and 4. GPA was not changed.");
        }
    }

    // Overload 3: update major and GPA
    public void updateData(String major, double gpa) {
        this.major = major;
        updateData(gpa);
    }

    // RETURN METHODS

    // Returns the age
    public int getAge() {
        return CURRENT_YEAR - birthYear;
    }

    // Returns the GPA status as text
    public String getGpaStatus() {
        if (gpa >= 3.5) {
            return "Excellent (Cum Laude)";
        } else if (gpa >= 3.0) {
            return "Good";
        } else {
            return "Needs Improvement";
        }
    }

    // Returns true or false
    public boolean isCumLaude() {
        return gpa >= 3.5;
    }

    // SHOW ONE STUDENT

    public void showData(String title) {
        System.out.println("\n=== " + title + " ===");
        System.out.println("Name       : " + name);
        System.out.println("Student ID : " + id);
        System.out.println("Major      : " + major);
        System.out.println("Age        : " + getAge() + " years");
        System.out.println("GPA        : " + gpa);
        System.out.println("GPA Status : " + getGpaStatus());
        System.out.println("Cum Laude  : " + isCumLaude());
    }

    // STATIC METHODS: VALIDATION

    public static boolean isValidId(String id) {
        return id.length() > 0 && id.length() <= 10;
    }

    public static boolean isValidGpa(double gpa) {
        return gpa >= 0.0 && gpa <= 4.0;
    }

    public static boolean isValidBirthYear(int birthYear) {
        return birthYear >= 1950 && birthYear <= CURRENT_YEAR;
    }

    // STATIC METHODS: MANAGE DATA

    // Add a student (returns false if the storage is full)
    public static boolean insert(Student student) {
        if (count >= MAX_STUDENTS) {
            return false;
        }
        students[count] = student;
        count++;
        return true;
    }

    // Find the position of a student by ID (-1 if not found)
    public static int findIndex(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                return i;
            }
        }
        return -1;
    }

    // Get a student by ID (null if not found)
    public static Student getStudent(String id) {
        int index = findIndex(id);
        if (index == -1) {
            return null;
        }
        return students[index];
    }

    // Delete a student
    public static boolean delete(String id) {
        int index = findIndex(id);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < count - 1; i++) {
            students[i] = students[i + 1];
        }
        students[count - 1] = null;
        count--;
        return true;
    }

    // Show all students
    public static void showAll() {
        if (count == 0) {
            System.out.println("\nNo student data yet.");
            return;
        }
        for (int i = 0; i < count; i++) {
            students[i].showData("STUDENT " + (i + 1));
        }
    }
}