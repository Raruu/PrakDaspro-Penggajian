import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        final String PagarPemisah = "###".repeat(47); 
        final Scanner scInput = new Scanner(System.in);        
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
       
        // untuk variable int yang butuh input, taruh sini
        int jmlMasuk, jamLembur;
        char golongan;     

        // untuk variable int yang tidak butuh input, taruh sini       
        int pokok_GajiHarian = 0, uangTunjangan = 0, bonus = 0;   
        double pajak = 0.0, total_Gaji, hasil_akhir;              
        String namaBank = "BRI", noRekening = "123456789098";
        Boolean dataValid = false, transfStatus = false, login = false;
        // Karyawan
        String[] nama_Karyawan = { "Farhan Kebab", "Rian Batagor",  "Rusdy Ambatukan", "Slamet Kopling", "Vivo"};
        String[] noRekening_Karyawan = {"1234567890987", "1234567890987654", "1234567890", "1234567890", "1234567890"};
        String[] bank_Karyawan = {"Mandiri", "BTN", "BSI", "BSI", "BSI"};
        String[] username = {"admin"};
        String[] password = {"123456"};
        int index_Karyawan = 0;

        // Login
        while(login == false) 
        {
            System.out.println("------LOGIN------");
            System.out.println("Tekan CTRL+C untuk keluar program");
            System.out.print("\nUsername: ");
            String usernameInput = scInput.next();
            System.out.print("\nPassword: ");
            String passwordInput = scInput.next();

            for (int x = 0; x < username.length; x++)
            {
                if (usernameInput.equals(username[x]) && passwordInput.equals(password[x])) 
                {
                    login = true;
                    System.out.println("\n------LOGIN BERHASIL------");
                    System.out.println("\n----*SELAMAT DATANG "+username[x]+"*----");
                }
                else
                {
                    System.out.println("\nUsername atau Password anda salah!");
                }
            }

        }
        
        Boolean isRunning = true;
        int menuItem;
        do {
            // Main Menu
            System.out.println("\nMain Menu: ");
            System.out.println("1. Perhitungan Gaji\n0. Keluar Program");
            System.out.print("\n(int) Pilih menu: ");
            menuItem = scInput.nextInt();
            scInput.nextLine();
            System.out.println();
            switch (menuItem) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    for (int i = 0; i < bank_Karyawan.length; i++) {
                        System.out.println(i + ". " + nama_Karyawan[i]);
                    }                    
                    while (true) {
                        Boolean karyawan_isFound = false;
                        System.out.print("\nMasukkan Nama Karyawan atau dengan index-nya\t: ");
                        if(scInput.hasNextInt()) {
                            index_Karyawan = scInput.nextInt();
                            if(index_Karyawan < nama_Karyawan.length)
                                karyawan_isFound = true;
                        }    
                        else{
                            String nama_Input = scInput.nextLine();                            
                            for (int i = 0; i < nama_Karyawan.length; i++) {
                                if(nama_Input.equalsIgnoreCase(nama_Karyawan[i])){
                                    index_Karyawan = i;
                                    karyawan_isFound = true;
                                }
                            }
                        } 
                        if(karyawan_isFound) break;
                        System.out.println("Karyawan tidak ditemukan, meminta input kembali. . .");
                    }                                   
                    System.out.print("(char) Masukkan Golongan\t\t\t: ");
                    golongan = Character.toUpperCase(scInput.next().charAt(0));
                    System.out.print("(bilangan real) Masukkan Jumlah Masuk\t\t: ");
                    jmlMasuk = scInput.nextInt();
                    System.out.print("(bilangan real) Masukkan Total Jam Lembur\t: ");
                    jamLembur = scInput.nextInt();          

                    // Perhitungan Gaji
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
                            System.out.println("Golongan: " + golongan
                                    + " tidak ada, melanjutkan perhitungan dengan data seadanya");
                    }
                    long pokok_Gaji = jmlMasuk * pokok_GajiHarian;
                    int bonus_Gaji = jamLembur * bonus;
                    total_Gaji = pokok_Gaji + bonus_Gaji + uangTunjangan;
                    double potongan_Pajak = total_Gaji * pajak;
                    hasil_akhir = total_Gaji - potongan_Pajak;

                    // Slip Gaji
                    System.out.println(PagarPemisah+"\n");
                    System.out.println("Slip Gaji\nAtas nama: " + nama_Karyawan[index_Karyawan]);
                    System.out.println(
                        "\nPenghasilan: " +
                        "\nGolongan\t\t\t\t\t: " + golongan +
                        "\nGaji Pokok\t\t\t\t\t: Rp." + pokok_Gaji +
                        "\nBonus Gaji\t\t\t\t\t: Rp." + bonus_Gaji +
                        "\nTunjangan\t\t\t\t\t: Rp." + uangTunjangan +
                        "\n--------------------------------------------------------------------------" +
                        "\nTotal Penghasilan\t\t\t\t: Rp." + (long) total_Gaji);
                    System.out.println(
                        "\nPotongan: " +
                        "\nPajak\t\t\t\t\t\t: Rp." + (long) potongan_Pajak);
                    System.out.println(
                        "\n--------------------------------------------------------------------------" +
                        "\nTotal Gaji Bersih\t\t\t\t: Rp." + (long) hasil_akhir);

                    // Pembayaran / Transfer
                    System.out.println(PagarPemisah+"\n");
                    dataValid = bank_Karyawan[index_Karyawan].equalsIgnoreCase(bank_Karyawan[index_Karyawan]) 
                                && noRekening_Karyawan[index_Karyawan].length() == noRekening_Karyawan[index_Karyawan].length(); // Change this line
                    if (dataValid) {
                        System.out.println(
                                "Memulai transfer uang sebesar Rp." + (int) hasil_akhir + 
                                " ke " + noRekening_Karyawan[index_Karyawan] + "(" + bank_Karyawan[index_Karyawan] + ")");
                        transfStatus = true;                        
                        if (transfStatus) {
                            System.out.println("Transfer Berhasil");
                        } else {
                            System.out.println("Eror: ");
                            System.out.println("Transfer Gagal");
                        }
                    } else {
                        System.out.println("Data tidak valid! Mohon tijau kembali");
                        System.out.println("Nama\t\t: " + nama_Karyawan[index_Karyawan]);
                        System.out.println("Nama Bank\t: " + bank_Karyawan[index_Karyawan]);
                        System.out.println("No Rekening\t: " + noRekening_Karyawan[index_Karyawan]);
                    }
                    System.out.println(PagarPemisah+"\n");
                    System.out.println("Tugas selesai, Kembali ke menu. . .");
                    break;

                default:
                    System.out.println("Input tidak terdaftar");
                    break;
            }
        } while (isRunning);
        System.out.println("\n\nProgram Berhenti");
        scInput.close();
    }
}
