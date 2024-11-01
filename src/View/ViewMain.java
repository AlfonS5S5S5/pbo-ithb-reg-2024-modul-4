package View;

import Controller.Controllers;
import javax.swing.JOptionPane;

public class ViewMain {
    private Controllers controller;

    public ViewMain(Controllers controller) {
        this.controller = controller;
    }

    private String input(String input) {
        return JOptionPane.showInputDialog(input);
    }

    private void showMsg(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private void error(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }


    public void showMenu() {
        boolean running = true;

        String menu = "1. Print UserData\n" + "2. Print Nilai Akhir Mahasiswa\n" + "3. Print Rata-Rata Nilai Akhir\n" + "4. Print Jumlah Mahasiswa Tidak Lulus\n" + "5. Print Mata Kuliah yang diambil Mahasiswa\n" + "6. Print Total Jam ngajar Dosen\n" + "7. Print Gaji Staff\n" + "0. Exit\n" + "Pilih menu:";

        while (running) {
            String input = input(menu);

            if (input == null) {
                running = false;
                break;
            }

            int choice = -1;
            boolean valid = true;

            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i))) {
                    valid = false;
                    break;
                }
            }

            if (valid && !input.isEmpty()) {
                choice = Integer.parseInt(input);
            } else {
                error("Pilihan tidak valid!");
                continue;
            }

            switch (choice) {
                case 1:
                    printUser();
                    break;

                case 2:
                    printNA();
                    break;

                case 3:
                    printRataRataNA();
                    break;

                case 4:
                    printJmlhGaLulus();
                    break;

                case 5:
                    printMhsAmbilMatkul();
                    break;

                case 6:
                    printTotalJamNgajar();
                    break;

                case 7:
                    printGaji();
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    error("Pilihan tidak valid!");
            }
        }
    }

    private void printUser() {
        String nama = input("Masukkan Nama: ");
        if (nama != null) {
            showMsg(controller.printUser(nama));
        }
    }

    private void printNA() {
        String NIM = input("Masukkan NIM: ");
        if (NIM != null) {
            String kodeMK = input("Masukkan Kode Mata Kuliah: ");
            if (kodeMK != null) {
                showMsg(controller.printNA(NIM, kodeMK));
            }
        }
    }

    private void printRataRataNA() {
        String kodeMK = input("Masukkan Kode Mata Kuliah: ");
        if (kodeMK != null) {
            showMsg(controller.printRataRataNA(kodeMK));
        }
    }

    private void printJmlhGaLulus() {
        String kodeMK = input("Masukkan Kode Mata Kuliah: ");
        if (kodeMK != null) {
            showMsg(controller.printJmlhGkLulus(kodeMK));
        }
    }

    private void printMhsAmbilMatkul() {
        String NIM = input("Masukkan NIM: ");
        if (NIM != null) {
            showMsg(controller.printMhsNgambilMatkul(NIM));
        }
    }

    private void printTotalJamNgajar() {
        String NIK = input("Masukkan NIK Dosen: ");
        if (NIK != null) {
            showMsg(controller.printTotalJamNgajar(NIK));
        }
    }

    private void printGaji() {
        String NIK = input("Masukkan NIK Staff:");
        if (NIK != null) {
            showMsg(controller.printGaji(NIK));
        }
    }

}
