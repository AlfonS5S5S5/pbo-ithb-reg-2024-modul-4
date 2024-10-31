package Model;

public class MatkulPilihan extends MataKuliah {

    private int minimalMHS;

    public MatkulPilihan(String kode, int SKS, String nama, int minimalMahasiswa) {
        super(kode, SKS, nama);
        this.minimalMHS = minimalMahasiswa;
    }

    public int getMinMahasiswa() {
        return minimalMHS;
    }

    public void setMinMahasiswa(int minimalMahasiswa) {
        this.minimalMHS = minimalMahasiswa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Minimum Mahasiswa: " + minimalMHS;
    }
    
}