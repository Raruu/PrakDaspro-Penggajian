# Dokumentasi

## Data Karyawan

| ID Karyawan | Nama   | Golongan  | Bank   | No Rekening |
| ----------- | ------ | --------- | ------ | ----------- |
| 10 Digit    | String | String[0] | String | String      |

- ID Karyawan diisi secara acak dengan otomatis, saat program dijalankan
- Terdapat Gologan `A, B, C, D` Gologan akan membaca huruf pertama pada String yang diinput

### List Bank yang terdaftar pada Program ini:

| Bank       | Jumlah digit |
| ---------- | ------------ |
| BTN        | 16           |
| Mandiri    | 13           |
| BRI        | 15           |
| CIMB Niaga | 14           |
| BSI        | 10           |
| Danamon    | 10           |
| BNI        | 10           |
| BCA        | 10           |

#### Selain memasukkan bank dari list diatas akan membuat transaksi gagal

# Menu

## Login

Terdapat akun default:
NO | Username | Password | Role
------|------------|------------|--------
1 | admin123 | 123456 | admin
2 | farhan123 | farhanoke | user
3 | user | pengguna | user
4 | | | admin

### Submenu:

0. Kembali
1. Tambah Akun
2. Hapus Akun

## Pengelolaan Data Karyawan

Digunakan untuk mengelola data Karyawan

### Submenu:

0. Kembali
1. Edit/Lihat Data
2. Tambahkan Karyawan
3. Hapus Karyawan

#### `Menghapus Karyawan akan menghapus semua data yang terkait`

## Perhitungan Gaji

Perhitungan Gaji akan langsung menanyakan karyawan manakah yang akan digaji.Berdasarakan data karyawan yang telah ada.\
Bila mengeluarkan hasil 0, data ada yang tidak valid. Lihat [Format Data](#Data-Karyawan)

## Lakukan Pembayaran Gaji

Untuk membayar antrian pembayaran gaji yang belum dibayar

## Slip Gaji

Untuk mencetak dan menghapus slip gaji yang ada

#### Menghapus Slip Gaji akan menghapus:

- Antrian pembayaran
- Rekap Gaji
- Rekap Absensi
- Riwayat Transaksi

## Cuti Karyawan

Kelola Cuti Karyawan

### Submenu:

0. Kembali
1. Ajukan Cuti
2. Data Cuti

#### Mengambil cuti dengan 0 hari sama dengan menghapus Cuti

## Rekap Gaji

List rekap gaji dari semua karyawan

## Rekap Absensi

List rekap absensi dari semua karyawan

## Riwayat Transaksi

List Transaksi yang berhasil dari semua karyawan

## LogOut

Hanya logout

## Keluar Program

Masukkan `y` untuk keluar, `n` untuk tidak jadi keluar
