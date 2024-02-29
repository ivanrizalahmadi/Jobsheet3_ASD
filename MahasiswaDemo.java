import java.util.Scanner;

public class MahasiswaDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int jumlahMahasiswa = 3; // Jumlah mahasiswa yang akan dimasukkan

        Mahasiswa[] arrayMahasiswa = new Mahasiswa[jumlahMahasiswa];

        // Input data mahasiswa
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("\nMasukkan data mahasiswa ke-" + (i + 1));

            System.out.print("Masukkan nama: ");
            String nama = sc.next();

            System.out.print("Masukkan NIM: ");
            String nim = sc.next();

            System.out.print("Masukkan jenis kelamin (L/P): ");
            char jenisKelamin = sc.next().charAt(0);

            System.out.print("Masukkan IPK: ");
            double ipk = sc.nextDouble();

            arrayMahasiswa[i] = new Mahasiswa(nama, nim, jenisKelamin, ipk);
        }

        // Cetak data mahasiswa
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("\nData Mahasiswa ke-" + (i + 1));
            arrayMahasiswa[i].cetakInfo();
        }

        // Hitung rata-rata IPK
        double totalIpk = 0;
        for (Mahasiswa mahasiswa : arrayMahasiswa) {
            totalIpk += mahasiswa.getIpk();
        }
        double rataRataIpk = totalIpk / jumlahMahasiswa;

        System.out.println("\nRata-rata IPK: " + rataRataIpk);
    }
}

class Mahasiswa {
    private String nama;
    private String nim;
    private char jenisKelamin;
    private double ipk;

    public Mahasiswa(String nama, String nim, char jenisKelamin, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jenisKelamin = jenisKelamin;
        this.ipk = ipk;
    }

    public void cetakInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Nim: " + nim);
        System.out.println("Jenis kelamin: " + jenisKelamin);
        System.out.println("Nilai IPK: " + ipk);
    }

    public double getIpk() {
        return ipk;
    }
}
