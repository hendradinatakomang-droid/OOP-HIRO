public class Student {
    // Variabel bawaan class (Constant)
    public static final int CURRENT_YEAR = 2026;

    // Instance variables (Data milik setiap objek)
    private String name;
    private String id;
    private String major;
    private int birthYear;
    private double gpa;

    // CONSTRUCTORS
    // Konstruktor 1: Tanpa parameter
    public Student() {
        this.name = "Belum Diisi";
        this.id = "-";
        this.major = "Belum Dipilih";
        this.birthYear = 2000;
        this.gpa = 0.0;
    }

    // Konstruktor 2: Nama dan ID saja
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.major = "Belum Dipilih";
        this.birthYear = 2000;
        this.gpa = 0.0;
    }

    // Konstruktor 3: Parameter lengkap
    public Student(String name, String id, String major, int birthYear, double gpa) {
        this.name = name;
        this.id = id;
        this.major = major;
        this.birthYear = birthYear;
        this.gpa = gpa;
    }

    // METHOD OVERLOADING
    // Overload 1: Ubah jurusan
    public void updateData(String major) {
        this.major = major;
    }

    // Overload 2: Ubah IPK
    public void updateData(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        }
    }

    // Overload 3: Ubah jurusan dan IPK
    public void updateData(String major, double gpa) {
        this.major = major;
        this.gpa = gpa;
    }

    // RETURN METHODS
    // Menghitung umur
    public int getAge() {
        return CURRENT_YEAR - birthYear;
    }

    // Tentukan status IPK
    public String getGpaStatus() {
        if (gpa >= 3.5) {
            return "Sangat Memuaskan (Cum Laude)";
        } else if (gpa >= 3.0) {
            return "Memuaskan";
        } else {
            return "Perlu Perbaikan";
        }
    }

    // Cek apakah Cum Laude (mengembalikan nilai boolean)
    public boolean isCumLaude() {
        return gpa >= 3.5;
    }

    // METHOD MENAMPILKAN DATA
    public void showData(String title) {
        System.out.println("\n=== " + title + " ===");
        System.out.println("Nama Mahasiswa : " + name);
        System.out.println("NIM / ID       : " + id);
        System.out.println("Program Studi  : " + major);
        System.out.println("Usia           : " + getAge() + " Tahun");
        System.out.println("IPK            : " + gpa);
        System.out.println("Status IPK     : " + getGpaStatus());
        System.out.println("Cum Laude      : " + isCumLaude());
    }
}