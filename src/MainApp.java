import java.util.Random;
import java.util.Scanner;

public class MainApp {
    private static Scanner scInput;
    private static String role = "";
    private static String usernameLogin;
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
    private static String[] dataKaryawan_Info = { "ID Karyawan", "Nama", "Golongan", "No Telephone",
            "Bank", "NoRekening" };
    private static String[][] data_Karyawan = {
            // NAMA, GOL, NO TELP, BANK:NOREK, ID Karyawan
            { null, "Raruu", "D", "-", "BRI", "789654389987456" },
            { null, "Dyyyy", "C", "-", "BTN", "1234567890987654" },
            { null, "Farhan Kebab", "B", "083843069913", "BSI", "1234567890" },
            { null, "Slamet Kopling", "B", "089675839108", "BSI", "1234567890" },
            { null, "Rian Batagor", "A", "08996906443", "Mandiri", "1234567890987" },
            { null, "Rusdy Ambatukan", "C", "083843069913", "BSI", "1234567890" },
            { null, "Vivo", "D", "082118325367", "BSI", "1234567890" },
    };
    private static int index_Karyawan = 0;

    private static String[][] arrayPembGaji = new String[0][0];

    private static String[][] arrayRekapGaji = new String[0][0];

    private static String[][] arrayRekapAbsensi = new String[0][0];

    // Cuti Karyawan
    private static String[][] arrayCutiKaryawan = new String[0][0];

    // Slip Gaji
    static String[] array_SlipGaji_Info = { "Id: ", "Atas Nama: ", "Golongan\t\t\t\t\t: ",
            "Gaji Pokok\t\t\t\t\t: Rp.", "Bonus Gaji\t\t\t\t\t: Rp.", "Tunjangan\t\t\t\t\t: Rp.",
            "Total Penghasilan\t\t\t\t: Rp.", "Pajak\t\t\t\t\t\t: Rp.", "Total Gaji Bersih\t\t\t\t: Rp." };
    static String[][] array_SlipGajis = new String[0][0];
    private static String[][] array_SuccessfulTransfers = new String[0][2];

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

    public static void enterToContinue() {
        System.out.print("TEKAN ENTER UNTUK KEMBALI: ");
        scInput.nextLine();
    }

    public static void enterToContinue(String msg) {
        System.out.print(msg);
        scInput.nextLine();
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
            if (data_Karyawan[i][0] == null)
                continue;
            if (data_Karyawan[i][0].equals(id)) {
                isTrue = true;
                break;
            }
        }
        return isTrue;
    }

    public static void generateKaryawanID() {
        for (int i = 0; i < data_Karyawan.length; i++) {
            if (data_Karyawan[i][0] != null)
                continue;
            String id;
            do {
                id = generateID();

            } while (isKaryawanIDTaken(id));
            data_Karyawan[i][0] = id;
        }
    }

    public static void generateKaryawanID(int index) {
        String id;
        do {
            id = generateID();

        } while (isKaryawanIDTaken(id));
        data_Karyawan[index][0] = id;
    }

    public static String getKaryawanNameById(String id) {
        int index = getIndexById(data_Karyawan, 0, id);
        if (index >= 0)
            return data_Karyawan[index][1];
        return null;
    }

    public static int getIndexById(String[][] arr, int arrIdAt, String id) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][arrIdAt].equals(id))
                return i;
        }
        return -1;
    }

    public static int getIndexById(String[][] arr, int arrIdAt, String id, int startAt) {
        for (int i = startAt; i < arr.length; i++) {
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

    public static int getLengthIndex(String[][] arr, String id, int index) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][index].equals(id))
                count++;
        }
        return count;
    }

    public static String[] addElementArray(String[] arr, String... str) {
        String[] arrayTemp = new String[arr.length + str.length];
        for (int i = 0; i < arr.length; i++) {
            arrayTemp[i] = arr[i];
        }
        for (int i = arr.length; i < arr.length + str.length; i++) {
            arrayTemp[i] = str[i - arr.length];
        }
        return arrayTemp;
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

    public static String[][] addElementArrayInput(String[][] arr, String[] msg, int startFillAt, int msgStartAt,
            boolean allowEmpty) {
        String[][] arrayTemp = new String[arr.length + 1][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arrayTemp[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < msg.length - msgStartAt; i++) {
            System.out.print(msg[i + msgStartAt] + ": ");
            String input = scInput.nextLine();
            while (!allowEmpty) {
                if (!input.equals(""))
                    break;
                input = scInput.nextLine();
            }
            arrayTemp[arr.length][i + startFillAt] = input;
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
        while (!karyawan_isFound) {
            System.out.print("\nUntuk Keluar Masukkan 0,\nMasukkan Nama Karyawan atau dengan NO urut-nya\t: ");
            if (scInput.hasNextInt()) {
                index_Karyawan = intInput() - 1;
                if (index_Karyawan < 0)
                    break;
                if (index_Karyawan < data_Karyawan.length && index_Karyawan > -1) {
                    karyawan_isFound = true;
                    break;
                }
            } else {
                String nama_Input = scInput.nextLine();
                for (int i = 0; i < data_Karyawan.length; i++) {
                    if (nama_Input.equalsIgnoreCase(data_Karyawan[i][1])) {
                        index_Karyawan = i;
                        karyawan_isFound = true;
                        break;
                    }
                }
            }
            if (!karyawan_isFound)
                System.out.println("Karyawan tidak ditemukan, meminta input kembali. . .");
        }
        return karyawan_isFound;
    }

    public static boolean akunSelector() {
        boolean akun_isFound = false;
        while (!akun_isFound) {
            System.out.print("\nUntuk Keluar Masukkan 0,\nMasukkan Username Akun atau dengan NO urut-nya\t: ");
            if (scInput.hasNextInt()) {
                index_Karyawan = intInput() - 1;
                if (index_Karyawan < 0)
                    break;
                if (index_Karyawan < account.length && index_Karyawan > -1) {
                    akun_isFound = true;
                    break;
                }
            } else {
                String username_Input = scInput.nextLine();
                for (int i = 0; i < account.length; i++) {
                    if (username_Input.equalsIgnoreCase(account[i][0])) {
                        index_Karyawan = i;
                        akun_isFound = true;
                        break;
                    }
                }
            }
            if (!akun_isFound)
                System.out.println("Akun tidak ditemukan, meminta input kembali. . .");
        }
        return akun_isFound;
    }

    public static int intInput() {
        int input = -1;
        if (scInput.hasNextInt()) {
            input = scInput.nextInt();
        }
        scInput.nextLine();
        return input;
    }

    public static boolean summonDialog(String msg) {
        String dialogAnswer = "";
        while (!(dialogAnswer.equalsIgnoreCase("y") || dialogAnswer.equalsIgnoreCase("n"))) {
            System.out.print("\n" + msg + "? (y/n): ");
            dialogAnswer = scInput.nextLine();
        }
        if (dialogAnswer.equalsIgnoreCase("n"))
            return false;
        return true;
    }

    public static void printKaryawanList() {
        System.out.println("List Karyawan:");
        System.out.println("No.\tNama Karyawan");
        for (int i = 0; i < data_Karyawan.length; i++) {
            System.out.println((i + 1) + ".\t" + data_Karyawan[i][1]);
        }
    }

    public static void registerPengguna() {
        clearScreen();
        boolean isRunningAcc = true;
        while (isRunningAcc) {
            System.out.println("--  DATA AKUN  --");
            System.out.printf("%-5s | %-10s | %-10s | %-5s\n", "NO", "Username", "Password", "Role");
            System.out.println("-----------------------------------------");
            for (int i = 0; i < account.length; i++) {
                String no = String.valueOf(i + 1);
                String usr = account[i][0];
                String pw = account[i][1];
                String rl = account[i][2];
                System.out.printf("%-5s | %-10s | %-10s | %-5s\n", no, usr, pw, rl);
            }
            System.out.println();
            System.out.println("0. Kembali\n1. Tambah Akun\n2. Hapus Akun");
            System.out.print("Pilih Menu: ");
            menuItem = intInput();
            switch (menuItem) {
                case 0:
                    isRunningAcc = false;
                    break;
                case 1:
                    System.out.println();
                    System.out.println("---REGISTRASI USER---");
                    account = addElementArrayInput(account, register);
                    clearScreen();
                    System.out.println("Registrasi Berhasil!");
                    break;
                case 2:
                    System.out.println("Hapus Akun\n");
                    if (!akunSelector())
                        break;
                    if (!summonDialog("Menghapus Akun " + account[index_Karyawan][0])) {
                        break;
                    }
                    account = removeElementArray(account, index_Karyawan);
                    break;
                default:
                    clearScreen();
                    System.out.println("Menu " + menuItem + " Tidak ada");
                    break;
            }
        }
    }

    public static void kelolaKaryawan() {
        clearScreen();
        boolean isRunning_dataKaryawan = true;
        while (isRunning_dataKaryawan) {
            System.out.println();
            System.out.println("Pengelolaan Data Karyawan\n");
            printKaryawanList();
            System.out.println("\nMenu:");
            System.out.println("0. Kembali\n1. Edit/Lihat Data\n2. Tambahkan Karyawan\n3. Hapus Karyawan");
            System.out.print("Pilih Menu: ");
            menuItem = intInput();
            switch (menuItem) {
                case 0:
                    isRunning_dataKaryawan = false;
                    break;
                case 1:
                    // Input
                    if (!karyawanSelector())
                        break;

                    while (true) {
                        clearScreen();
                        System.out.println();
                        for (int i = 0; i < dataKaryawan_Info.length; i++) {
                            System.out.println(
                                    (i + 1) + ". " + dataKaryawan_Info[i] + ": "
                                            + data_Karyawan[index_Karyawan][i]);
                        }
                        System.out.print("\nMasukkan '0' untuk keluar,\nPilih nomor untuk di edit: ");
                        menuItem = intInput() - 1;
                        if (menuItem <= -1)
                            break;
                        int selectedItem = menuItem;
                        System.out.print(dataKaryawan_Info[selectedItem] + ": ");

                        data_Karyawan[index_Karyawan][selectedItem] = scInput.nextLine();
                    }
                    break;
                case 2:
                    clearScreen();
                    System.out.println("Tambahkan Karyawan");
                    System.out.println();
                    System.out.println("Masukkan data-data karyawan:");
                    data_Karyawan = addElementArrayInput(data_Karyawan, dataKaryawan_Info, 1, 1, false);
                    generateKaryawanID(data_Karyawan.length - 1);
                    clearScreen();
                    System.out.println(
                            "\nPenambahan Karyawan " + data_Karyawan[data_Karyawan.length - 1][1] + " Berhasil!");
                    break;
                case 3:
                    System.out.println("Hapus Karyawan\n");
                    if (!karyawanSelector())
                        break;
                    if (!summonDialog("Menghapus Akun " + data_Karyawan[index_Karyawan][1])) {
                        break;
                    }
                    String karyawanId = data_Karyawan[index_Karyawan][0];
                    int indexPembGaji = getIndexById(arrayPembGaji, 1, karyawanId);
                    while (indexPembGaji > -1) {
                        arrayPembGaji = removeElementArray(arrayPembGaji, indexPembGaji);
                        indexPembGaji = getIndexById(arrayPembGaji, 1, karyawanId);
                    }

                    int indexRekapGaji = getIndexById(arrayRekapGaji, 0, karyawanId);
                    while (indexRekapGaji > -1) {
                        arrayRekapGaji = removeElementArray(arrayRekapGaji, indexRekapGaji);
                        indexRekapGaji = getIndexById(arrayRekapGaji, 0, karyawanId);
                    }

                    int indexSlipGaji = getIndexById(array_SlipGajis, 9, karyawanId);
                    while (indexSlipGaji > -1) {
                        array_SlipGajis = removeElementArray(array_SlipGajis, indexSlipGaji);
                        indexSlipGaji = getIndexById(array_SlipGajis, 9, karyawanId);
                    }
                    int indexCuti = getIndexById(arrayCutiKaryawan, 0, karyawanId);
                    while (indexCuti > -1) {
                        arrayCutiKaryawan = removeElementArray(arrayCutiKaryawan, indexCuti);
                        indexCuti = getIndexById(arrayCutiKaryawan, 0, karyawanId);
                    }
                    setRekapAbsensi(karyawanId);
                    data_Karyawan = removeElementArray(data_Karyawan, index_Karyawan);
                    break;
                default:
                    clearScreen();
                    System.out.println("Menu " + menuItem + " Tidak ada");
                    break;
            }
        }
    }

    public static void perhitunganGaji() {
        clearScreen();
        int jmlMasuk, jamLembur;
        int pokok_GajiHarian = 0, uangTunjangan = 0, bonus = 0;
        double pajak = 0.0, total_Gaji, hasil_akhir;

        clearScreen();
        System.out.println("Perhitungan Gaji");
        System.out.println();
        printKaryawanList();
        if (!karyawanSelector())
            return;
        do {
            System.out.print("(bilangan real) Masukkan Jumlah Masuk\t\t: ");
            jmlMasuk = intInput();
            System.out.print("(bilangan real) Masukkan Total Jam Lembur\t: ");
            jamLembur = intInput();
            if (jmlMasuk > 0 && jamLembur > -1)
                break;
            System.out.println("INPUT TIDAK VALID, MENGULANGI\n");
        } while (true);

        char golongan = data_Karyawan[index_Karyawan][2].toUpperCase().toCharArray()[0];

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
                System.out.println("Golongan: " + golongan + " tidak ada, perhitungan akan menghasilkan 0");
                System.out.println("Mohon tinjau kembali data pada menu \"Pengelolaan Data Karyawan\"");
        }
        long pokok_Gaji = jmlMasuk * pokok_GajiHarian;
        int bonus_Gaji = jamLembur * bonus;
        total_Gaji = pokok_Gaji + bonus_Gaji + uangTunjangan;
        double potongan_Pajak = total_Gaji * pajak;
        hasil_akhir = total_Gaji - potongan_Pajak;

        String id = generateRandomString();

        // Rekap Gaji
        addRekapGaji(data_Karyawan[index_Karyawan][0], jmlMasuk, jamLembur, hasil_akhir, id);

        // Slip Gaji
        addSlipGaji(id, data_Karyawan[index_Karyawan][1], golongan, pokok_Gaji, bonus_Gaji, uangTunjangan, total_Gaji,
                potongan_Pajak, hasil_akhir, data_Karyawan[index_Karyawan][0]);
        enterToContinue("TEKAN ENTER UNTUK LANJUT: ");

        // add array pembGaji
        addPembGaji(id, data_Karyawan[index_Karyawan][0]);
        doPembGaji(id);

        enterToContinue("TEKAN ENTER UNTUK KEMBALI KE MENU: ");

    }

    public static void addPembGaji(String id, String karyawanID) {
        arrayPembGaji = addElementArray(arrayPembGaji, id, karyawanID);
    }

    public static void pembGaji() {
        while (true) {
            clearScreen();
            System.out.println("Pembayaran Gaji\n");
            if (arrayPembGaji.length <= 0) {
                System.out.println("Tidak ada antrian tersedia");
                enterToContinue();
                return;
            }

            System.out.println("No\tID\t\tNama");
            for (int i = 0; i < arrayPembGaji.length; i++) {
                int indexka = getIndexById(data_Karyawan, 0, arrayPembGaji[i][1]);
                if (indexka < 0)
                    continue;
                System.out.println((i + 1) + "\t" + arrayPembGaji[i][0] + "\t" + data_Karyawan[indexka][1]);
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
            enterToContinue("Tekan ENTER untuk Kembali ke menu:");
        }
    }

    public static void doPembGaji(String id) {
        clearScreen();
        int index = getIndexById(arrayPembGaji, 0, id);
        if (!isIndexValid(arrayPembGaji, index)) {
            System.out.println("Tidak dapat menemukan data");
            return;
        }

        printSlipGaji(id);

        int karyawanIndex = getIndexById(data_Karyawan, 0, arrayPembGaji[index][1]);
        if (!summonDialog("Lanjut ditransfer ke Rekening " + data_Karyawan[karyawanIndex][1]))
            return;

        clearScreen();
        boolean dataValid = false, transfStatus = false;
        String amount = array_SlipGajis[getIndexById(array_SlipGajis, 0, id)][8];
        String[] bank_Karyawan = { data_Karyawan[karyawanIndex][4], data_Karyawan[karyawanIndex][5] };
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
                // Add Element Remove Element Array
                array_SuccessfulTransfers = addElementArray(array_SuccessfulTransfers, id,
                        data_Karyawan[karyawanIndex][1], bank_Karyawan[0], bank_Karyawan[1],amount);
                arrayPembGaji = removeElementArray(arrayPembGaji, index);
                System.out.println("Transfer Berhasil");
            } else {
                System.out.println("Eror: ");
                System.out.println("Transfer Gagal");
            }
        } else {
            System.out.println("Data tidak valid! Mohon tijau kembali");
            System.out.println("Nama\t\t: " + data_Karyawan[karyawanIndex][1]);
            System.out.println("Nama Bank\t: " + bank_Karyawan[0]);
            System.out.println("No Rekening\t: " + bank_Karyawan[1]);
        }
    }

    public static void slipGaji() {
        while (true) {
            clearScreen();
            System.out.println("Slip Gaji\n");
            if (array_SlipGajis.length <= 0) {
                System.out.println("Tidak ada Slip Gaji tersedia, lakukan perhitungan gaji terlebih dahulu");
                enterToContinue();
                return;
            }
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
            if (getIndexById(array_SlipGajis, 0, input) < 0) {
                enterToContinue("Tidak dapat menemukan data");
                continue;
            }

            System.out.println("\n1. Print Slip Gaji\n2. Hapus Slip Gaji\n0. Kembali");
            System.out.print("Masukkan pilihan: ");
            int menuItem = intInput();
            switch (menuItem) {
                case 1:
                    printSlipGaji(input);
                    break;
                case 2:
                    clearScreen();
                    if (summonDialog("HAPUS SLIP GAJI " + input)) {
                        int indexPembGaji = getIndexById(arrayPembGaji, 0, input);
                        if (indexPembGaji > -1)
                            arrayPembGaji = removeElementArray(arrayPembGaji, indexPembGaji);
                        int indexRekapGaji = getIndexById(arrayRekapGaji, 4, input);
                        if (indexRekapGaji > -1)
                            arrayRekapGaji = removeElementArray(arrayRekapGaji, indexRekapGaji);

                        int indexSlipGaji = getIndexById(array_SlipGajis, 0, input);
                        setRekapAbsensi(array_SlipGajis[indexSlipGaji][9]);
                        array_SlipGajis = removeElementArray(array_SlipGajis, indexSlipGaji);
                        System.out.println("\nBerhasil dihapus");
                    }
                    break;
                default:
                    break;
            }
            enterToContinue();
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
            return;
        }

        System.out.println("Slip gaji\n");
        for (int i = 0; i < array_SlipGaji_Info.length; i++) {
            if (i == 1) {
                System.out.println(
                        array_SlipGaji_Info[i] + array_SlipGajis[index][i] + " [" + array_SlipGajis[index][9] + "]\n");
                continue;
            }
            if (i == 2)
                System.out.println("Penghasilan: ");
            if (i == 6 || i == 8)
                System.out.println("--------------------------------------------------------------------------");
            if (i == 7)
                System.out.println("\nPotongan: ");

            System.out.println(array_SlipGaji_Info[i] + array_SlipGajis[index][i]);
        }
    }

    public static void transferList() {
        clearScreen();
        System.out.println("Daftar Gaji yang Telah Berhasil Ditransfer\n");
        System.out.printf("%-5s | %-10s | %-10s | %-27s | %-15s\n", "NO", "ID", "NAMA", "BANK(NO.REK)", "NOMINAL");
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < array_SuccessfulTransfers.length; i++) {
            System.out.printf("%-5s | %-10s | %-10s | %-27s | %-15s\n", String.valueOf(1+i), array_SuccessfulTransfers[i][0], array_SuccessfulTransfers[i][1],
                array_SuccessfulTransfers[i][2] + "("+ array_SuccessfulTransfers[i][3] +")", "Rp. "+array_SuccessfulTransfers[i][4]);
            System.out.println();
        }
        enterToContinue("Tekan ENTER untuk kembali ke menu:");
    }

    public static void cutiKaryawan() {
        boolean isRunningCuti = true;
        while (isRunningCuti) {
            clearScreen();
            System.out.println("Cuti\n");
            System.out.println("\nMenu Cuti Karyawan:");
            System.out.println("1. Ajukan Cuti");
            System.out.println("2. Data Cuti");
            System.out.println("0. Kembali");
            System.out.print("Pilih Menu: ");
            menuItem = intInput();
            clearScreen();
            switch (menuItem) {
                case 0:
                    isRunningCuti = false;
                    break;
                case 1:
                    printKaryawanList();
                    if (!karyawanSelector())
                        break;
                    System.out.print("Alasan Cuti: ");
                    String whyCuti = scInput.nextLine();
                    System.out.print("Berapa Lama Cuti: ");
                    int daysCuti = intInput();

                    addCutiKaryawan(data_Karyawan[index_Karyawan][0], daysCuti,
                            whyCuti);
                    setRekapAbsensi(data_Karyawan[index_Karyawan][0]);
                    enterToContinue("\nPengajuan Cuti Selesai,\nENTER UNTUK LANJUT: ");
                    break;
                case 2:
                    System.out.printf("%-15s%-20s%-15s%-15s\n", "ID Karyawan", "Nama ", "Cuti Hari", "Alasan Cuti");
                    System.out.println("--------------------------------------------------------------");
                    for (int i = 0; i < arrayCutiKaryawan.length; i++) {
                        System.out.printf("%-15s%-20s%-15s%-15s\n", arrayCutiKaryawan[i][0],
                                arrayCutiKaryawan[i][1], arrayCutiKaryawan[i][2], arrayCutiKaryawan[i][3]);
                        System.out.println();
                    }
                    enterToContinue("ENTER UNTUK LANJUT: ");
                    break;
                default:
                    System.out.println("Menu " + menuItem + " tidak valid.");
                    break;
            }
        }
    }

    public static void addCutiKaryawan(String idKaryawan, int daysCuti, String alasan) {
        int isIndex = getIndexById(arrayCutiKaryawan, 0, idKaryawan);
        if (isIndex >= 0)
            arrayCutiKaryawan = removeElementArray(arrayCutiKaryawan, isIndex);
        if (daysCuti > 0)
            arrayCutiKaryawan = addElementArray(arrayCutiKaryawan, idKaryawan, getKaryawanNameById(idKaryawan),
                    String.valueOf(daysCuti), alasan);
    }

    public static void addRekapGaji(String karyawanId, int jmlMasuk, int jamLembur, double hasil_Akhir, String id) {
        String[] str = new String[5];
        str[0] = karyawanId;
        str[1] = String.valueOf(jmlMasuk);
        str[2] = String.valueOf(jamLembur);
        str[3] = String.valueOf((long) hasil_Akhir);
        str[4] = id;

        arrayRekapGaji = addElementArray(arrayRekapGaji, str);
        setRekapAbsensi(karyawanId);
    }

    public static long sumofMasuk(String id, int startAt) {
        int index = getIndexById(arrayRekapGaji, 0, id, startAt);
        if (startAt == arrayRekapGaji.length || index < 0)
            return 0;

        return Integer.valueOf(arrayRekapGaji[index][1]) + sumofMasuk(id, index + 1);

    }

    public static String[] getAvailableId(String[][] arr, int atIndex) {
        String[] Ids = new String[0];
        for (int i = 0; i < arr.length; i++) {
            boolean isThere = false;
            for (int j = 0; j < Ids.length; j++) {
                if (Ids[j].contains(arr[i][atIndex])) {
                    isThere = true;
                    break;
                }
            }
            if (!isThere)
                Ids = addElementArray(Ids, arr[i][atIndex]);
        }
        return Ids;
    }

    public static void RekapGaji() {
        clearScreen();
        if (arrayRekapGaji.length <= 0) {
            System.out.println("Belum ada data perhitungan gaji yang diinputkan!!");
            enterToContinue();
            return;
        }

        String[] ids = getAvailableId(arrayRekapGaji, 0);
        String[][] printArr = new String[ids.length][6];
        for (int i = 0; i < ids.length; i++) {
            int karIndex = getIndexById(data_Karyawan, 0, ids[i]);
            if (karIndex > -1) {
                printArr[i][0] = data_Karyawan[karIndex][0];
                printArr[i][1] = data_Karyawan[karIndex][1];
                printArr[i][2] = data_Karyawan[karIndex][2];
                int jmlMasuk = 0, jamLembur = 0;
                long hasilAkhir = 0;
                for (int j = 0; j < arrayRekapGaji.length; j++) {
                    if (arrayRekapGaji[j][0].contains(ids[i])) {
                        jmlMasuk += Integer.valueOf(arrayRekapGaji[j][1]);
                        jamLembur += Integer.valueOf(arrayRekapGaji[j][2]);
                        hasilAkhir += Long.valueOf(arrayRekapGaji[j][3]);
                    }
                }
                printArr[i][3] = String.valueOf(jmlMasuk);
                printArr[i][4] = String.valueOf(jamLembur);
                printArr[i][5] = String.valueOf(hasilAkhir);
            }
        }

        System.out.println("Rekap Gaji Karyawan");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-15s%-15s%-15s%-15s%-15s\n", "Karyawan ID", "Nama", "Golongan", "Jumlah Masuk",
                "Jam Lembur",
                "Total Gaji");
        System.out.println("---------------------------------------------------------------------------------------");

        for (int i = 0; i < printArr.length; i++) {
            System.out.printf("%-20s%-15s%-15s%-15s%-15s%-15s\n", printArr[i][0], printArr[i][1],
                    printArr[i][2], printArr[i][3], printArr[i][4], "Rp. " + printArr[i][5]);
            System.out.println();
        }
        enterToContinue();
    }

    public static void setRekapAbsensi(String id) {
        String[] str = new String[4];

        str[0] = getKaryawanNameById(id);
        str[1] = String.valueOf(sumofMasuk(id, 0));
        str[3] = id;

        int indexCuti = getIndexById(arrayCutiKaryawan, 0, id);
        String daysCuti = "0";
        if (indexCuti >= 0)
            daysCuti = arrayCutiKaryawan[indexCuti][2];
        str[2] = daysCuti;

        int isIndex = getIndexById(arrayRekapAbsensi, 3, id);
        if (isIndex >= 0)
            arrayRekapAbsensi = removeElementArray(arrayRekapAbsensi, isIndex);
        if (Integer.valueOf(str[1]) > 0 || Integer.valueOf(str[2]) > 0)
            arrayRekapAbsensi = addElementArray(arrayRekapAbsensi, str);
    }

    public static void printRekapAbsensi() {
        System.out.println("=====================================================");
        System.out.println("          Tabel Rekap Jumlah Masuk dan Status Cuti");
        System.out.println("=====================================================");
        System.out.printf("%-20s%-15s%-15s\n", "Nama Karyawan", "Jumlah Masuk", "Jumlah Cuti");
        System.out.println("---------------------------------------------");

        if (arrayRekapAbsensi.length <= 0) {
            System.out.println("Belum ada data perhitungan gaji yang diinputkan!!");
            enterToContinue();
            return;
        }

        for (int i = 0; i < arrayRekapAbsensi.length; i++) {
            String namaKaryawan = arrayRekapAbsensi[i][0];
            String jmlMasuk = arrayRekapAbsensi[i][1];
            String jmlCuti = arrayRekapAbsensi[i][2];
            System.out.printf("%-20s%-15s%-15s\n", namaKaryawan, jmlMasuk, jmlCuti);
            System.out.println();
        }
        System.out.println("=============================================");
        enterToContinue();
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
                        "1. Pengelolaan Akun\n2. Pengelolaan Data Karyawan\n3. Perhitungan Gaji\n4. Lakukan Pembayaran Gaji\n5. Slip Gaji\n"
                                + "6. Cuti Karyawan\n7. Rekap Gaji\n8. Rekap Absensi\n9. Riwayat Transaksi\n10. LogOut\n0. Keluar Program");
                System.out.print("\npilih Menu (angka): ");
                menuItem = intInput();
                System.out.println();
                switch (menuItem) {
                    case 0:
                        if (summonDialog("Keluar Program")) {
                            unlogin = false;
                            isRunning = false;
                        }
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
                        RekapGaji();
                        break;
                    case 8:
                        printRekapAbsensi();
                        break;
                    case 9:
                        transferList();
                        break;
                    case 10:
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
