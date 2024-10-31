package Model;

import java.util.List;

public class MatkulAjar {

    private MataKuliah mataKuliah;
    private List<AbsenStaff> AbsenStaff;

    public MatkulAjar(MataKuliah matkul, List<AbsenStaff> absensiStaff) {
        this.mataKuliah = matkul;
        this.AbsenStaff = absensiStaff;
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public List<AbsenStaff> getAbsenStaff() {
        return AbsenStaff;
    }

    public void setAbsenStaff(List<AbsenStaff> absenStaff) {
        this.AbsenStaff = absenStaff;
    }

    @Override
    public String toString() {
        return "Matkul: " + mataKuliah + ", Presensi Staff: " + AbsenStaff;
    }
    
}