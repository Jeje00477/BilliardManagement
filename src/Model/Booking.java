package Model;

import Model.Pelanggan;
import java.time.LocalDateTime;

public class Booking {
    private Pelanggan pelanggan;
    private LocalDateTime tanggalBooking;
    private int nomorMeja;
    private String tipeMeja;

    public Booking(Pelanggan pelanggan, LocalDateTime tanggalBooking, int nomorMeja, String tipeMeja) {
        this.pelanggan = pelanggan;
        this.tanggalBooking = tanggalBooking;
        this.nomorMeja = nomorMeja;
        this.tipeMeja = tipeMeja;
    }

    // Getter dan Setter
    public Pelanggan getPelanggan() { return pelanggan; }
    public LocalDateTime getTanggalBooking() { return tanggalBooking; }
    public int getNomorMeja() { return nomorMeja; }
    public String getTipeMeja() { return tipeMeja; }
    
    public void setPelanggan(Pelanggan pelanggan) { this.pelanggan = pelanggan; }
    public void setTanggalBooking(LocalDateTime tanggalBooking) { this.tanggalBooking = tanggalBooking; }
    public void setNomorMeja(int nomorMeja) { this.nomorMeja = nomorMeja; }
    public void setTipeMeja(String tipeMeja) { this.tipeMeja = tipeMeja; }
}
