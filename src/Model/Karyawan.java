package Model;

import java.util.List;

public class Karyawan extends Staff {
    
    private double salary;
    private List<AbsenStaff> listAbsenStaff;

    public Karyawan(String nama, String alamat, String TTL, String telepon, String NIK, double salary, List<AbsenStaff> listAbsenStaff) {
        super(nama, alamat, TTL, telepon, NIK);
        this.salary = salary;
        this.listAbsenStaff = listAbsenStaff;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<AbsenStaff> getListPresensiStaff() {
        return listAbsenStaff;
    }

    public void setListPresensiStaff(List<AbsenStaff> listAbsenStaff) {
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
        return super.toString() + ", Salary: " + salary + ", List Absensi Staff: " + listAbsenStaff;
    }

}