import java.util.Arrays;
import java.util.Scanner;

public class BookingRuangan {
    static String answer;
    static String namMahasiswa;
    static String[] daftarRuangan = { "Graha Polinema", "Graha Theater", "Aula Pertamina", "Auditorium" };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean pesanLagi = true;
        while (pesanLagi) {
            System.out.println("=======================================");
            System.out.println("           Booking Ruangan");
            System.out.println("=======================================");
            System.out.println("Apa yang ingin anda lakukan?");
            System.out.println("1. Urutkan Ruangan");
            System.out.println("2. Periksa ketersediaan ruangan");
            System.out.println("3. Cari ruangan");
            System.out.println("4. Pemesanan");
            System.out.print("Masukkan nomor tindakan (1/2/3/4): ");
            int tindakan = input.nextInt();
            input.nextLine();

            if (tindakan == 1) {
                sortRuangan();
            } else if (tindakan == 3) {
                System.out.print("Masukkan nama ruangan yang ingin dicari: ");
                String ruanganDicari = input.nextLine();
                searchRuangan(ruanganDicari);
            } else if (tindakan == 2) {
                periksaKetersediaanRuangan(input);
            } else if (tindakan == 4) {
                System.out.print("Apakah anda Mahasiswa Polinema? (Iya/Tidak) ");
                answer = input.next();

                if (answer.equalsIgnoreCase("iya")) {
                    System.out.print("Masukkan Nama Pemesan: ");
                    String inputNamMahasiswa = input.next();
                    namMahasiswa = inputNamMahasiswa;
                    pemesananRuangan(input);
                } else {
                    System.out.println("==============================================");
                    System.out.println("=============== Selamat Datang ===============");
                    System.out.println("==============================================");
                    pemesananRuangan(input);
                }
                input.nextLine();

            }

            System.out.print("\nApakah Anda ingin melakukan tindakan lainnya? (iya/tidak): ");
            String jawaban = input.next();
            if (jawaban.equalsIgnoreCase("tidak")) {
                pesanLagi = false;
            }
            input.nextLine();

        }
    }

    public static boolean isNamaRuanganValid(String namaRuangan) {
        for (String ruangan : daftarRuangan) {
            if (ruangan.equalsIgnoreCase(namaRuangan)) {
                return true;
            }
        }
        return false;
    }

    public static void pemesananRuangan(Scanner input) {
        String namaRuangan = input.nextLine();

        if (!isNamaRuanganValid(namaRuangan)) {

            System.out.println("=============================================");
            System.out.println("   Pilihan Gedung   ||   Kapasitas Ruangan   ");
            System.out.println("====================||=======================");
            System.out.println("   Graha Polinema   ||        1000");
            System.out.println("   Graha Theater    ||        200");
            System.out.println("   Aula Pertamina   ||        500");
            System.out.println("   Auditorium       ||        150");
            System.out.println("=============================================");

            System.out.print("Pilih ruangan dari daftar di atas: ");
            namaRuangan = input.nextLine();

            if (!isNamaRuanganValid(namaRuangan)) {
                System.out.println("Nama ruangan masih tidak valid. Pemesanan tidak dapat dilanjutkan.");
                return;
            }
        }

        System.out.print("Masukkan Jumlah Orang: ");
        int jumlahOrang = input.nextInt();

        System.out.print("Masukkan jumlah jam yang ingin dipesan: ");
        double jumlahJam = input.nextDouble();

        System.out.print("Masukkan tanggal pemesanan (dd/mm/yyyy): ");
        String tglPemesanan = input.next();

        // Menghitung diskon bulan
        double diskonBulan = 0.0;
        int bulan = Integer.parseInt(tglPemesanan.split("/")[1]);
        if (bulan >= 1 && bulan <= 4) {
            diskonBulan = 0.1; // Diskon 10% jika pemesanan dilakukan pada bulan Januari hingga April
        }

        // Menghitung total harga
        double hargaPerJam = 30000;
        double totalHarga = hargaPerJam * jumlahJam;
        double jumlahDiskonBulan = totalHarga * diskonBulan;
        totalHarga -= jumlahDiskonBulan;

        // Menghitung harga tambahan berdasarkan kapasitas
        if (jumlahOrang > 500) {
            totalHarga += totalHarga * 0.1; // Tambahan harga 10% jika kapasitas lebih dari 500
        } else if (jumlahOrang > 100) {
            totalHarga += totalHarga * 0.05; // Tambahan harga 5% jika kapasitas lebih dari 100
        }

        System.out.println("\n=======================================");
        System.out.println("            Detail Pemesanan");
        System.out.println("=======================================");
        System.out.println("Nama Mahasiswa: " + answer);
        System.out.println("NIM: " + namMahasiswa);
        System.out.println("Nama Ruangan: " + namaRuangan);
        System.out.println("Jumlah Orang: " + jumlahOrang + " orang");
        System.out.println("Harga per Jam: Rp" + hargaPerJam);
        System.out.println("Jumlah Jam yang Dipesan: " + jumlahJam + " jam");
        System.out.println("Total Harga: Rp" + totalHarga);
    }

    public static void periksaKetersediaanRuangan(Scanner input) {
        System.out.print("Masukkan kapasitas ruangan yang ingin diperiksa: ");
        int kapasitasRuangan = input.nextInt();
        if (kapasitasRuangan > 1000) {
            System.out.println("Ruangan tidak tersedia.");
        } else {
            System.out.println("Ruangan tersedia.");
        }
    }

    public static void searchRuangan(String namaRuanganDicari) {
        boolean ruanganDitemukan = false;

        for (String ruangan : daftarRuangan) {
            if (ruangan.equalsIgnoreCase(namaRuanganDicari)) {
                System.out.println("Ruangan ditemukan : " + ruangan);
                ruanganDitemukan = true;
            }
        }

        if (!ruanganDitemukan) {
            System.out.println("Ruangan tidak ditemukan.");
        }
    }

    public static void sortRuangan() {
        for (int i = 0; i < daftarRuangan.length - 1; i++) {
            for (int j = 0; j < daftarRuangan.length - i - 1; j++) {
                int jumlahOrang1 = getKapasitasRuangan(daftarRuangan[j]);
                int jumlahOrang2 = getKapasitasRuangan(daftarRuangan[j + 1]);

                if (jumlahOrang1 > jumlahOrang2) {
                    String temp = daftarRuangan[j];
                    daftarRuangan[j] = daftarRuangan[j + 1];
                    daftarRuangan[j + 1] = temp;
                }
            }
        }

        System.out.println("\n=======================================");
        System.out.println("|  Daftar Ruangan       || Kapasitas Ruangan |");
        System.out.println("=======================================");
        for (String ruangan : daftarRuangan) {
            System.out.printf("| %-20s  || %-10d\n", ruangan.toUpperCase(), getKapasitasRuangan(ruangan));
        }
    }

    public static int getKapasitasRuangan(String namaRuangan) {
        switch (namaRuangan) {
            case "Graha Polinema":
                return 1000;
            case "Graha Theater":
                return 90;
            case "Aula Pertamina":
                return 150;
            case "Auditorium":
                return 300;
            default:
                return 0;
        }
    }
}
