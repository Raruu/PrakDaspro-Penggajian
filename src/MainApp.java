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
        int potongan_Gaji, jmlMasuk, jmlTdkMasuk, pot_Tetap;
        char golongan;     
        // untuk variable int yang tidak butuh input, taruh sini       
        int total_Gaji, pokok_Gaji, uangTunjangan;                      
        // biar apa? biar kelihatan rapi   
                                                                     
        System.out.print("Masukkan Name: ");
        String nama = scInput.nextLine();
        System.out.print("(bilangan real) Masukkan Golongan\t\t: ");
        golongan = scInput.next().charAt(0);
        System.out.print("(bilangan real) Masukkan Jumlah Masuk\t\t: ");
        jmlMasuk = scInput.nextInt();
        System.out.print("(bilangan real) Masukkan Jumlah Tidak Masuk\t: ");
        jmlTdkMasuk = scInput.nextInt();
        System.out.print("(bilangan real) Masukkan Potongan Tetap\t\t: ");
        pot_Tetap = scInput.nextInt();

        switch (golongan) {
            case 'A':
                pokok_Gaji = 1500000;
                uangTunjangan = 250000;
                break;
            case 'B':
                pokok_Gaji = 2000000;
                uangTunjangan = 3000000;
                break;
            case 'C':
                pokok_Gaji = 2500000;
                uangTunjangan = 3500000;
                break;
            case 'D'
                pokok_Gaji = 3000000;
                uangTunjangan = 4000000;
                break;

        }

        scInput.close();
    }
}
