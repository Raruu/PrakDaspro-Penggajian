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
             
        String dialogAnswer;               
        
        // Bank(Pembayaran)        
        String[][] listBank = {
            {"BTN", "1234567890987654"}, {"Mandiri", "1234567890987"}, {"BRI", "123456789987456"}, {"CIMB Niaga", "12345678998745"},
            {"BSI", "1234567890"}, {"Danamon", "1234567890"}, {"BNI", "9876543210"}, {"BCA", "1234567890"}};
        

        // Karyawan
        String[] dataKaryawan_Info = {"Nama", "Golongan", "No Telephone", "Bank:NoRekening"};
        String[][] data_Karyawan = {
            // NAMA,    GOL,    NO TELP,    BANK:NOREK
            {"Raruu", "D", "-", "BRI:789654389987456"},
            {"Dyyyy", "C", "-", "BTN:1234567890987654"},
            {"Farhan Kebab", "B", "083843069913", "BSI:1234567890"},
            {"Slamet Kopling", "B", "089675839108", "BSI:1234567890"},
            {"Rian Batagor", "A", "08996906443", "Mandiri:1234567890987"},
            {"Rusdy Ambatukan", "C", "083843069913", "BSI:1234567890"},
            {"Vivo", "D", "082118325367", "BSI:1234567890"},
        };
        int index_Karyawan = 0;               

        //  Login
        String[][] account = {
            {"admin", "123456"},
            {"farhan123", "farhanoke"},
            {"rian", "rianoke"},
            {"rusdy", "rusdyoke"},
            {"slamet", "slametoke"},
            {"vivo","vivooke"},
            {"user", "pengguna"}
        };
        
        boolean login = false;
        while (login == false) {
            System.out.println("------LOGIN------");
            System.out.println("Tekan CTRL+C untuk keluar program");
            System.out.print("\nUsername: ");
            String usernameInput = scInput.nextLine();
            System.out.print("\nPassword: ");
            String passwordInput = scInput.nextLine();

            for (String[] key : account)
            {
                if (key[0].equals(usernameInput) && key[1].equals(passwordInput)) 
                {
                    login = true;
                    System.out.println("\n------LOGIN BERHASIL------");
                    System.out.println("\n----*SELAMAT DATANG "+usernameInput+"*----");
                    break;
                }                
            }
            if(!login){
                System.out.println("\nUsername atau Password anda salah!");
            }                   
        }

        boolean isRunning = true;
        int menuItem;
        do {
            // Main Menu
            System.out.println(PagarPemisah);
            System.out.println("\nMain Menu: ");
            System.out.println("1. Register User\n2. Pengelolaan Data Karyawan\n3. Perhitungan Gaji\n4. Lakukan Pembayaran Gaji\n5. Cetak Slip Gaji\n0. Keluar Program");
            System.out.print("\n(int) Pilih menu: ");
            menuItem = scInput.nextInt();
            scInput.nextLine();
            System.out.println();
            switch (menuItem) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    
                    break;
                case 2:                    
                    boolean isRunning_dataKaryawan = true;
                    while (isRunning_dataKaryawan) {
                        System.out.println(PagarPemisah);
                        System.out.println();
                        System.out.println("Pengelolaan Data Karyawan\n");
                        System.out.println("List Karyawan:");
                        for (int i = 0; i < data_Karyawan.length; i++) {
                            System.out.println((i+1) + ". " + data_Karyawan[i][0]);
                        } 
                        System.out.println("\nMenu:");
                        System.out.println("0. Kembali\n1. Edit/Lihat Data\n2. Tambahkan Karyawan");
                        System.out.print("Pilih Menu: ");
                        menuItem = scInput.nextInt();
                        scInput.nextLine();
                        switch (menuItem) {
                            case 0:
                                isRunning_dataKaryawan = false;
                                break;
                            case 1:
                                while (true) {
                                    //Input
                                    boolean karyawan_isFound = false;
                                    System.out.print("\nMasukkan Nama Karyawan atau dengan index-nya\t: ");
                                    if(scInput.hasNextInt()) {
                                        index_Karyawan = scInput.nextInt() - 1;
                                        if(index_Karyawan < data_Karyawan.length)
                                            karyawan_isFound = true;
                                    }    
                                    else{
                                        String nama_Input = scInput.nextLine();                            
                                        for (int i = 0; i < data_Karyawan.length; i++) {
                                            if(nama_Input.equalsIgnoreCase(data_Karyawan[i][0])){
                                                index_Karyawan = i;
                                                karyawan_isFound = true;
                                            }
                                        }
                                    } 
                                    if(karyawan_isFound) break;
                                    System.out.println("Karyawan tidak ditemukan, meminta input kembali. . .");
                                }
                                while (true) {
                                    System.out.println(PagarPemisah);
                                    System.out.println();
                                    for (int i = 0; i < dataKaryawan_Info.length; i++) {
                                        System.out.println((i+1) +". " + dataKaryawan_Info[i] + ": " + data_Karyawan[index_Karyawan][i]);
                                    }
                                    System.out.print("\nMasukkan '0' untuk keluar,\nPilih nomor untuk di edit: ");
                                    menuItem = scInput.nextInt();
                                    scInput.nextLine();
                                    if(menuItem == 0) break;
                                    int selectedItem = menuItem -1;
                                    System.out.print(dataKaryawan_Info[selectedItem] + ": ");
                                    
                                    data_Karyawan[index_Karyawan][selectedItem] = scInput.nextLine();
                                }  
                                break;
                            case 2:
                                System.out.println(PagarPemisah);
                                System.out.println();
                                System.out.println("Masukkan data-data karyawan:");
                                String[][] arrayTemp = new String[data_Karyawan.length + 1][data_Karyawan[0].length];
                                for (int i = 0; i < data_Karyawan.length; i++) {
                                    for (int j = 0; j < data_Karyawan[0].length; j++) {
                                        arrayTemp[i][j] = data_Karyawan[i][j];
                                    }
                                }
                                for (int i = 0; i < dataKaryawan_Info.length; i++) {
                                    System.out.print(dataKaryawan_Info[i] + ": ");
                                    arrayTemp[data_Karyawan.length][i] = scInput.nextLine();
                                }
                                data_Karyawan = arrayTemp;
                                System.out.println("\nPenambahan Karyawan " + data_Karyawan[data_Karyawan.length-1][0] + " Berhasil!");
                                break;
                            default:
                                System.out.println("Menu "+ menuItem +" Tidak ada");
                                break;
                        }
                    }
                    
                    break;
                case 3:
                    // Butuh Input
                    int jmlMasuk, jamLembur;  
                    // Ga butuh
                    int pokok_GajiHarian = 0, uangTunjangan = 0, bonus = 0;   
                    double pajak = 0.0, total_Gaji, hasil_akhir; 

                    System.out.println(PagarPemisah); 
                    System.out.println();
                    for (int i = 0; i < data_Karyawan.length; i++) {
                        System.out.println((i+1) + ". " + data_Karyawan[i][0]);
                    }                    
                    while (true) {
                        boolean karyawan_isFound = false;
                        System.out.print("\nMasukkan Nama Karyawan atau dengan index-nya\t: ");
                        if(scInput.hasNextInt()) {
                            index_Karyawan = scInput.nextInt() - 1;
                            if(index_Karyawan < data_Karyawan.length)
                                karyawan_isFound = true;
                        }    
                        else{
                            String nama_Input = scInput.nextLine();                            
                            for (int i = 0; i < data_Karyawan.length; i++) {
                                if(nama_Input.equalsIgnoreCase(data_Karyawan[i][0])){
                                    index_Karyawan = i;
                                    karyawan_isFound = true;
                                }
                            }
                        } 
                        if(karyawan_isFound) break;
                        System.out.println("Karyawan tidak ditemukan, meminta input kembali. . .");
                    }                                   
                    System.out.print("(bilangan real) Masukkan Jumlah Masuk\t\t: ");
                    jmlMasuk = scInput.nextInt();
                    System.out.print("(bilangan real) Masukkan Total Jam Lembur\t: ");
                    jamLembur = scInput.nextInt();        
                    scInput.nextLine();  
                    char golongan = data_Karyawan[index_Karyawan][1].toUpperCase().toCharArray()[0];

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
                    System.out.println("Slip Gaji\nAtas nama: " + data_Karyawan[index_Karyawan][0]);
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

                    // Dialog Lanjut Transfer
                    dialogAnswer = "";                    
                    while (!(dialogAnswer.equalsIgnoreCase("y") || dialogAnswer.equalsIgnoreCase("n"))) {
                        System.out.print("\nLanjut ditransfer ke Rekening " + data_Karyawan[index_Karyawan][0] + "? (y/n): ");
                        dialogAnswer = scInput.nextLine();
                    }                    
                    if (dialogAnswer.equalsIgnoreCase("n"))
                        break;

                    // Pembayaran / Transfer
                    boolean dataValid = false, transfStatus = false;                    
                    System.out.println(PagarPemisah+"\n");
                    String[] bank_Karyawan = data_Karyawan[index_Karyawan][3].split(":", 2);
                    for (int i = 0; i < listBank.length; i++) {
                        if(listBank[i][0].equals(bank_Karyawan[0])){
                            dataValid = bank_Karyawan[1].length() == listBank[i][1].length();
                            break;
                        }
                    }
                    if (dataValid) {
                        System.out.println(
                                "Memulai transfer uang sebesar Rp." + (int) hasil_akhir + 
                                " ke " + bank_Karyawan[0] + "(" + bank_Karyawan[1] + ")");
                        transfStatus = true;                        
                        if (transfStatus) {
                            System.out.println("Transfer Berhasil");
                        } else {
                            System.out.println("Eror: ");
                            System.out.println("Transfer Gagal");
                        }
                    } else {
                        System.out.println("Data tidak valid! Mohon tijau kembali");
                        System.out.println("Nama\t\t: " + data_Karyawan[index_Karyawan][0]);
                        System.out.println("Nama Bank\t: " + bank_Karyawan[0]);
                        System.out.println("No Rekening\t: " + bank_Karyawan[1]);
                    }
                    System.out.println("Tugas selesai, Kembali ke menu. . .");
                    break;
                case 4:
                    //cuti
                    String[][] data = {
                    // NAMA,    GOL,    NO TELP,    BANK:NOREK,       STATUS CUTI
                    {"Raruu", "D", "-", "BRI:789654389987456", "Belum Mengajukan Cuti"},
                    {"Dyyyy", "C", "-", "BTN:1234567890987654", "Belum Mengajukan Cuti"},
                    {"Farhan Kebab", "B", "083843069913", "BSI:1234567890", "Belum Mengajukan Cuti"},
                    {"Slamet Kopling", "B", "089675839108", "BSI:1234567890", "Belum Mengajukan Cuti"},
                    {"Rian Batagor", "A", "08996906443", "Mandiri:1234567890987", "Belum Mengajukan Cuti"},
                    {"Rusdy Ambatukan", "C", "083843069913", "BSI:1234567890", "Belum Mengajukan Cuti"},
                    {"Vivo", "D", "082118325367", "BSI:1234567890", "Belum Mengajukan Cuti"},
                    };

                    // input nama
                    System.out.print("Masukkan nama yang sedang cuti: ");
                    String namaCuti = scInput.nextLine();

                    // cek nama
                    boolean karyawanFound = false;
                    for (int i = 0; i < data.length; i++) {
                        if (namaCuti.equalsIgnoreCase(data[i][0])) {
                            karyawanFound = true;
                            // Update status ke "Sedang Cuti"
                            data[i][4] = "Sedang Cuti";
                            System.out.println(namaCuti + " telah mengajukan cuti.");
                            break;
                            }
                    }

                    if (!karyawanFound) {
                        System.out.println("Karyawan dengan nama " + namaCuti + " tidak ditemukan.");
                    }
                     break;
                case 5:
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
