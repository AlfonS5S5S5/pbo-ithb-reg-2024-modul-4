package Model;

public class Presensi {
    private String tanggal;
    private StatusAttendance status;

    public Presensi(String tanggal, StatusAttendance status) {
        this.tanggal = tanggal;
        this.status = status;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public StatusAttendance getStatus() {
        return status;
    }

    public void setStatus(StatusAttendance status) {
        this.status = status;
    }

    public boolean Hadir() {
        return this.status == StatusAttendance.HADIR;
    }

    @Override
    public String toString() {
        return "Tanggal: " + tanggal + ", Status: " + status;
    }

}