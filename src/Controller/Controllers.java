package Controller;

import java.util.List;

import Model.AmbilMatkul;
import Model.Dokter;
import Model.Dosen;
import Model.DosenHonorer;
import Model.DosenTetap;
import Model.Karyawan;
import Model.Mahasiswa;
import Model.MatkulAjar;
import Model.Presensi;
import Model.Sarjana;
import Model.StatusAttendance;
import Model.User;

public class Controllers {

    private List<User> users;

    public Controllers(List<User> users) {
        this.users = users;
    }

    public String printUser(String nama) {
        for (User user : users) {
            if (user.getNama().equalsIgnoreCase(nama)) {
                return user.toString();
            }
        }
        return "User Invalid";
    }

    public String printNA(String NIM, String kodeMK) {
        for (User user : users) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mhs = (Mahasiswa) user;
                if (mhs.getNIM().equals(NIM)) {
                    if (mhs instanceof Sarjana) {
                        Sarjana sarjana = (Sarjana) mhs;
                        for (AmbilMatkul matkulAmbil : sarjana.getMatkulDiambil()) {
                            if (matkulAmbil.getMatkul().getKode().equals(kodeMK)) {
                                double nilaiAkhir = (matkulAmbil.getN1() + matkulAmbil.getN2() + matkulAmbil.getN3()) / 3.0;
                                return "Nilai Akhir: " + nilaiAkhir;
                            }
                        }
                    } else if (mhs instanceof Dokter) {
                        Dokter dokter = (Dokter) mhs;
                        double nilaiAkhir = (dokter.getNilaiSidang1() + dokter.getNilaiSidang2() + dokter.getNilaiSidang3()) / 3.0;
                        return "Nilai Akhir: " + nilaiAkhir;
                    }
                }
            }
        }
        return "Data tidak ditemukan";
    }

    public String printRataRataNA(String kodeMK) {
        double totalNilai = 0;
        int jmlhMhs = 0;

        for (User user : users) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mhs = (Mahasiswa) user;
                if (mhs instanceof Sarjana) {
                    Sarjana sarjana = (Sarjana) mhs;
                    for (AmbilMatkul matkulAmbil : sarjana.getMatkulDiambil()) {
                        if (matkulAmbil.getMatkul().getKode().equals(kodeMK)) {
                            totalNilai += (matkulAmbil.getN1() + matkulAmbil.getN2() + matkulAmbil.getN3()) / 3.0;
                            jmlhMhs++;
                        }
                    }
                } else if (mhs instanceof Dokter) {
                    Dokter dokter = (Dokter) mhs;
                    totalNilai += (dokter.getNilaiSidang1() + dokter.getNilaiSidang2() + dokter.getNilaiSidang3()) / 3.0;
                    jmlhMhs++;
                }
            }
        }
        if (jmlhMhs == 0) {
            return "Ga ada mahasiswa yang ngambil matkul ini";
        }
        double rataRata = totalNilai/jmlhMhs;

        return "Rata-Rata Nilai Akhir: " + rataRata;

    }

    public String printJmlhGkLulus(String kodeMK) {
        int tdkLulus = 0;
        int jmlhMhs = 0;
        String namaMK = "";
        for (User user : users) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mhs = (Mahasiswa) user;
                if (mhs instanceof Sarjana) {
                    Sarjana sarjana = (Sarjana) mhs;
                    for (AmbilMatkul matkulAmbil : sarjana.getMatkulDiambil()) {
                        if (matkulAmbil.getMatkul().getKode().equals(kodeMK)) {
                            namaMK = matkulAmbil.getMatkul().getNama();
                            double nilaiAkhir = (matkulAmbil.getN1() + matkulAmbil.getN2() + matkulAmbil.getN3()) / 3.0;
                            if (nilaiAkhir < 56) {
                                tdkLulus++;
                            }
                            jmlhMhs++;
                        }
                    }
                } else if (mhs instanceof Dokter) {
                    Dokter dokter = (Dokter) mhs;
                    double nilaiAkhir = (dokter.getNilaiSidang1() + dokter.getNilaiSidang2() + dokter.getNilaiSidang3()) / 3.0;

                    if (nilaiAkhir < 56) {
                        tdkLulus++;
                    }
                    jmlhMhs++;
                }
            }
        }
        return "<" + tdkLulus + "> dari <" + jmlhMhs + "> mahasiswa tidak lulus matakuliah <" + namaMK + ">";
    }

    public String printMhsNgambilMatkul(String NIM) {
        for (User user : users) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mahasiswa = (Mahasiswa) user;
                if (mahasiswa.getNIM().equals(NIM)) {
                    if (mahasiswa instanceof Sarjana) {
                        Sarjana sarjana = (Sarjana) mahasiswa;
                        String hasil = "Matkul Diambil: ";
                        for (AmbilMatkul matkulAmbil : sarjana.getMatkulDiambil()) {
                            hasil += matkulAmbil.getMatkul().getNama() + " (Total Presensi: " + matkulAmbil.getListPresensi().size() + "), ";
                        }
                        return hasil;
                    } else {
                        return "Mahasiswa bukan dari program ini";
                    }
                }
            }
        }
        return "Mahasiswa Invalid";
    }

    public String printTotalJamNgajar(String NIK) {
        for (User user : users) {
            if (user instanceof Dosen) {
                Dosen dosen = (Dosen) user;
                if (dosen.getNIK().equals(NIK)) {
                    int totalJamMengajar = 0;
                    for (MatkulAjar matkulAjar : dosen.getMatkulDiajar()) {
                        for (Presensi presensi : matkulAjar.getAbsenStaff()) {
                            if (presensi.getStatus() == StatusAttendance.HADIR) {
                                totalJamMengajar += matkulAjar.getMataKuliah().getSKS();
                            }
                        }
                    }
                    return "Total Jam Ngajar: " + totalJamMengajar;
                }
            }
        }
        return "Dosen Invalid";
    }

    public String printGaji(String NIK) {
        for (User user : users) {
            if (user instanceof Karyawan) {
                Karyawan karyawan = (Karyawan) user;
                if (karyawan.getNIK().equals(NIK)) {
                    int unit = karyawan.getUnit();
                    double gaji = karyawan.getSalary() * (unit / 22.0);
                    return "Gaji Karyawan: " + gaji;
                }
            } else if (user instanceof DosenTetap) {
                DosenTetap dosenTetap = (DosenTetap) user;
                if (dosenTetap.getNIK().equals(NIK)) {
                    int unit = dosenTetap.getUnit();
                    double gaji = dosenTetap.getSalary() + (unit * 25000);
                    return "Gaji Dosen Tetap: " + gaji;
                }
            } else if (user instanceof DosenHonorer) {
                DosenHonorer dosenHonor = (DosenHonorer) user;
                if (dosenHonor.getNIK().equals(NIK)) {
                    int unit = dosenHonor.getUnit();
                    double gaji = unit * dosenHonor.getHonorPerSKS();
                    return "Gaji Dosen Honor: " + gaji;
                }
            }
        }
        return "User Invalid";
    }

}
