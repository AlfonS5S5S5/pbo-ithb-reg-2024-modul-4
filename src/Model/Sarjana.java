package Model;

import java.util.List;

public class Sarjana extends Mahasiswa {

    private List<AmbilMatkul> ngambilMatkul;

    public Sarjana(String nama, String alamat, String TTL, String telepon, String NIM, String jurusan, List<AmbilMatkul> ngambilMatkul) {
        super(nama, alamat, TTL, telepon, NIM, jurusan);
        this.ngambilMatkul = ngambilMatkul;
    }

    public List<AmbilMatkul> getMatkulDiambil() {
        return ngambilMatkul;
    }

    public void setMatkulDiambil(List<AmbilMatkul> ngambilMatkul) {
        this.ngambilMatkul = ngambilMatkul;
    }

    @Override
    public String toString() {
        return super.toString() + ", Matkul Diambil: " + ngambilMatkul;
    }

}