package Model;

import java.util.List;

public class DosenHonorer extends Dosen {

    private double honorPerSKS;
    private List<AbsenStaff> listAbsenStaff;

    public DosenHonorer(double honorPerSKS, List<AbsenStaff> listAbsenStaff, String nama, String alamat, String TTL, String telepon, String NIK, String departemen, List<MatkulAjar> matkulDiajar) {
        super(nama, alamat, TTL, telepon, NIK, departemen, matkulDiajar);
        this.honorPerSKS = honorPerSKS;
        this.listAbsenStaff = listAbsenStaff;
    }

    public double getHonorPerSKS() {
        return honorPerSKS;
    }

    public void setHonorPerSKS(double honorPerSKS) {
        this.honorPerSKS = honorPerSKS;
    }

    public List<AbsenStaff> getListAbsenStaff() {
        return listAbsenStaff;
    }

    public void setListAbsenStaff(List<AbsenStaff> listAbsenStaff) {
        this.listAbsenStaff = listAbsenStaff;
    }

    public int getUnit() {
        int unit = 0;
        for (Presensi presensi : listAbsenStaff) {
            if (presensi.Hadir()) {
                unit++;
            }
        }
        return unit;

    }

    @Override
    public String toString() {
        return super.toString() + ", Honor per SKS: " + honorPerSKS;
    }
}