import  java.util.Scanner;
import java.util.ArrayList;

class Nasabah{
    String nama;
    String pin;
    double saldo;

    Nasabah(String nama,String pin,double saldo){
        this.nama = nama;
        this.pin = pin;
        this.saldo = saldo;
    }

    void display(){

        System.out.println("Nama Nasabah : " + this.nama);
        System.out.println("Saldo Nasabah : Rp" + this.saldo);
    }

    void cekSaldo(){
        System.out.println("Saldo : "+ this.nama + " adalah Rp." + this.saldo);
    }

    void tarikTunai(double tunai){
        this.saldo = this.saldo - tunai;
        System.out.println("Kamu Mengambil saldo sebanyak " + tunai);
        System.out.println("sehingga sisa saldo kamu adalah " + this.saldo);
    }
    
    void setoran(double setor){
        this.saldo = this.saldo + setor;
        System.out.println("kamu menambah saldo sebanyak "+ setor);
        cekSaldo();
    }
    void login(String pin){
        if (this.pin.equals(pin)){
            System.out.println("Pin kamu Benar, Silahkan Masukan angka untuk melakukan Transaksi");
            System.out.println("Pilih Menu:\n 1. Cek Saldo \n2. Tarik Tunai \n3. Setor Tunai");
        } else{
            System.out.println("Pin kamu Salah, Silahkan Masukan Pin yang Benar");
        }
    }
}

public class Main{
    static void menu(){
        System.out.println("Pilih Mau ngapain Loe Disini heh? :\n 1. Buat Rekening gratis free no biaya admin \n2.login mas \n3. Keluar Program \n4. Liat Daftar Nasabah");
        System.out.println("Masukan Pilihan");
    }
    static void ATM(){
        System.out.println("");
    }
    public static void main(String[]args){
        Scanner myObj = new Scanner(System.in);
        //Buat Array List bang biar kesimpen yang mau register yah
        ArrayList<Nasabah> daftarNasabah = new ArrayList<>();

        //ini mah contoh 1 ajah yah
        daftarNasabah.add (new Nasabah("wanda kaya","123456",200000));
        while (true){
            menu();
            int menu = myObj.nextInt();

            if (menu == 1){
                System.err.println("Kamu Sedang Register account");
                myObj.nextLine();

                    
                    System.out.println("Silahkan masukan nama mu:");
                    String namaBaru = myObj.nextLine();
                    
                    System.out.println("Buat PIN (6 angka ajah ya jangan panjang2):");
                    String pinBaru = myObj.nextLine();


                    System.out.println("Setoran Pertamamu mau berapa?:");
                    double saldoAwal = myObj.nextDouble();

                    Nasabah nasabahBaru = new Nasabah(namaBaru, pinBaru, saldoAwal);
                    daftarNasabah.add(nasabahBaru);

                    //btw ini var nasabahBaru tuh kebentuk tiap ini dijalanin doang sih, jdi aman gk makan memory

                    System.out.println("Tahniyah, akun atas nama "+ namaBaru + " berhasil dibuat dengan pin " + pinBaru + " dan saldo Awal sebesar : " + saldoAwal + " Rupiah");
                    
            }
            else if (menu == 2){
                    //login mas?
                //Validasi dlu gk sih
                
                Nasabah akunAktif = null;
                System.out.println("Masukan Nama mu: ");
                myObj.nextLine();
                String namaLogin = myObj.nextLine();
                System.out.println("Masukan Pin mu: ");
                String pinLogin = myObj.nextLine();
                
                //nyari yg ada di List, udh register apa belom tuh
                for(Nasabah nasabah : daftarNasabah){
                    if (nasabah.nama.equalsIgnoreCase(namaLogin) && nasabah.pin.equals(pinLogin)){
                        akunAktif = nasabah;
                    break;
                    }
                    


                }
                //critanya udh login nih
                if (akunAktif != null) {
                    System.out.println("\n Login Berhasil! Selamat Datang, " + akunAktif.nama);

                    boolean diDalamATM = true;
                    while (diDalamATM) {
                        System.out.println("\nPilih Menu Transaksi:");
                        System.out.println("1. Cek Saldo");
                        System.out.println("2. Tarik Tunai");
                        System.out.println("3. Setor Tunai");
                        System.out.println("4. Logout");
                        System.out.print("Pilihan Anda: ");
                        int pilihan = myObj.nextInt();

                        switch (pilihan) {
                            case 1:
                                akunAktif.cekSaldo();
                                break;
                            case 2:
                                System.out.print("Masukkan jumlah tarik tunai: Rp");
                                double tunai = myObj.nextDouble();
                                akunAktif.tarikTunai(tunai);
                                break;
                            case 3:
                                System.out.print("Masukkan jumlah setor tunai: Rp");
                                double setor = myObj.nextDouble();
                                akunAktif.setoran(setor);
                                break;
                            case 4:
                                diDalamATM = false;
                                System.out.println("Berhasil Logout dari akun " + akunAktif.nama);
                                break;
                            default:
                                System.out.println("Pilihan tidak valid!");
                        }
                    }
                } else {
                    System.out.println(" Login Gagal! Nama atau PIN salah.");
                }
            }
            else if (menu == 3){
                    //Kluar cok
                System.out.println("Terima kasih telah menggunakan Bank Sederhana!");
                break; // Keluar dari perulangan program utama
            }
            else if (menu == 4){
                System.out.println("Daftar Nasabah: ");
                for (Nasabah nasabah : daftarNasabah) {
                    nasabah.display();
                    System.out.println("--------------------");
                }
            }
            else {
                    System.out.println("Nyawit nih org");
            }
        }
        
        
    }
}