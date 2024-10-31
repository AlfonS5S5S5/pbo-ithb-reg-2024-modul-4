package Model;

public class AbsenStaff extends Presensi {

    private String jam;

    public AbsenStaff(String tanggal, StatusAttendance status, String jam) {
        super(tanggal, status);
        this.jam = jam;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    @Override
    public String toString() {
        return super.toString() + ", Jam: " + jam;
    }
}