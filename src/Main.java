import Controller.Controllers;
import Model.AbsenStaff;
import Model.AmbilMatkul;
import Model.Dosen;
import Model.DosenTetap;
import Model.Karyawan;
import Model.MataKuliah;
import Model.MatkulAjar;
import Model.Presensi;
import Model.Sarjana;
import Model.StatusAttendance;
import Model.User;
import View.ViewMain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
    private static List<User> dataUser () {
        MataKuliah matkul1 = new MataKuliah("MK-193", 6, "Algoritma");

        Presensi presensi1 = new Presensi("2024-07-20", StatusAttendance.HADIR);
        List<Presensi> listAbsen = new ArrayList<>(Arrays.asList(presensi1));

        AmbilMatkul ngambilMatkul = new AmbilMatkul(matkul1, listAbsen, 70, 75, 100);
        List<AmbilMatkul> listMatkulYangDiambil = new ArrayList<>(Arrays.asList(ngambilMatkul));

        AbsenStaff Absen1Staff = new AbsenStaff("2024-10-10", StatusAttendance.HADIR, "10.30");
        List<AbsenStaff> listAbsenStaff = new ArrayList<>(Arrays.asList(Absen1Staff));

        MatkulAjar ngajarMatkul1 = new MatkulAjar(matkul1, listAbsenStaff);
        List<MatkulAjar> ListNgajarMatkul = new ArrayList<>(Arrays.asList(ngajarMatkul1));

        Sarjana mahasiswaSarjana = new Sarjana("Reivel", "Bandung", "2005-09-10", "081122339090", "1123000", "Informatika", listMatkulYangDiambil);

        Dosen dosenTTP = new DosenTetap("Steven", "Semarang", "1979-10-05", "087766554433", "55555", "Informatika", ListNgajarMatkul, 20000000, listAbsenStaff);

        Karyawan karyawan = new Karyawan("Tono", "Surabaya", "1965-09-24", "089988776655", "1111435", 9000000, listAbsenStaff);

        System.out.println("_______________________________");
        System.out.println(mahasiswaSarjana.toString());
        System.out.println("_______________________________");
        System.out.println(dosenTTP.toString());
        System.out.println("_______________________________");
        System.out.println(karyawan.toString());


        //dummy buat si controller
        List<User> userData = new ArrayList<>();
        userData.add(mahasiswaSarjana);
        userData.add(dosenTTP);
        userData.add(karyawan);

        return userData;
    }
    public static void main(String[] args) {

        List<User> dataUser = dataUser();
        Controllers controller = new Controllers(dataUser);

        ViewMain mainmenu = new ViewMain(controller);
        mainmenu.showMenu();
    }

    

}