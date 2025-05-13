import java.util.Scanner;

class Pelanggan {
    private String nama;
    private String noHp;
    private String alamat;

    public Pelanggan(String nama, String noHp, String alamat) {
        this.nama = nama;
        this.noHp = noHp;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getAlamat() {
        return alamat;
    }
}

// Superclass
class Laptop {
    String merek;
    String prosesor;
    int ram;
    double harga;

    public Laptop(String merek, String prosesor, int ram, double harga) {
        this.merek = merek;
        this.prosesor = prosesor;
        this.ram = ram;
        this.harga = harga;
    }

    public void tampilkanSpesifikasi() {
        System.out.println("Merek     : " + merek);
        System.out.println("Prosesor  : " + prosesor);
        System.out.println("RAM       : " + ram + "GB");
        System.out.println("Harga     : Rp" + harga);
    }
}

// Turunan pertama
class LaptopGaming extends Laptop {
    String gpu;

    public LaptopGaming(String merek, String prosesor, int ram, double harga, String gpu) {
        super(merek, prosesor, ram, harga);
        this.gpu = gpu;
    }

    @Override
    public void tampilkanSpesifikasi() {
        super.tampilkanSpesifikasi();
        System.out.println("GPU       : " + gpu);
    }
}

// Turunan kedua (cucu)
class LaptopGamingRGB extends LaptopGaming {
    boolean rgbKeyboard;

    public LaptopGamingRGB(String merek, String prosesor, int ram, double harga, String gpu, boolean rgbKeyboard) {
        super(merek, prosesor, ram, harga, gpu);
        this.rgbKeyboard = rgbKeyboard;
    }

    @Override
    public void tampilkanSpesifikasi() {
        super.tampilkanSpesifikasi();
        System.out.println("RGB Keyboard: " + (rgbKeyboard ? "Ya" : "Tidak"));
    }
}

public class PembelianLaptop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input data pelanggan
        System.out.print("Masukkan nama Anda   : ");
        String nama = input.nextLine();

        System.out.print("Masukkan no HP Anda  : ");
        String noHp = input.nextLine();

        System.out.print("Masukkan alamat Anda : ");
        String alamat = input.nextLine();

        Pelanggan pelanggan = new Pelanggan(nama, noHp, alamat);

        // Daftar laptop (menggunakan array)
        Laptop[] daftarLaptop = new Laptop[3];
        daftarLaptop[0] = new Laptop("ASUS", "Intel i5", 8, 8.500000);
        daftarLaptop[1] = new LaptopGaming("MSI", "Intel i7", 16, 15.000000, "NVIDIA RTX 3060");
        daftarLaptop[2] = new LaptopGamingRGB("Acer Predator", "Intel i9", 32, 25.000000, "RTX 4080", true);

        // Menampilkan pilihan laptop
        System.out.println("\n=== Daftar Laptop Tersedia ===");
        for (int i = 0; i < daftarLaptop.length; i++) {
            System.out.println("\nLaptop ke-" + (i + 1));
            daftarLaptop[i].tampilkanSpesifikasi();
        }

        // Memilih laptop
        System.out.print("\nPilih nomor laptop yang ingin dibeli (1-3): ");
        int pilihanLaptop = input.nextInt();
        input.nextLine(); // clear buffer

        System.out.println("\n=== DETAIL PEMBELIAN ===");
        System.out.println("Nama     : " + pelanggan.getNama());
        System.out.println("No HP    : " + pelanggan.getNoHp());
        System.out.println("Alamat   : " + pelanggan.getAlamat());
        System.out.println("Laptop Dipilih:");
        daftarLaptop[pilihanLaptop - 1].tampilkanSpesifikasi();

        input.close();
    }
}
