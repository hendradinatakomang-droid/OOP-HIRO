public class Main {
    public static void main(String[] args) {
        // --- 1. Uji Coba 3 Jenis Konstruktor ---
        Student s1 = new Student();
        Student s2 = new Student("Ayu", "2515091001");
        Student s3 = new Student("Budi", "2515091002", "Sistem Informasi", 2006, 3.75);

        // Cetak data awal
        s1.showData("DATA MAHASISWA 1 (DEFAULT)");
        s2.showData("DATA MAHASISWA 2 (PARSIAL)");
        s3.showData("DATA MAHASISWA 3 (LENGKAP)");

        // --- 2. Uji Coba Method Overloading ---
        s1.updateData("Informatika", 3.85); // Panggil updateData(String, double)
        s2.updateData("Sistem Informasi"); // Panggil updateData(String)
        s2.updateData(3.40); // Panggil updateData(double)

        // Cetak data setelah diubah
        s1.showData("DATA S1 SETELAH UPDATE");
        s2.showData("DATA S2 SETELAH UPDATE");
    }
}