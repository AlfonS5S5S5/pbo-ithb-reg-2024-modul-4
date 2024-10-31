package Model;

import java.util.List;

public class DosenTetap extends Dosen {
    
    private double salary;
    private List<AbsenStaff> listAbsenStaff;

    public DosenTetap(String nama, String alamat, String TTL, String telepon, String NIK, String departemen, List<MatkulAjar> matkulDiajar, double salary, List<AbsenStaff> listAbsenStaff) {
        super(nama, alamat, TTL, telepon, NIK, departemen, matkulDiajar);
        this.salary = salary;
        this.listAbsenStaff = listAbsenStaff;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
        return super.toString() + ", Salary: " + salary;
    }

}