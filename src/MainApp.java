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
        int potongan_Gaji, golongan, jmlMasuk, jmlTdkMasuk, pot_Tetap;  // untuk variable int yang butuh input, taruh sini
        int total_Gaji, pokok_Gaji, uangTunjangan;                      // untuk variable int yang tidak butuh input, taruh sini
                                                                        // biar apa? biar kelihatan rapi
        System.out.print("Masukkan Name: ");
        String nama = scInput.nextLine();
        System.out.print("(bilangan real) Masukkan Golongan\t\t: ");
        golongan = scInput.nextInt();
        System.out.print("(bilangan real) Masukkan Jumlah Masuk\t\t: ");
        jmlMasuk = scInput.nextInt();
        System.out.print("(bilangan real) Masukkan Jumlah Tidak Masuk\t: ");
        jmlTdkMasuk = scInput.nextInt();
        System.out.print("(bilangan real) Masukkan Potongan Tetap\t\t: ");
        pot_Tetap = scInput.nextInt();

        switch (golongan) {
            case 1:
                pokok_Gaji = 1500000;
                uangTunjangan = 250000;
                break;
            // case 2 resume here below

        }

        scInput.close();
    }
}
