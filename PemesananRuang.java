import java.util.Scanner;

public class PemesananRuang {
    private String namaMahasiswa;
    private String nimMahasiswa;
    private String namaRuangan;
    private int jumlahOrang;
    private double jumlahJam;
    private String tglPemesanan;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("\nMasukkan data pemesanan ke-" + (i + 1));

            System.out.print("Apakah anda Mahasiswa Polinema? (Iya/Tidak) ");
            String answer = input.next();

            PemesananRuang pemesanan = new PemesananRuang();

            if (answer.equalsIgnoreCase("iya")) {
                System.out.print("Masukkan Nama Pemesan: ");
                pemesanan.setNamaMahasiswa(input.next());
                System.out.print("Masukkan NIM Pemesan: ");
                pemesanan.setNimMahasiswa(input.next());
            } else {
                System.out.println("==============================================");
                System.out.println("=============== Selamat Datang ===============");
                System.out.println("==============================================");
                // Pilihan untuk data non-mahasiswa (opsional)
            }

            System.out.print("Masukkan Nama Ruangan: ");
            pemesanan.setNamaRuangan(input.next());

            System.out.print("Masukkan Jumlah Orang: ");
            pemesanan.setJumlahOrang(input.nextInt());

            System.out.print("Masukkan Jumlah Jam yang ingin dipesan: ");
            pemesanan.setJumlahJam(input.nextDouble());

            System.out.print("Masukkan Tanggal Pemesanan (dd/mm/yyyy): ");
            pemesanan.setTglPemesanan(input.next());

            // ... (lanjutan dari kode Anda)

            // Contoh pemanggilan cetakInfo
            pemesanan.cetakInfo();
        }
    }

    // Setter dan metode lainnya
    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public void setNimMahasiswa(String nimMahasiswa) {
        this.nimMahasiswa = nimMahasiswa;
    }

    public void setNamaRuangan(String namaRuangan) {
        this.namaRuangan = namaRuangan;
    }

    public void setJumlahOrang(int jumlahOrang) {
        this.jumlahOrang = jumlahOrang;
    }

    public void setJumlahJam(double jumlahJam) {
        this.jumlahJam = jumlahJam;
    }

    public void setTglPemesanan(String tglPemesanan) {
        this.tglPemesanan = tglPemesanan;
    }

    // Metode untuk menampilkan informasi pemesanan
    public void cetakInfo() {
        System.out.println("\n=======================================");
        System.out.println("            Detail Pemesanan");
        System.out.println("=======================================");
        System.out.println("Nama Mahasiswa: " + namaMahasiswa);
        System.out.println("NIM Mahasiswa: " + nimMahasiswa);
        System.out.println("Nama Ruangan: " + namaRuangan);
        System.out.println("Jumlah Orang: " + jumlahOrang + " orang");
        System.out.println("Jumlah Jam yang Dipesan: " + jumlahJam + " jam");
        System.out.println("Tanggal Pemesanan: " + tglPemesanan);
    }
}
