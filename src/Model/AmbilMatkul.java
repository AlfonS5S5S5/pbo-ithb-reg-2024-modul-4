package Model;

import java.util.List;

public class AmbilMatkul {
    
    private MataKuliah matkul;
    private List<Presensi> listAbsensi;
    private int nilai1;
    private int nilai2;
    private int nilai3;

    public AmbilMatkul(MataKuliah matkul, List<Presensi> listPresensi, int n1, int n2, int n3) {
        this.matkul = matkul;
        this.listAbsensi = listPresensi;
        this.nilai1 = n1;
        this.nilai2 = n2;
        this.nilai3 = n3;
    }

    public MataKuliah getMatkul() {
        return matkul;
    }

    public void setMatkul(MataKuliah matkul) {
        this.matkul = matkul;
    }

    public List<Presensi> getListPresensi() {
        return listAbsensi;
    }

    public void setPresensi(List<Presensi> listPresensi) {
        this.listAbsensi = listPresensi;
    }

    public int getN1() {
        return nilai1;
    }

    public void setN1(int n1) {
        this.nilai1 = n1;
    }

    public int getN2() {
        return nilai2;
    }

    public void setN2(int n2) {
        this.nilai2 = n2;
    }

    public int getN3() {
        return nilai3;
    }

    public void setN3(int n3) {
        this.nilai3 = n3;
    }

    @Override
    public String toString() {
        return "Mata Kuliah: " + matkul + ", Presensi: " + listAbsensi + ", N1: " + nilai1 + ", N2: " + nilai2 + ", N3: " + nilai3;
    }

}