package Model;

public abstract class Staff extends User {

    private String NIK;

    public Staff(String nama, String address, String TTL, String tlp, String NIK) {
        super(nama, address, TTL, tlp);
        this.NIK = NIK;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    @Override
    public String toString() {
        return super.toString() + ", NIK: " + NIK;
    }
    
}