package Model;

public abstract class User {

    private String nama;
    private String alamat;
    private String TTL;
    private String telepon;

    public User(String name, String address, String TTL, String tlp) {
        this.nama = name;
        this.alamat = address;
        this.TTL = TTL;
        this.telepon = tlp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String name) {
        this.nama = name;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String address) {
        this.alamat = address;
    }

    public String getTTL() {
        return TTL;
    }

    public void setTTL(String TTL) {
        this.TTL = TTL;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String tlp) {
        this.telepon = tlp;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Alamat: " + alamat + ", TTL: " + TTL + ", Telepon: " + telepon;
    }
    
}