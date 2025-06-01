public class Pelanggan {
    private String nama;
    private String nomorTelepon;
    
    public Pelanggan(String nama, String nomorTelepon) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
    }

    // Getter dan Setter
    public String getNama() { return nama; }
    public String getNomorTelepon() { return nomorTelepon; }
    
    public void setNama(String nama) { this.nama = nama; }
    public void setNomorTelepon(String nomorTelepon) { this.nomorTelepon = nomorTelepon; }
}
