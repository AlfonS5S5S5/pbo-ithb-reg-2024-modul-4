package Model;

import java.util.List;

public class Magister extends Sarjana {
    private String penelitianTesis;

    public Magister(String nama, String alamat, String TTL, String telepon, String NIM, String jurusan, List<AmbilMatkul> matkulDiambil, String judulPenelitianTesis) {
        super(nama, alamat, TTL, telepon, NIM, jurusan, matkulDiambil);
        this.penelitianTesis = judulPenelitianTesis;
    }

    public String getJudulPenelitianTesis() {
        return penelitianTesis;
    }

    public void setJudulPenelitianTesis(String judulPenelitianTesis) {
        this.penelitianTesis = judulPenelitianTesis;
    }

    @Override
    public String toString() {
        return super.toString() + ", Judul Penelitian Tesis: " + penelitianTesis;
    }

}