/**
 * PersegiPanjang
 */
public class PersegiPanjang {

        public int panjang;
        public int lebar;

        public PersegiPanjang() {
        }

        // Constructor berparameter
        public PersegiPanjang(int p, int l) {
                panjang = p;
                lebar = l;
        }

        public void cetakInfo() {
                System.out.println("Persegi panjang ke-" + panjang + ", panjang: " + panjang + ", lebar: " + lebar
                                + ", luas: " + hitungLuas() + ", keliling: " + hitungKeliling());
        }

        // Method untuk menghitung luas persegi panjang
        public int hitungLuas() {
                return panjang * lebar;
        }

        // Method untuk menghitung keliling persegi panjang
        public int hitungKeliling() {
                return 2 * (panjang + lebar);
        }
}
