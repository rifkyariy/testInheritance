import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Kendaraan {
    double konsumsiBahanBakar, kapasitasTangki;

    public Kendaraan(double konsumsiBahanBakar, double kapasitasTangki) {
        this.konsumsiBahanBakar = konsumsiBahanBakar;
        this.kapasitasTangki = kapasitasTangki;
    }

    public double JarakTempuh() {
        // this.jarakTempuh = jarakTempuh;
        return kapasitasTangki/konsumsiBahanBakar;
    }

    public void Tampilkan() {
        System.out.println("Kapasitas Tangki Kendaraan : "+kapasitasTangki+" Liter");
        System.out.println("Konsumsi BBM Kendaraan : "+konsumsiBahanBakar+" Liter/Meter");
        System.out.println("Jarak Tempuh : "+JarakTempuh()+" Meter");
    }
}

class Mobil extends Kendaraan{
    String merk,jenisBBM;

    public Mobil(String merk, String jenisBBM, double konsumsiBahanBakar, double kapasitasTangki) {
        super(konsumsiBahanBakar,kapasitasTangki);
        super.JarakTempuh();
        this.merk = merk;
        this.jenisBBM = jenisBBM;  
    }

    public void Tampilkan() {
        System.out.println("Merk Mobil : "+merk);
        System.out.println("Jenis BBM yang digunakan : "+jenisBBM);
        super.Tampilkan();
    }
}

class Bus extends Kendaraan{
    int jumlahKursi;
    boolean besar = false;

    public Bus(int jumlahKursi, double konsumsiBahanBakar, double kapasitasTangki) {
        super(konsumsiBahanBakar,kapasitasTangki);
        super.JarakTempuh();
        if(jumlahKursi >= 50){
            this.besar = true;
        }
        this.jumlahKursi = jumlahKursi;    
    }

    public void Tampilkan() {
        System.out.println("Jumlah Kursi Bus : "+jumlahKursi+" buah");
        System.out.println("Bus Besar : "+besar);
        super.Tampilkan();
    }
}

class Motor extends Kendaraan{
    String jenisMesin,tahunProduksi;

    public Motor(String jenisMesin, String tahunProduksi, double konsumsiBahanBakar, double kapasitasTangki) {
        super(konsumsiBahanBakar,kapasitasTangki);
        super.JarakTempuh();
        this.jenisMesin = jenisMesin;
        this.tahunProduksi = tahunProduksi; 
        
    }

    public void Tampilkan() {
        System.out.println("Jenis Mesin : "+jenisMesin);
        System.out.println("Tahun Produksi : "+tahunProduksi);
        super.Tampilkan();
    }
}

public class TestKendaraan {
    public static void br() {
        System.out.print("\n");
    }

    public static void message(String type, String message) {
        if(type == "def"){
            System.out.print(message);
        }else if(type == "ln"){
            System.out.println(message);
        }
        
    }

    public static void main(String[] args) {
        int jumlahKursi;
        double kapasitasTangki,konsumsiBahanBakar;
        String merk,jenisBBM,jenisMesin,tahunProduksi;
        
        message("ln","***************MACAM KENDARAAN***************");
        message("ln","* 1. Mobil                                  *");
        message("ln","* 2. Bus                                    *");
        message("ln","* 3. Motor                                  *");
        message("def","Pilihan Anda(pilih angkanya) : ");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try{
            int menu = Integer.parseInt(in.readLine());
            switch(menu){
                case 1 : 
                    message("ln", "***********1. Mobil***********");
                    message("def", "Merk mobilnya : ");
                    merk = in.readLine();
                    
                    message("def", "Jenis BBM : ");
                    jenisBBM = in.readLine();

                    message("def", "Kapasitas Tank Kendaraan : ");
                    kapasitasTangki = Double.parseDouble(in.readLine());

                    message("def", "Konsumsi BBM Kendaraan : ");
                    konsumsiBahanBakar = Double.parseDouble(in.readLine());

                    Mobil car = new Mobil(merk, jenisBBM, konsumsiBahanBakar, kapasitasTangki);
                    message("ln", "--------------------------------");
                    car.Tampilkan();

                    break;
                
                case 2 : 
                    message("ln", "***********2. Bus***********");
                    message("def", "Jumlah Kursi Kendaraan : ");
                    jumlahKursi = Integer.parseInt(in.readLine());

                    message("def", "Kapasitas Tank Kendaraan : ");
                    kapasitasTangki = Double.parseDouble(in.readLine());

                    message("def", "Konsumsi BBM Kendaraan : ");
                    konsumsiBahanBakar = Double.parseDouble(in.readLine());

                    Bus schoolBus = new Bus(jumlahKursi,konsumsiBahanBakar,kapasitasTangki);
                    message("ln", "--------------------------------");
                    schoolBus.Tampilkan();

                    break;
                
                case 3 : 
                    message("ln", "***********3. Motor***********");
                    message("def", "Jenis Mesin : ");
                    jenisMesin = in.readLine();

                    message("def", "Tahun Produksi : ");
                    tahunProduksi = in.readLine();

                    message("def", "Kapasitas Tank Kendaraan : ");
                    kapasitasTangki = Double.parseDouble(in.readLine());

                    message("def", "Konsumsi BBM Kendaraan : ");
                    konsumsiBahanBakar = Double.parseDouble(in.readLine());

                    Motor motobike = new Motor(jenisMesin, tahunProduksi, konsumsiBahanBakar, kapasitasTangki);
                    message("ln", "--------------------------------");
                    motobike.Tampilkan();

                    break;
                
                default :
                    message("ln", "Error , Input Salah");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}