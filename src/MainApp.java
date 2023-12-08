import java.util.Random;
import java.util.Scanner;

public class MainApp {
    final static String PagarPemisah = "###".repeat(47);
    private static Scanner scInput;
    private static String role = "";
    private static String usernameLogin;
    private static String dialogAnswer;
    private static int menuItem;

    // Login
    private static String[] register = { "Username", "Password", "Role" };
    private static String[][] account = {
            // USERNAME, PASSWORD, ROLE
            { "admin123", "123456", "admin" },
            { "farhan123", "farhanoke", "user" },
            { "user", "pengguna", "user" },
            { "", "", "admin" }
    };

    // Bank(Pembayaran)
    private static String[][] listBank = {
            { "BTN", "1234567890987654" }, { "Mandiri", "1234567890987" }, { "BRI", "123456789987456" },
            { "CIMB Niaga", "12345678998745" },
            { "BSI", "1234567890" }, { "Danamon", "1234567890" }, { "BNI", "9876543210" },
            { "BCA", "1234567890" } };

    // Karyawan
    private static String[] dataKaryawan_Info = { "Nama", "Golongan", "No Telephone", "Bank:NoRekening" };
    private static String[][] data_Karyawan = {
            // NAMA, GOL, NO TELP, BANK:NOREK, STATUS CUTI
            { "Raruu", "D", "-", "BRI:789654389987456", null },
            { "Dyyyy", "C", "-", "BTN:1234567890987654", "" },
            { "Farhan Kebab", "B", "083843069913", "BSI:1234567890", null },
            { "Slamet Kopling", "B", "089675839108", "BSI:1234567890", null },
            { "Rian Batagor", "A", "08996906443", "Mandiri:1234567890987", null },
            { "Rusdy Ambatukan", "C", "083843069913", "BSI:1234567890", null },
            { "Vivo", "D", "082118325367", "BSI:1234567890", null },
    };
    private static int index_Karyawan = 0;

    private static String[][] arrayPembGaji = new String[0][0];

    // Slip Gaji
    static String[] array_SlipGaji_Info = { "Id: ", "Atas Nama: ", "Golongan\t\t\t\t\t: ",
            "Gaji Pokok\t\t\t\t\t: Rp.", "Bonus Gaji\t\t\t\t\t: Rp.", "Tunjangan\t\t\t\t\t: Rp.",
            "Total Penghasilan\t\t\t\t: Rp.", "Pajak\t\t\t\t\t\t: Rp.", "Total Gaji Bersih\t\t\t\t: Rp." };
    static String[][] array_SlipGajis = new String[0][0];

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printBanner() {
        System.out.println(
                "############################################################################################################################################\n"
                        +
                        "############################################################################################################################################\n"
                        +
                        "#   ███████╗██╗███████╗████████╗███████╗███╗   ███╗    ██████╗ ███████╗███╗   ██╗ ██████╗  ██████╗  █████╗      ██╗██╗ █████╗ ███╗   ██╗   #\r\n"
                        +
                        "#   ██╔════╝██║██╔════╝╚══██╔══╝██╔════╝████╗ ████║    ██╔══██╗██╔════╝████╗  ██║██╔════╝ ██╔════╝ ██╔══██╗     ██║██║██╔══██╗████╗  ██║   #\r\n"
                        +
                        "#   ███████╗██║███████╗   ██║   █████╗  ██╔████╔██║    ██████╔╝█████╗  ██╔██╗ ██║██║  ███╗██║  ███╗███████║     ██║██║███████║██╔██╗ ██║   #\r\n"
                        +
                        "#   ╚════██║██║╚════██║   ██║   ██╔══╝  ██║╚██╔╝██║    ██╔═══╝ ██╔══╝  ██║╚██╗██║██║   ██║██║   ██║██╔══██║██   ██║██║██╔══██║██║╚██╗██║   #\r\n"
                        +
                        "#   ███████║██║███████║   ██║   ███████╗██║ ╚═╝ ██║    ██║     ███████╗██║ ╚████║╚██████╔╝╚██████╔╝██║  ██║╚█████╔╝██║██║  ██║██║ ╚████║   #\r\n"
                        +
                        "#   ╚══════╝╚═╝╚══════╝   ╚═╝   ╚══════╝╚═╝     ╚═╝    ╚═╝     ╚══════╝╚═╝  ╚═══╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝ ╚════╝ ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝   #\r\n"
                        +
                        "############################################################################################################################################\n"
                        +
                        "############################################################################################################################################\n"
                        +
                        "                                                                                                                                    ");

    }

    public static boolean checkAdmin(String x) {
        if (!"admin".equals(x)) {
            System.out.println("Maaf Anda Tidak Memiliki Hak Akses!!");
            return false;
        }
        return true;
    }

    public static String generateID() {
        return String.format("%010d", (new Random()).nextInt(100000000) + 1);
    }

    public static String generateRandomString() {
        String ABCDE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        char[] temp = new char[10];
        Random rand = new Random();
        for (int i = 0; i < temp.length; i++) {
            temp[i] = ABCDE.charAt(rand.nextInt(ABCDE.length()));
        }
        return new String(temp);
    }

    public static boolean isKaryawanIDTaken(String id) {
        boolean isTrue = false;
        for (int i = 0; i < data_Karyawan.length; i++) {
            if (data_Karyawan[i][4] == null)
                continue;
            if (data_Karyawan[i][4].equals(id)) {
                isTrue = true;
                break;
            }
        }
        return isTrue;
    }

    public static void generateKaryawanID() {
        for (int i = 0; i < data_Karyawan.length; i++) {
            if (data_Karyawan[i][4] != null)
                continue;
            String id;
            do {
                id = generateID();

            } while (isKaryawanIDTaken(id));
            data_Karyawan[i][4] = id;
        }
    }

    public static void generateKaryawanID(int index) {
        String id;
        do {
            id = generateID();

        } while (isKaryawanIDTaken(id));
        data_Karyawan[index][4] = id;
    }

    public static int getIndexById(String[][] arr, int arrIdAt, String id) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][arrIdAt].equals(id))
                return i;
        }
        return -1;
    }

    public static String getIdByIndex(String[][] arr, int arrIdAt, int index) {
        try {
            return arr[index][arrIdAt];

        } catch (Exception e) {
            System.out.println("getIdByIndex Failed!: " + e.toString());
        }
        return null;
    }

    public static boolean isIndexValid(String[][] arr, int index) {
        if (index < 0)
            return false;
        if (index >= arr.length)
            return false;
        return true;
    }

    public static String[][] addElementArray(String[][] arr, String... str) {
        String[][] arrayTemp = new String[arr.length + 1][str.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arrayTemp[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < str.length; i++) {
            arrayTemp[arr.length][i] = str[i];
        }
        return arrayTemp;
    }

    public static String[][] addElementArrayInput(String[][] arr, String[] msg) {
        String[][] arrayTemp = new String[arr.length + 1][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arrayTemp[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < msg.length; i++) {
            System.out.print(msg[i] + ": ");
            arrayTemp[arr.length][i] = scInput.nextLine();
        }
        return arrayTemp;
    }

    public static String[][] removeElementArray(String[][] arr, int indexAt) {
        if (indexAt >= arr.length)
            return arr;
        String[][] arrayTemp = new String[arr.length - 1][arr[0].length];
        boolean removed = false;
        for (int i = 0; i < arr.length; i++) {
            if (i == indexAt) {
                removed = true;
                continue;
            }
            for (int j = 0; j < arr[0].length; j++) {
                if (removed)
                    arrayTemp[i - 1][j] = arr[i][j];
                else
                    arrayTemp[i][j] = arr[i][j];
            }
        }
        return arrayTemp;
    }

    public static boolean karyawanSelector() {
        boolean karyawan_isFound = false;
        System.out.print("\nMasukkan Nama Karyawan atau dengan index-nya\t: ");
        if (scInput.hasNextInt()) {
            index_Karyawan = scInput.nextInt() - 1;
            if (index_Karyawan < data_Karyawan.length && index_Karyawan > -1)
                karyawan_isFound = true;
        } else {
            String nama_Input = scInput.nextLine();
            for (int i = 0; i < data_Karyawan.length; i++) {
                if (nama_Input.equalsIgnoreCase(data_Karyawan[i][0])) {
                    index_Karyawan = i;
                    karyawan_isFound = true;
                }
            }
        }
        return karyawan_isFound;
    }

    public static void printKaryawanList() {
        System.out.println("List Karyawan:");
        System.out.println("No.\tNama Karyawan");
        for (int i = 0; i < data_Karyawan.length; i++) {
            System.out.println((i + 1) + ".\t" + data_Karyawan[i][0]);
        }
    }

    public static void registerPengguna() {
        clearScreen();
        boolean isRunningAcc = true;
        while (isRunningAcc) {
            System.out.println();
            System.out.println("0. Kembali\n1. Data Akun\n2. Tambah Akun");
            System.out.print("Pilih Menu: ");
            menuItem = scInput.nextInt();
            scInput.nextLine();
            clearScreen();
            switch (menuItem) {
                case 0:
                    isRunningAcc = false;
                    break;
                case 1:
                    System.out.println("Username   | Password   | Role");
                    System.out.println("-------------------------------");
                    for (int i = 0; i < account.length; i++) {
                        String usr = account[i][0];
                        String pw = account[i][1];
                        String rl = account[i][2];
                        System.out.printf("%-10s | %-10s | %-5s\n", usr, pw, rl);
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.println("---REGISTRASI USER---");
                    account = addElementArrayInput(account, register);
                    clearScreen();
                    System.out.println("Registrasi Berhasil!");
                    break;
            }
        }
    }

    public static void kelolaKaryawan() {
        clearScreen();
        boolean isRunning_dataKaryawan = true;
        clearScreen();
        while (isRunning_dataKaryawan) {
            System.out.println();
            System.out.println("Pengelolaan Data Karyawan\n");
            printKaryawanList();
            System.out.println("\nMenu:");
            System.out.println("0. Kembali\n1. Edit/Lihat Data\n2. Tambahkan Karyawan\n3. Hapus Karyawan");
            System.out.print("Pilih Menu: ");
            menuItem = scInput.nextInt();
            scInput.nextLine();
            switch (menuItem) {
                case 0:
                    isRunning_dataKaryawan = false;
                    break;
                case 1:
                    while (true) {
                        // Input
                        if (karyawanSelector())
                            break;
                        System.out.println("Karyawan tidak ditemukan, meminta input kembali. . .");
                    }
                    while (true) {
                        clearScreen();
                        System.out.println();
                        for (int i = 0; i < dataKaryawan_Info.length; i++) {
                            System.out.println(
                                    (i + 1) + ". " + dataKaryawan_Info[i] + ": " + data_Karyawan[index_Karyawan][i]);
                        }
                        System.out.print("\nMasukkan '0' untuk keluar,\nPilih nomor untuk di edit: ");
                        menuItem = scInput.nextInt();
                        scInput.nextLine();
                        if (menuItem == 0)
                            break;
                        int selectedItem = menuItem - 1;
                        System.out.print(dataKaryawan_Info[selectedItem] + ": ");

                        data_Karyawan[index_Karyawan][selectedItem] = scInput.nextLine();
                    }
                    break;
                case 2:
                    clearScreen();
                    System.out.println("Tambahkan Karyawan");
                    System.out.println();
                    System.out.println("Masukkan data-data karyawan:");
                    data_Karyawan = addElementArrayInput(data_Karyawan, dataKaryawan_Info);
                    clearScreen();
                    System.out.println(
                            "\nPenambahan Karyawan " + data_Karyawan[data_Karyawan.length - 1][0] + " Berhasil!");
                    break;
                case 3:
                    System.out.println("Hapus Karyawan");
                    while (true) {
                        if (karyawanSelector())
                            break;
                        else
                            System.out.println("Karyawan tersebut tidak ada");
                    }
                    data_Karyawan = removeElementArray(data_Karyawan, index_Karyawan);
                    break;
                default:
                    System.out.println("Menu " + menuItem + " Tidak ada");
                    break;
            }
        }
    }

    public static void perhitunganGaji() {
        clearScreen();
        // Butuh Input
        int jmlMasuk, jamLembur;
        // Ga butuh
        int pokok_GajiHarian = 0, uangTunjangan = 0, bonus = 0;
        double pajak = 0.0, total_Gaji, hasil_akhir;

        clearScreen();
        System.out.println("Perhitungan Gaji");
        System.out.println();
        printKaryawanList();
        while (true) {
            if (karyawanSelector())
                break;
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
        String id = generateRandomString();

        addSlipGaji(id, data_Karyawan[index_Karyawan][0], golongan, pokok_Gaji, bonus_Gaji, uangTunjangan, total_Gaji,
                potongan_Pajak, hasil_akhir, data_Karyawan[index_Karyawan][4]);
        printSlipGaji(id);
        System.out.print("TEKAN ENTER UNTUK LANJUT: ");
        scInput.nextLine();

        // add array pembGaji
        addPembGaji(id, data_Karyawan[index_Karyawan][4]);
        doPembGaji(id);
    }

    public static void addPembGaji(String id, String karyawanID) {
        arrayPembGaji = addElementArray(arrayPembGaji, id, karyawanID);
    }

    public static void pembGaji() {
        if (arrayPembGaji.length <= 0) {
            System.out.println("Tidak ada antrian tersedia");
            System.out.print("TEKAN ENTER UNTUK KEMBALI: ");
            scInput.nextLine();
            return;
        }
        while (true) {
            clearScreen();
            System.out.println("No\tID\t\tNama");
            for (int i = 0; i < arrayPembGaji.length; i++) {
                int indexka = getIndexById(data_Karyawan, 4, arrayPembGaji[i][1]);
                if (indexka < 0)
                    continue;
                System.out.println((i + 1) + "\t" + arrayPembGaji[i][0] + "\t" + data_Karyawan[indexka][0]);
            }

            System.out.println("\nUntuk Kembali, Masukkan 0");
            System.out.print("Untuk Melihat, Masukkan No atau Id: ");
            String input = scInput.nextLine();
            try {
                int temp = Integer.parseInt(input) - 1;
                if (temp == -1)
                    break;
                if (temp < -1)
                    continue;
                input = getIdByIndex(arrayPembGaji, 0, temp);
            } catch (Exception e) {

            }
            doPembGaji(input);
        }
    }

    public static void doPembGaji(String id) {
        clearScreen();
        int no = getIndexById(arrayPembGaji, 0, id);
        int karyawanIndex = getIndexById(data_Karyawan, 4, arrayPembGaji[no][1]);
        dialogAnswer = "";
        while (!(dialogAnswer.equalsIgnoreCase("y") || dialogAnswer.equalsIgnoreCase("n"))) {
            System.out.print("\nLanjut ditransfer ke Rekening " + data_Karyawan[karyawanIndex][0] + "? (y/n): ");
            dialogAnswer = scInput.nextLine();
        }
        if (dialogAnswer.equalsIgnoreCase("n"))
            return;

        clearScreen();
        boolean dataValid = false, transfStatus = false;
        String amount = array_SlipGajis[getIndexById(array_SlipGajis, 0, id)][8];
        String[] bank_Karyawan = data_Karyawan[karyawanIndex][3].split(":", 2);
        for (int i = 0; i < listBank.length; i++) {
            if (listBank[i][0].equals(bank_Karyawan[0])) {
                dataValid = bank_Karyawan[1].length() == listBank[i][1].length();
                break;
            }
        }
        if (dataValid) {
            System.out.println(
                    "Memulai transfer uang sebesar Rp." + amount +
                            " ke " + bank_Karyawan[0] + "(" + bank_Karyawan[1] + ")");
            transfStatus = true;
            if (transfStatus) {
                //Add Element Remove Element Array
                arrayPembGaji = removeElementArray(arrayPembGaji, no);
                System.out.println("Transfer Berhasil");
            } else {
                System.out.println("Eror: ");
                System.out.println("Transfer Gagal");
            }
        } else {
            System.out.println("Data tidak valid! Mohon tijau kembali");
            System.out.println("Nama\t\t: " + data_Karyawan[karyawanIndex][0]);
            System.out.println("Nama Bank\t: " + bank_Karyawan[0]);
            System.out.println("No Rekening\t: " + bank_Karyawan[1]);
        }
        System.out.print("Tugas selesai, Tekan ENTER untuk Kembali ke menu:");
        scInput.nextLine();
    }

    public static void slipGaji() {
        if (array_SlipGajis.length <= 0) {
            System.out.println("Tidak ada Slip Gaji tersedia, lakukan perhitungan gaji terlebih dahulu");
            System.out.print("TEKAN ENTER UNTUK KEMBALI: ");
            scInput.nextLine();
            return;
        }
        while (true) {
            clearScreen();
            System.out.println("No\tID\t\tNama");
            for (int i = 0; i < array_SlipGajis.length; i++) {
                System.out.println((i + 1) + ".\t" + array_SlipGajis[i][0] + "\t" + array_SlipGajis[i][1]);
            }
            System.out.println("\nUntuk Kembali, Masukkan 0");
            System.out.print("Untuk Melihat, Masukkan No atau Id: ");
            String input = scInput.nextLine();
            try {
                int temp = Integer.parseInt(input) - 1;
                if (temp == -1)
                    break;
                if (temp < -1)
                    continue;
                input = getIdByIndex(array_SlipGajis, 0, temp);
            } catch (Exception e) {

            }

            printSlipGaji(input);
            System.out.print("TEKAN ENTER UNTUK KEMBALI: ");
            scInput.nextLine();
        }
    }

    public static void addSlipGaji(String id, String nama, char gol, long pokok_Gaji, int bonus_Gaji, int uangTunjangan,
            double total_Gaji, double potongan_Pajak, double hasil_Akhir, String karyawanID) {
        String[] str = new String[10];
        str[0] = id;
        str[1] = nama;
        str[2] = String.valueOf(gol);
        str[3] = String.valueOf(pokok_Gaji);
        str[4] = String.valueOf(bonus_Gaji);
        str[5] = String.valueOf(uangTunjangan);
        str[6] = String.valueOf((long) total_Gaji);
        str[7] = String.valueOf((long) potongan_Pajak);
        str[8] = String.valueOf((long) hasil_Akhir);
        str[9] = karyawanID;

        array_SlipGajis = addElementArray(array_SlipGajis, str);
    }

    public static void printSlipGaji(String id) {
        clearScreen();
        int index = getIndexById(array_SlipGajis, 0, id);
        if (!isIndexValid(array_SlipGajis, index)) {
            System.out.println("Tidak dapat menemukan data");
            scInput.nextLine();
            return;
        }

        System.out.println("Slip gaji\n");
        for (int i = 0; i < array_SlipGaji_Info.length; i++) {
            boolean extraEnter = false;
            if (i == 1)
                extraEnter = true;
            if (i == 2)
                System.out.println("Penghasilan: ");
            if (i == 6 || i == 8)
                System.out.println("--------------------------------------------------------------------------");
            if (i == 7)
                System.out.println("\nPotongan: ");

            System.out.println(array_SlipGaji_Info[i] + array_SlipGajis[index][i]);
            if (extraEnter)
                System.out.println();
        }
    }

    public static void kelolaCutiKaryawan(String[][] data_Karyawan) {
        clearScreen();
        // cuti
        String[] statusCuti = new String[data_Karyawan.length];

        for (int i = 0; i < data_Karyawan.length; i++) {
            statusCuti[i] = data_Karyawan[i][4];
        }

        System.out.print("Masukkan nama karyawan yang akan mengajukan atau mengubah cuti: ");
        String namaCuti = scInput.nextLine();

        int indexKaryawan = -1;
        for (int i = 0; i < data_Karyawan.length; i++) {
            if (namaCuti.equalsIgnoreCase(data_Karyawan[i][0])) {
                indexKaryawan = i;
                break;
            }
        }

        if (indexKaryawan != -1) {
            System.out.println("Status Cuti untuk " + namaCuti + ": " + data_Karyawan[indexKaryawan][4]);
            System.out.print("Masukkan status cuti baru (e.g., 'Sedang Cuti' atau 'Belum Mengajukan Cuti'): ");
            String statusCutiBaru = scInput.nextLine();

            for (int i = 0; i < data_Karyawan.length; i++) {
                if (namaCuti.equalsIgnoreCase(data_Karyawan[i][0])) {
                    data_Karyawan[i][1] = statusCutiBaru;

                    for (int j = 0; j < data_Karyawan.length; j++) {
                        if (namaCuti.equalsIgnoreCase(data_Karyawan[j][0])) {
                            data_Karyawan[j][4] = statusCutiBaru;
                            break;
                        }
                    }
                    break;
                }
            }

            System.out.println("Status cuti untuk " + namaCuti + " berhasil diubah menjadi: " + statusCutiBaru);
        } else {
            System.out.println("Karyawan dengan nama " + namaCuti + " tidak ditemukan.");
        }
    }

    public static void cutiKaryawan() {
        boolean isRunningCuti = true;
        while (isRunningCuti) {
            System.out.println("\nMenu Cuti Karyawan:");
            System.out.println("1. Lihat Status Cuti Karyawan");
            System.out.println("2. Kelola Cuti Karyawan");
            System.out.println("0. Kembali");
            System.out.print("Pilih Menu: ");
            menuItem = scInput.nextInt();
            scInput.nextLine();
            switch (menuItem) {
                case 0:
                    isRunningCuti = false;
                    break;
                case 1:
                    for (int i = 0; i < data_Karyawan.length; i++) {
                        System.out.println(data_Karyawan[i][0] + ": " + data_Karyawan[i][4]);
                    }
                    break;
                case 2:
                    kelolaCutiKaryawan(data_Karyawan);
                    break;
                default:
                    System.out.println("Menu " + menuItem + " tidak valid.");
                    break;
            }
        }
    }

    public static void login() {
        boolean login = false;
        while (login == false) {
            System.out.println("------LOGIN------");
            System.out.println("Tekan CTRL+C untuk keluar program");
            System.out.print("\nUsername: ");
            usernameLogin = scInput.nextLine();
            System.out.print("\nPassword: ");
            String passwordInput = scInput.nextLine();
            for (String[] key : account) {
                if (key[0].equals(usernameLogin) && key[1].equals(passwordInput)) {
                    login = true;
                    role = key[2];
                    clearScreen();
                    System.out.println("\n------LOGIN BERHASIL------");
                    System.out.println("\n----*SELAMAT DATANG " + usernameLogin + "*----\n");
                    break;
                }
            }
            if (!login) {
                System.out.println("\nUsername atau Password anda salah!");
            }

        }
    }

    public static void main(String[] args) throws Exception {
        scInput = new Scanner(System.in);
        generateKaryawanID();
        printBanner();

        boolean unlogin = true;
        while (unlogin) {
            login();
            boolean isRunning = true;
            do {
                // Main Menu
                System.out.println("Login: " + usernameLogin);
                System.out.println("\nMenu Utama: ");
                System.out.println(
                        "1. Registrasi Pengguna\n2. Pengelolaan Data Karyawan\n3. Perhitungan Gaji\n4. Lakukan Pembayaran Gaji\n5. Slip Gaji\n6. Cuti Karyawan\n7. LogOut\n0. Keluar Program");
                System.out.print("\npilih Menu (angka): ");
                if (!scInput.hasNextInt())
                    menuItem = -1;
                else
                    menuItem = scInput.nextInt();
                scInput.nextLine();
                System.out.println();
                switch (menuItem) {
                    case 0:
                        isRunning = false;
                        unlogin = false;
                        break;
                    case 1:
                        if (checkAdmin(role)) {
                            registerPengguna();
                        } else {
                            System.out.println("Mohon maaf anda tidak memiliki hak Akses!");
                        }
                        break;
                    case 2:
                        kelolaKaryawan();
                        break;
                    case 3:
                        perhitunganGaji();
                        break;
                    case 4:
                        pembGaji();
                        break;
                    case 5:
                        slipGaji();
                        break;
                    case 6:
                        cutiKaryawan();
                        break;
                    case 7:
                        System.out.println("Anda Telah Log Out.");
                        isRunning = false;
                        break;
                    default:
                        break;
                }
                clearScreen();
            } while (isRunning);
        }
        System.out.println("\n\nProgram Berhenti");
        scInput.close();
    }
}
