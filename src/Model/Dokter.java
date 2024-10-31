package Model;

public class Dokter extends Mahasiswa {

    private String judulPenelitian;
    private int sidang1;
    private int sidang2;
    private int sidang3;

    public Dokter(String nama, String alamat, String TTL, String telepon, String NIM, String jurusan, String judulPenelitian, int nilaiSidang1, int nilaiSidang2, int nilaiSidang3) {
        super(nama, alamat, TTL, telepon, NIM, jurusan);
        this.judulPenelitian = judulPenelitian;
        this.sidang1 = nilaiSidang1;
        this.sidang2 = nilaiSidang2;
        this.sidang3 = nilaiSidang3;
    }

    public String getJudulPenelitianDisertasi() {
        return judulPenelitian;
    }

    public void setJudulPenelitianDisertasi(String judulPenelitian) {
        this.judulPenelitian = judulPenelitian;
    }

    public int getNilaiSidang1() {
        return sidang1;
    }

    public void setNilaiSidang1(int nilaiSidang1) {
        this.sidang1 = nilaiSidang1;
    }

    public int getNilaiSidang2() {
        return sidang2;
    }

    public void setNilaiSidang2(int nilaiSidang2) {
        this.sidang2 = nilaiSidang2;
    }

    public int getNilaiSidang3() {
        return sidang3;
    }

    public void setNilaiSidang3(int nilaiSidang3) {
        this.sidang3 = nilaiSidang3;
    }

    @Override
    public String toString() {
        return super.toString() + ", Judul Penelitian: " + judulPenelitian + ", Nilai Sidang 1: " + sidang1 + ", Nilai Sidang 2: " + sidang2 + ", Nilai Sidang 3: " + sidang3;
    }
    
}