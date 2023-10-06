import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        System.out.println(
                "############################################################################################################################################\n" +
                "############################################################################################################################################\n" +
                "#   ███████╗██╗███████╗████████╗███████╗███╗   ███╗    ██████╗ ███████╗███╗   ██╗ ██████╗  ██████╗  █████╗      ██╗██╗ █████╗ ███╗   ██╗   #\r\n" + 
                "#   ██╔════╝██║██╔════╝╚══██╔══╝██╔════╝████╗ ████║    ██╔══██╗██╔════╝████╗  ██║██╔════╝ ██╔════╝ ██╔══██╗     ██║██║██╔══██╗████╗  ██║   #\r\n" +
                "#   ███████╗██║███████╗   ██║   █████╗  ██╔████╔██║    ██████╔╝█████╗  ██╔██╗ ██║██║  ███╗██║  ███╗███████║     ██║██║███████║██╔██╗ ██║   #\r\n" +
                "#   ╚════██║██║╚════██║   ██║   ██╔══╝  ██║╚██╔╝██║    ██╔═══╝ ██╔══╝  ██║╚██╗██║██║   ██║██║   ██║██╔══██║██   ██║██║██╔══██║██║╚██╗██║   #\r\n" + 
                "#   ███████║██║███████║   ██║   ███████╗██║ ╚═╝ ██║    ██║     ███████╗██║ ╚████║╚██████╔╝╚██████╔╝██║  ██║╚█████╔╝██║██║  ██║██║ ╚████║   #\r\n" + 
                "#   ╚══════╝╚═╝╚══════╝   ╚═╝   ╚══════╝╚═╝     ╚═╝    ╚═╝     ╚══════╝╚═╝  ╚═══╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝ ╚════╝ ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝   #\r\n" + 
                "############################################################################################################################################\n" +
                "############################################################################################################################################\n" +
                "                                                                                                                                    ");

        Scanner scInput = new Scanner(System.in);
        // untuk variable int yang butuh input, taruh sini
        int jmlMasuk, jamLembur;
        char golongan;     
        // untuk variable int yang tidak butuh input, taruh sini       
        int pokok_GajiHarian = 0, uangTunjangan = 0, bonus = 0;   
        double pajak = 0.0, total_Gaji, hasil_akhir;              
        String namaBank = "BRI", noRekening = "123456789098";
        Boolean dataValid = false, transfStatus = false;
        // biar apa? biar kelihatan rapi   
                                                                     
        System.out.print("Masukkan Name\t\t\t\t\t: ");
        String nama = scInput.nextLine();
        System.out.print("(char) Masukkan Golongan\t\t\t: ");
        golongan = Character.toUpperCase(scInput.next().charAt(0));        
        System.out.print("(bilangan real) Masukkan Jumlah Masuk\t\t: ");
        jmlMasuk = scInput.nextInt();        
        System.out.print("(bilangan real) Masukkan Total Jam Lembur\t: ");
        jamLembur = scInput.nextInt();

        scInput.close();

        switch (golongan) {
            case 'A':
                pokok_GajiHarian = 160000;
                uangTunjangan = 100000;
                pajak = 0.02;
                bonus = 50000;
                break;
            case 'B':
                pokok_GajiHarian = 230000;
                uangTunjangan = 200000;
                pajak = 0.04;
                bonus = 100000;
                break;
            case 'C':
                pokok_GajiHarian = 320000;
                uangTunjangan = 280000;
                pajak = 0.06;
                bonus = 200000;
                break;
            case 'D':
                pokok_GajiHarian = 450000;
                uangTunjangan = 350000;
                pajak = 0.08;
                bonus = 250000;
                break;
            default:
            System.out.println("Golongan: "+ golongan + " tidak ada, melanjutkan perhitungan dengan data seadanya");
        }

        total_Gaji = (jmlMasuk * pokok_GajiHarian) + (jamLembur * bonus) + uangTunjangan;
        hasil_akhir = total_Gaji - (total_Gaji * pajak);
        System.out.println("############################################################################################################################################\n");
        System.out.println("Atas nama: " + nama);
        System.out.println("Total Gaji\t\t\t\t\t: Rp."+ (int)hasil_akhir);
        System.out.println("############################################################################################################################################\n"); 
        
        dataValid = namaBank.equalsIgnoreCase("BRI") && noRekening.length() == 12;
        if (dataValid) {
            System.out.println(
                    "Memulai transfer uang sebesar Rp." + (int)hasil_akhir + " ke " + noRekening + "(" + namaBank + ")");
            transfStatus = true;
            System.out.println("#############################################################");
                if (transfStatus){
                    System.out.println("Transfer Berhasil");
                }
                else {
                    System.out.println("Eror: ");
                    System.out.println("Transfer Gagal");
                }
        }
        else
        {
            System.out.println("Data tidak valid! Mohon tijau kembali");
            System.out.println("Nama\t\t: " + nama);
            System.out.println("Nama Bank\t: " + namaBank);
            System.out.println("No Rekening\t: " + noRekening);
        }
    }
}
